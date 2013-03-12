package is.bokun.dtos;

/**
 * @author Olafur Gauti Gudmundsson
 */
public class CustomerCredentialsDto {

    public String username;
    public String password;

    public CustomerCredentialsDto() {}

    public CustomerCredentialsDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
