package beerzeit.model;

import java.util.Date;
import java.util.List;

/**
 * Created by pedro on 27/11/16.
 */
public class Post {
    private int id;
    private Usuario usuario;
    private String message;
    private List<Usuario> likes;
    private Date createdat;

    public Post(Usuario usuario, String message, List<Usuario> likes, Date createdat) {
        this.usuario = usuario;
        this.message = message;
        this.likes = likes;
        this.createdat = createdat;
    }

    public Post(int id, Usuario usuario, String message, List<Usuario> likes, Date createdat) {
        this.id = id;
        this.usuario = usuario;
        this.message = message;
        this.likes = likes;
        this.createdat = createdat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Usuario> getLikes() {
        return likes;
    }

    public void setLikes(List<Usuario> likes) {
        this.likes = likes;
    }

    public Date getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }
}
