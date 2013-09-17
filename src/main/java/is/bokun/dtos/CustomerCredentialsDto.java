package is.bokun.dtos;

import javax.xml.bind.annotation.*;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * @author Olafur Gauti Gudmundsson
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "customerCredentials")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerCredentialsDto {

    public String username;
    
    @XmlTransient
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
