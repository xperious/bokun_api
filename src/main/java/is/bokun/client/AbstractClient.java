package is.bokun.client;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;
import com.ning.http.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import is.bokun.dtos.ApiResponse;
import is.bokun.utils.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * Contains common aspects of all the client classes.
 *
 * @author Olafur Gauti Gudmundsson
 */
public abstract class AbstractClient {

    private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";

    protected static final ObjectMapper json = new ObjectMapper();

    protected final AsyncHttpClient asyncClient;
    protected final String host, accessKey, secretKey;

    protected AbstractClient(String host, String accessKey, String secretKey, AsyncHttpClient asyncClient) {
        this.host = host;
        this.asyncClient = asyncClient;
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    /**
     * X-Bokun-Date         : The date the request was created in UTC, formatted as "yyyy-MM-dd HH:mm:ss"
     * X-Bokun-AccessKey    : The access key identifying the caller
     * X-Bokun-Signature    : The HMAC signature to be validated
     *
     * @param r
     */
    protected void addSecurityHeaders(AsyncHttpClient.BoundRequestBuilder r, String method, String uri) {
        r.addHeader("Content-type", "application/json; charset=utf-8");

        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        r.addHeader("X-Bokun-Date", date);
        r.addHeader("X-Bokun-AccessKey", accessKey);

        StringBuilder signatureInput = new StringBuilder();
        signatureInput.append(date);
        signatureInput.append(accessKey);
        signatureInput.append(method);
        signatureInput.append(uri);

        r.addHeader("X-Bokun-Signature", calculateHMAC(secretKey, signatureInput.toString()));
    }

    public static class NVP {
        public String name;
        public String value;

        public NVP(String name, String value) {
            this.name = name;
            this.value = value;
        }
    }

    protected String appendQueryParams(String uri, NVP... params) {
        StringBuilder s = new StringBuilder();
        for (NVP p : params) {
            if ( !StringUtils.isNullOrEmpty(p.value) ) {
                if ( s.length() == 0 ) {
                    s.append('?');
                } else {
                    s.append('&');
                }
                s.append(p.name);
                s.append('=');
                s.append(p.value);
            }
        }
        return uri + s.toString();
    }

    protected String appendLangAndCurrency(String uri, String lang, String currency, NVP... params) {
        List<NVP> list = new ArrayList<NVP>();
        list.add(new NVP("lang",lang));
        list.add(new NVP("currency",currency));
        if ( params != null ) {
            for (NVP p : params) {
                list.add(p);
            }
        }
        return appendQueryParams(uri, list.toArray(new NVP[list.size()]));
    }

    protected String appendLangAndCurrency(String uri, String lang, String currency) {
        return appendLangAndCurrency(uri, lang, currency, null);
    }

    protected void validateResponse(Response r) {
        if ( r.getStatusCode() != 200 ) {
            // try parsing an API response
            try {
                ApiResponse ar = json.readValue(r.getResponseBody("UTF-8"), ApiResponse.class);
                throw new RestServiceException(ar);
            } catch (Exception e) {
                ApiResponse ar = new ApiResponse(r.getStatusText());
                throw new RestServiceException(ar, e);
            }
        }
    }

    protected RestServiceException wrapException(Throwable t) {
        ApiResponse ar = new ApiResponse(t.getMessage());
        return new RestServiceException(ar, t);
    }

    private String calculateHMAC(String secret, String data) {
        try {
            SecretKeySpec signingKey = new SecretKeySpec(secret.getBytes(),	HMAC_SHA1_ALGORITHM);
            Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
            mac.init(signingKey);
            byte[] rawHmac = mac.doFinal(data.getBytes());
            return new String(Base64.encode(rawHmac));
        } catch (GeneralSecurityException e) {
            //("Unexpected error while creating hash: " + e.getMessage(), e);
            throw new IllegalArgumentException();
        }
    }
}
