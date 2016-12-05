package beerzeit.model;

import beerzeit.utils.AvatarStorage;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.primefaces.model.StreamedContent;

import java.io.FileNotFoundException;
import java.io.Serializable;

/**
 * Created by pedro on 27/11/16.
 */
public class Usuario implements Serializable{
    private static final long serialVersionUID = 6302793716186024028L;
    private int id;
    private String name;
    private String dateOfBirth;
    private String password;
    private String email;
    private String username;
    private String avatar;
    private StreamedContent avatarToShow;

    public Usuario(String name, String dateOfBirth, String password, String email, String username, String avatar) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.password = password;
        this.email = email;
        this.username = username;
        this.avatar = avatar;
    }

    public Usuario(int id, String name, String dateOfBirth, String password, String email, String username, String avatar) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.password = password;
        this.email = email;
        this.username = username;
        this.avatar = avatar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public StreamedContent getAvatarToShow() {
        try {
            this.avatarToShow = AvatarStorage.showFile(this.avatar);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return avatarToShow;
    }

    public void setAvatarToShow(StreamedContent avatarToShow) {
        this.avatarToShow = avatarToShow;
    }
}
