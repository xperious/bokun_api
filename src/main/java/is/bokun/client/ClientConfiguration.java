package is.bokun.client;

import com.ning.http.client.AsyncHttpClient;

/**
 * Common configuration properties for all the web service clients.
 *
 * @author Olafur Gauti Gudmundsson
 */
public class ClientConfiguration {

    private final AsyncHttpClient asyncClient;
    private final String host, accessKey, secretKey;

    /**
     * Constructs an immutable instance of ClientConfiguration.
     *
     * @param host the host where the REST services are running (e.g. "http://api.bokun.is" or "http://localhost:9000")
     * @param accessKey the Access Key as specified in the Bokun API credentials
     * @param secretKey the Secret Key as specified in the Bokun API credentials
     * @param asyncClient instance of the HTTP client to use for the communication
     */
    public ClientConfiguration(String host, String accessKey, String secretKey, AsyncHttpClient asyncClient) {
        this.host = host;
        this.asyncClient = asyncClient;
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    public AsyncHttpClient getAsyncClient() {
        return asyncClient;
    }

    public String getHost() {
        return host;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }
}
