package beerzeit.beans;

import beerzeit.control.PostsControl;
import beerzeit.model.Post;
import org.primefaces.model.StreamedContent;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pedro on 27/11/16.
 */
@ManagedBean(name="posts")
@ViewScoped
public class PostBean {
    private PostsControl postsControl = new PostsControl();
    private Map<Integer, StreamedContent> pictures = new HashMap<>();

    public List<Post> listAll() {
        try {
            List<Post> posts = postsControl.listPage(0);
            for (Post p: posts) {
                pictures.put(p.getUsuario().getId(), p.getUsuario().getAvatarToShow());
            }
            return posts;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
            return new ArrayList<>();
        }
    }
    public void sendLike(int usuarioid, int postid) throws SQLException, ClassNotFoundException {
        System.out.println("usuarioid " + usuarioid);
        System.out.println("postid " + postid);
        postsControl.insertLike(usuarioid, postid);
    }
    public Map<Integer, StreamedContent> getPictures() {
        return pictures;
    }

    public void setPictures(Map<Integer, StreamedContent> pictures) {
        this.pictures = pictures;
    }
}
