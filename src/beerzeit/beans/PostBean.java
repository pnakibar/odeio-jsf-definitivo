package beerzeit.beans;

import beerzeit.control.PostsControl;
import beerzeit.model.Post;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedro on 27/11/16.
 */
@ManagedBean(name="posts")
@ViewScoped
public class PostBean {
    PostsControl postsControl = new PostsControl();
    public List<Post> listAll() {
        try {
            return postsControl.listPage(0);
        } catch (SQLException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}
