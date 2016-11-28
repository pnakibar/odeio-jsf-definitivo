package beerzeit.control;

import beerzeit.dao.UsuarioDAO;
import beerzeit.model.Usuario;
import beerzeit.utils.exception.InvalidUserException;

import javax.faces.bean.ManagedBean;
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
}
