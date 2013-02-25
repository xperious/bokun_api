package is.bokun.dtos;

/**
 * @author Olafur Gauti Gudmundsson
 */
public class UserCredentialsDto {

    public String email;
    public String password;

    public UserCredentialsDto() {}

    public UserCredentialsDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
