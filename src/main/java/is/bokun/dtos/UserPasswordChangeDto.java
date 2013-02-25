package is.bokun.dtos;

/**
 * @author Olafur Gauti Gudmundsson
 */
public class UserPasswordChangeDto {

    public String oldPassword, newPassword;

    public UserPasswordChangeDto() {}

    public UserPasswordChangeDto(String oldPassword, String newPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
