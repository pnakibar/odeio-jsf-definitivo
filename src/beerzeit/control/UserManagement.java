package beerzeit.control;

import beerzeit.dao.UsuarioDAO;
import beerzeit.model.Usuario;
import beerzeit.utils.AvatarStorage;
import beerzeit.utils.exception.InvalidUserException;
import org.primefaces.model.UploadedFile;

import javax.faces.bean.ManagedBean;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by pedro on 27/11/16.
 */

public class UserManagement {
    UsuarioDAO ud = new UsuarioDAO();
    public Usuario login(String email, String password) throws SQLException, ClassNotFoundException, InvalidUserException {
        Usuario u = ud.getUser(email);
        if (u.getPassword().contentEquals(password)) {
            return u;
        }
        throw new InvalidUserException();
    }

    public Usuario create(Usuario u) throws SQLException, ClassNotFoundException {
        ud.inserir(u);
        return u;
    }

    public Usuario update(Usuario oldUsuario, String newName, String newEmail, String newUsername, String newPassword, UploadedFile newAvatar) throws Exception {
        if (newName != null && newName.length() > 0) {
            oldUsuario.setName(newName);
        }
        if (newUsername != null && newUsername.length() > 0) {
            oldUsuario.setUsername(newUsername);
        }
        if (newEmail != null && newEmail.length() > 0) {
            oldUsuario.setEmail(newEmail);
        }
        if (newPassword != null && newPassword.length() > 0) {
            oldUsuario.setPassword(newPassword);
        }

        if (newAvatar != null) {
            oldUsuario.setAvatar(AvatarStorage.save(newAvatar, oldUsuario.getUsername()));
        }

        ud.update(oldUsuario);

        return oldUsuario;
    }
}
