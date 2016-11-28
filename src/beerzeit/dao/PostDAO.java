package beerzeit.dao;

import beerzeit.model.Post;
import beerzeit.model.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by pedro on 27/11/16.
 */
public class PostDAO extends DAO{
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private List<Usuario> getLikes(String postId) throws SQLException, ClassNotFoundException {
        this.open();
        PreparedStatement stmt = this.conn.prepareStatement(
                "SELECT u.* " +
                "FROM likes l " +
                "INNER JOIN usuario u ON l.usuario = u.id " +
                "WHERE l.post like ?;"
        );

        stmt.setString(1, postId);
        ResultSet rs = stmt.executeQuery();

        List<Usuario> usersWhoLiked = new ArrayList<>();
        while (rs.next()) {
            usersWhoLiked.add(
                new Usuario(
                        rs.getString("name"),
                        rs.getString("dateofbirth"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("username"),
                        rs.getString("avatar")
                )
            );
        }
        this.close();
        return usersWhoLiked;
    }

    public List<Post> list(int page) throws SQLException, ClassNotFoundException {
        this.open();
        List<Post> posts = new ArrayList<>();
        PreparedStatement stmt = this.conn.prepareStatement(
                "SELECT * FROM post LIMIT 15 OFFSET " + (page * 15) + ";"
        );
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            String postId = rs.getString("id");
            posts.add(
                    new Post(
                        postId,
                        usuarioDAO.getUserById(rs.getString("usuario")),
                        rs.getString("message"),
                        this.getLikes(postId),
                        new Date(new Timestamp(rs.getLong("createdat")).getTime())
                    )
            );

        }
        this.close();
        return posts;
    }
}
