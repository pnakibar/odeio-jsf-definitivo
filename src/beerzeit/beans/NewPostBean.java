package beerzeit.beans;

import beerzeit.control.PostsControl;
import beerzeit.utils.SessionUtils;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.SQLException;

/**
 * Created by pedro on 28/11/16.
 */
@ManagedBean(name = "newpost")
@SessionScoped
public class NewPostBean {
    private String message;
    private PostsControl postsControl = new PostsControl();

    public String sendPost() throws SQLException, ClassNotFoundException {
        postsControl.sendPost(new Integer(SessionUtils.getUserId()), getMessage());
        this.message = null;
        return "index";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        System.out.println(message);
        this.message = message;
    }
}
