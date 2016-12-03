package beerzeit.dao;

import beerzeit.model.Post;
import beerzeit.model.Recipe;
import beerzeit.model.RecipeRating;
import beerzeit.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedro on 27/11/16.
 */
public class RecipeDAO extends DAO{
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    public void insertRating(int userid, int recipeId, int rating) throws SQLException, ClassNotFoundException {
        this.open();
        PreparedStatement stmt = this.conn.prepareStatement(
                "INSERT INTO beer_recipe_rating(usuario, beer_recipe, rating) VALUES (?, ?, ?);"
        );
        stmt.setInt(1, userid);
        stmt.setInt(2, recipeId);
        stmt.setInt(3, rating);
        stmt.execute();
        this.close();
    }

    public Recipe getRecipe(int recipeid) throws SQLException, ClassNotFoundException {
        this.open();
        PreparedStatement stmt = this.conn.prepareStatement(
                "SELECT * FROM beer_recipe WHERE id = ?;"
        );
        stmt.setInt(1, recipeid);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        int postId = rs.getInt("id");
        Recipe recipe = new Recipe(
                postId,
                usuarioDAO.getUserById(rs.getInt("usuario")),
                rs.getString("name"),
                rs.getString("description"),
                rs.getString("style"),
                rs.getString("statistics"),
                rs.getString("ingredients"),
                rs.getString("production"),
                this.getRatings(postId),
                rs.getString("picture")
        );

        this.close();
        return recipe;
    }

    private List<RecipeRating> getRatings(int beerRecipeId) throws SQLException, ClassNotFoundException {
        this.open();
        PreparedStatement stmt = this.conn.prepareStatement(
                "SELECT * " +
                "FROM beer_recipe_rating brr " +
                "WHERE brr.beer_recipe = ?;"
        );

        stmt.setInt(1, beerRecipeId);
        ResultSet rs = stmt.executeQuery();

        List<RecipeRating> recipeRatings = new ArrayList<>();
        while (rs.next()) {
            recipeRatings.add(
                    new RecipeRating(
                        usuarioDAO.getUserById(rs.getInt("usuario")),
                        rs.getInt("rating")
                    )
            );
        }
        this.close();
        return recipeRatings;
    }

    public List<Recipe> list(int page) throws SQLException, ClassNotFoundException {
        this.open();
        List<Recipe> recipes = new ArrayList<>();
        PreparedStatement stmt = this.conn.prepareStatement(
                "SELECT * FROM beer_recipe ORDER BY id DESC LIMIT 15 OFFSET " + (page * 15) + ";"
        );
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            int postId = rs.getInt("id");
            recipes.add(
                    new Recipe(
                        postId,
                        usuarioDAO.getUserById(rs.getInt("usuario")),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("style"),
                        rs.getString("statistics"),
                        rs.getString("ingredients"),
                        rs.getString("production"),
                        this.getRatings(postId),
                        rs.getString("picture")
                    )
            );

        }
        this.close();
        return recipes;
    }
    public void insertRecipe(Recipe recipe) throws SQLException, ClassNotFoundException {
        this.open();
        PreparedStatement stmt = this.conn.prepareStatement(
                "INSERT INTO public.beer_recipe(\n" +
                        "            usuario, name, description, style, statistics, ingredients, \n" +
                        "            production, picture )\n" +
                        "    VALUES (?, ?, ?, ?, ?, ?, ?, ?);"
        );
        stmt.setInt(1, recipe.getUsuario().getId());
        stmt.setString(2, recipe.getName());
        stmt.setString(3, recipe.getDescription());
        stmt.setString(4, recipe.getStyle());
        stmt.setString(5, recipe.getStatistics());
        stmt.setString(6, recipe.getIngredients());
        stmt.setString(7, recipe.getProduction());
        stmt.setString(8, recipe.getPicture());
        stmt.execute();

        this.close();
    }
}
