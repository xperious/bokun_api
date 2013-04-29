package is.bokun.client;

import com.google.inject.Inject;
import is.bokun.dtos.*;
import is.bokun.utils.StringUtils;

/**
 * Client for the Customer resource.
 *
 * @author Olafur Gauti Gudmundsson
 */
public class CustomerClient extends AbstractClient {

    private static final String BASE = "/customer.json";

    /**
     * @see AbstractClient#()
     *
     * @param config
     */
    @Inject
    public CustomerClient(ClientConfiguration config) {
        super(config);
    }

    /**
     * Try to authenticate a customer.
     *
     * @param username the customer's username
     * @param password the customer's password
     * @return the customer account, along with an expiring security token which should be used to access the customer's data
     */
    public AuthenticationResponse authenticate(String username, String password) {
        return authenticate(username, password, null);
    }

    /**
     * Try to authenticate a customer, supplying a session ID. This is the ID of the session the customer had
     * before logging in. If this parameter is supplied, the session cart will be merged into the customer's
     * shopping cart on successful login.
     *
     * @param username the customer's username
     * @param password the customer's password
     * @param sessionId the ID of the session
     * @return the customer account, along with an expiring security token which should be used to access the customer's data
     */
    public AuthenticationResponse authenticate(String username, String password, String sessionId) {
        String uri = BASE + "/authenticate";
        if ( !StringUtils.isNullOrEmpty(sessionId) ) {
            uri += "?sessionId=" + sessionId;
        }
        CustomerCredentialsDto dto = new CustomerCredentialsDto(username, password);
        return postCustomer(uri, dto);
    }

    /**
     * Create a new customer account, optionally supplying a session ID. This is the ID of the session the customer had
     * before logging in. If this parameter is supplied, the session cart will be merged into the customer's
     * shopping cart on successful login.
     *
     * @param customerAccount the details of the customer account to create
     * @param sessionId the optional session ID
     * @return the newly created customer account, along with an expiring security token for further communication
     */
    public AuthenticationResponse createUserAccount(CustomerDto customerAccount, String sessionId) {
        String uri = BASE + "/new";
        if ( !StringUtils.isNullOrEmpty(sessionId) ) {
            uri += "?sessionId=" + sessionId;
        }
        return postCustomer(uri, customerAccount);
    }

    private AuthenticationResponse postCustomer(String uri, Object body) {
        return postAndValidate(uri, body, AuthenticationResponse.class);
    }

    /**
     * Get details of the customer currently logged in.
     *
     * @param securityToken the token received by the customer on authentication
     * @return details of the customer account
     */
    public CustomerDto getCustomerAccount(String securityToken) {
        String uri = BASE + "/" + securityToken;
        return getCustomer(uri);
    }

    /**
     * Update the first and last name of the customer.
     *
     * @param securityToken the token received by the customer on authentication
     * @param details the new details
     * @return the updated customer account
     */
    public CustomerDto updateCustomerDetails(String securityToken, CustomerDto details) {
        String uri = BASE + "/" + securityToken + "/update-details";
        return postAndValidate(uri, details, CustomerDto.class);
    }

    /**
     * Check if a username exists.
     *
     * @param username the username to check for existence
     * @return a simple Boolean response indicating whether the username exists
     */
    public BooleanResponse usernameExists(String username) {
    	return usernameExists(null, username);
    }
    
    /**
     * Check if a username exists.
     *
     * @param securityToken the token received by the customer on authentication. This parameter is optional.
     * @param username the username to check for existence
     * @return a simple Boolean response indicating whether the username exists
     */
    public BooleanResponse usernameExists(String securityToken, String username) {
        String uri = BASE + "/username-exists?username=" + username;
        if ( !StringUtils.isNullOrEmpty(securityToken) ) {
        	uri += "&securityToken=" + securityToken;
        }
        return getAndValidate(uri, BooleanResponse.class);
    }

    /**
     * Change the username of the current customer.
     *
     * @param securityToken the token received by the customer on authentication
     * @param newUsername the new username
     * @return the updated customer account
     */
    public CustomerDto changeUsername(String securityToken, String newUsername) {
        String uri = BASE + "/" + securityToken + "/change-username?newUsername=" + newUsername;
        return getCustomer(uri);
    }

    /**
     * Change the password of the current customer. This requires supplying the old password.
     *
     * @param securityToken the token received by the customer on authentication
     * @param oldPassword the old password
     * @param newPassword the new password
     * @return the update customer account
     */
    public CustomerDto changePassword(String securityToken, String oldPassword, String newPassword) {
        String uri = BASE + "/" + securityToken + "/change-password";
        CustomerPasswordChangeDto dto = new CustomerPasswordChangeDto(oldPassword, newPassword);
        return postAndValidate(uri, dto, CustomerDto.class);
    }

    private CustomerDto getCustomer(String uri) {
        return getAndValidate(uri, CustomerDto.class);
    }
}
