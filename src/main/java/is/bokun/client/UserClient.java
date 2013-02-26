package is.bokun.client;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;
import is.bokun.dtos.*;
import is.bokun.utils.StringUtils;

/**
 * Client for the User resource.
 *
 * @author Olafur Gauti Gudmundsson
 */
public class UserClient extends AbstractClient {

    private static final String BASE = "/user.json";

    /**
     * @see AbstractClient#()
     *
     * @param host
     * @param accessKey
     * @param secretKey
     * @param asyncClient
     */
    public UserClient(String host, String accessKey, String secretKey, AsyncHttpClient asyncClient) {
        super(host, accessKey, secretKey, asyncClient);
    }

    /**
     * Try to authenticate a user.
     *
     * @param email the user's email address
     * @param password the user's password
     * @return the user account, along with an expiring security token which should be used to access the user's data
     */
    public AuthenticationResponse authenticate(String email, String password) {
        return authenticate(email, password, null);
    }

    /**
     * Try to authenticate a user, supplying a session ID. This is the ID of the session the user had
     * before logging in. If this parameter is supplied, the session cart will be merged into the user's
     * shopping cart on successful login.
     *
     * @param email the user's email address
     * @param password the user's password
     * @param sessionId the ID of the session
     * @return the user account, along with an expiring security token which should be used to access the user's data
     */
    public AuthenticationResponse authenticate(String email, String password, String sessionId) {
        String uri = BASE + "/authenticate";
        if ( !StringUtils.isNullOrEmpty(sessionId) ) {
            uri += "?sessionId=" + sessionId;
        }
        UserCredentialsDto dto = new UserCredentialsDto(email, password);
        return postUser(uri, dto);
    }

    /**
     * Create a new user account, optionally supplying a session ID. This is the ID of the session the user had
     * before logging in. If this parameter is supplied, the session cart will be merged into the user's
     * shopping cart on successful login.
     *
     * @param userAccount the details of the user account to create
     * @param sessionId the optional session ID
     * @return the newly created user account, along with an expiring security token for further communication
     */
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

    /**
     * Get details of the user currently logged in.
     *
     * @param securityToken the token received by the user on authentication
     * @return details of the user account
     */
    public UserAccountDto getUserAccount(String securityToken) {
        String uri = BASE + "/" + securityToken;
        return getUser(uri);
    }

    /**
     * Update the first and last name of the user.
     *
     * @param securityToken the token received by the user on authentication
     * @param firstName the user's new first name
     * @param lastName the user's new last name
     * @return the updated user account
     */
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

    /**
     * Check if a username exists.
     *
     * @param securityToken the token received by the user on authentication
     * @param email the username to check for existence
     * @return a simple Boolean response indicating whether the username exists
     */
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

    /**
     * Change the username of the current user.
     *
     * @param securityToken the token received by the user on authentication
     * @param newEmail the new username
     * @return the updated user account
     */
    public UserAccountDto changeUsername(String securityToken, String newEmail) {
        String uri = BASE + "/" + securityToken + "/change-username?newEmail=" + newEmail;
        return getUser(uri);
    }

    /**
     * Change the password of the current user. This requires supplying the old password.
     *
     * @param securityToken the token received by the user on authentication
     * @param oldPassword the old password
     * @param newPassword the new password
     * @return the update user account
     */
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
