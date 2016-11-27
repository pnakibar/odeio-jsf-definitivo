package beerzeit.model;

/**
 * Created by pedro on 27/11/16.
 */
public class Usuario {
    private String name;
    private String dateOfBirth;
    private String password;
    private String email;

    public Usuario(String name, String dateOfBirth, String password, String email) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.password = password;
        this.email = email;
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
}
