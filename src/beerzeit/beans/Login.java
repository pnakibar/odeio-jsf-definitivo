package beerzeit.beans;

import beerzeit.control.UserManagement;
import beerzeit.model.Usuario;
import beerzeit.utils.exception.InvalidUserException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.sql.SQLException;

/**
 * Created by pedro on 27/11/16.
 */
@ManagedBean(name="login")
@SessionScoped
public class Login {
    private String email;
    private String password;
    private UserManagement um = new UserManagement();

    public String login() {
        try {
            Usuario u = um.login(this.email, this.password);
            System.out.println(u.getName());
            return "index";
        } catch (SQLException | ClassNotFoundException | InvalidUserException e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Email e/ou senha errado.", ""));
            return "login";
        }
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
