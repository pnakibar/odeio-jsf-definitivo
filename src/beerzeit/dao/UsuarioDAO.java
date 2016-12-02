package beerzeit.dao;

import beerzeit.model.Usuario;
import beerzeit.utils.exception.InvalidUserException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO extends DAO{
    public void inserir(Usuario u) throws ClassNotFoundException, SQLException {
        this.open();
        PreparedStatement stmt = this.conn.prepareStatement(
                "INSERT INTO public.usuario(name, email, password, dateofbirth, username, avatar) VALUES (?, ?, ?, ?, ?, ?);"
        );

        stmt.setString(1, u.getName());
        stmt.setString(2, u.getEmail());
        stmt.setString(3, u.getPassword());
        stmt.setString(4, u.getDateOfBirth());
        stmt.setString(5, u.getUsername());
        stmt.setString(6, u.getAvatar());
        stmt.execute();
        this.close();
    }

    public Usuario getUser(String email) throws SQLException, ClassNotFoundException {
        this.open();
        PreparedStatement stmt = this.conn.prepareStatement(
                "SELECT id, email, password, name, dateofbirth, username, avatar FROM public.usuario WHERE email like ?"
        );
        stmt.setString(1, email);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        this.close();
        return new Usuario(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("dateofbirth"),
                rs.getString("password"),
                rs.getString("email"),
                rs.getString("username"),
                rs.getString("avatar")
        );
    }

    public Usuario getUserById(int id) throws SQLException, ClassNotFoundException {
        this.open();
        PreparedStatement stmt = this.conn.prepareStatement(
                "SELECT id, email, password, name, dateofbirth, username, avatar FROM public.usuario WHERE id = ?"
        );
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        this.close();

        return new Usuario(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("dateofbirth"),
                rs.getString("password"),
                rs.getString("email"),
                rs.getString("username"),
                rs.getString("avatar")
        );
    }
}
