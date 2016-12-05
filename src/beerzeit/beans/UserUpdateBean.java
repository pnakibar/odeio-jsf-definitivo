package beerzeit.beans;

import beerzeit.control.UserManagement;
import beerzeit.model.Usuario;
import org.primefaces.model.UploadedFile;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

/**
 * Created by pedro on 05/12/16.
 */
@SessionScoped
@ManagedBean(name="userupdate")
public class UserUpdateBean implements Serializable{
    private static final long serialVersionUID = 2457136122684217087L;
    @ManagedProperty(value="#{user}")
    private UserBean userBean;
    private UserManagement userManagement = new UserManagement();
    private String newName;
    private String newEmail;
    private String newUsername;
    private String newPassword;
    private UploadedFile newAvatar;


    public void updateUser() throws Exception {
        Usuario updatedUser = userManagement.update(
                userBean.getUsuario(),
                newName,
                newEmail,
                newUsername,
                newPassword,
                newAvatar
        );

        userBean.setUsuario(updatedUser);
        newName = null;
        newEmail = null;
        newUsername = null;
        newPassword = null;
        newAvatar = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualizado com sucesso!", ""));
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }

    public String getNewUsername() {
        return newUsername;
    }

    public void setNewUsername(String newUsername) {
        this.newUsername = newUsername;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public UploadedFile getNewAvatar() {
        return newAvatar;
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public void setNewAvatar(UploadedFile newAvatar) {
        this.newAvatar = newAvatar;


    }
}
