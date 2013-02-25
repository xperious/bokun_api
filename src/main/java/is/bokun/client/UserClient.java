package is.bokun.client;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;
import is.bokun.dtos.*;
import is.bokun.utils.StringUtils;

/**
 * @author Olafur Gauti Gudmundsson
 */
public class UserClient extends AbstractClient {

    private static final String BASE = "/user.json";

    public UserClient(String host, String accessKey, String secretKey, AsyncHttpClient asyncClient) {
        super(host, accessKey, secretKey, asyncClient);
    }

    public AuthenticationResponse authenticate(String email, String password) {
        return authenticate(email, password, null);
    }

    public AuthenticationResponse authenticate(String email, String password, String sessionId) {
        String uri = BASE + "/authenticate";
        if ( !StringUtils.isNullOrEmpty(sessionId) ) {
            uri += "?sessionId=" + sessionId;
        }
        UserCredentialsDto dto = new UserCredentialsDto(email, password);
        return postUser(uri, dto);
    }

    public AuthenticationResponse createUserAccount(UserAccountDto userAccount, String sessionId) {
        String uri = BASE + "/new";
        if ( !StringUtils.isNullOrEmpty(sessionId) ) {
            uri += "?sessionId=" + sessionId;
        }
        return postUser(uri, userAccount);
    }

    private AuthenticationResponse postUser(String uri, Object body) {
        try {
            AsyncHttpClient.BoundRequestBuilder b = asyncClient.preparePost(host + uri);
            addSecurityHeaders(b, "POST", uri);
            b.setBodyEncoding("UTF-8");
            b.setBody(json.writeValueAsString(body));

            Response r = b.execute().get();
            validateResponse(r);
            return json.readValue(r.getResponseBody("UTF-8"), AuthenticationResponse.class);
        } catch (Exception e) {
            throw wrapException(e);
        }
    }

    public UserAccountDto getUserAccount(String securityToken) {
        String uri = BASE + "/" + securityToken;
        return getUser(uri);
    }

    public UserAccountDto updateUserAccount(String securityToken, String firstName, String lastName) {
        String uri = BASE + "/" + securityToken + "/update-details";
        try {
            UserAccountDto dto = new UserAccountDto();
            dto.firstName = firstName;
            dto.lastName = lastName;

            AsyncHttpClient.BoundRequestBuilder b = asyncClient.preparePost(host + uri);
            addSecurityHeaders(b, "POST", uri);
            b.setBodyEncoding("UTF-8");
            b.setBody(json.writeValueAsString(dto));

            Response r = b.execute().get();
            validateResponse(r);
            return json.readValue(r.getResponseBody("UTF-8"), UserAccountDto.class);
        } catch (Exception e) {
            throw wrapException(e);
        }
    }

    public BooleanResponse usernameExists(String securityToken, String email) {
        String uri = BASE + "/username-exists?securityToken=" + securityToken + "&email=" + email;
        try {
            AsyncHttpClient.BoundRequestBuilder b = asyncClient.prepareGet(host + uri);
            addSecurityHeaders(b, "GET", uri);

            Response r = b.execute().get();
            validateResponse(r);
            return json.readValue(r.getResponseBody("UTF-8"), BooleanResponse.class);
        } catch (Exception e) {
            throw wrapException(e);
        }
    }

    public UserAccountDto changeUsername(String securityToken, String newEmail) {
        String uri = BASE + "/" + securityToken + "/change-username?newEmail=" + newEmail;
        return getUser(uri);
    }

    public UserAccountDto changePassword(String securityToken, String oldPassword, String newPassword) {
        String uri = BASE + "/" + securityToken + "/change-password";
        UserPasswordChangeDto dto = new UserPasswordChangeDto(oldPassword, newPassword);
        try {
            AsyncHttpClient.BoundRequestBuilder b = asyncClient.preparePost(host + uri);
            addSecurityHeaders(b, "POST", uri);
            b.setBodyEncoding("UTF-8");
            b.setBody(json.writeValueAsString(dto));

            Response r = b.execute().get();
            validateResponse(r);
            return json.readValue(r.getResponseBody("UTF-8"), UserAccountDto.class);
        } catch (Exception e) {
            throw wrapException(e);
        }
    }

    private UserAccountDto getUser(String uri) {
        try {
            AsyncHttpClient.BoundRequestBuilder b = asyncClient.prepareGet(host + uri);
            addSecurityHeaders(b, "GET", uri);

            Response r = b.execute().get();
            validateResponse(r);
            return json.readValue(r.getResponseBody("UTF-8"), UserAccountDto.class);
        } catch (Exception e) {
            throw wrapException(e);
        }
    }
}
