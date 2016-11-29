package beerzeit.control;

import beerzeit.dao.RecipeDAO;
import beerzeit.dao.UsuarioDAO;
import beerzeit.model.Recipe;
import beerzeit.model.RecipeRating;
import beerzeit.model.Usuario;
import beerzeit.utils.AvatarStorage;
import beerzeit.utils.exception.InvalidRatingException;
import org.primefaces.model.UploadedFile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedro on 29/11/16.
 */
public class RecipeControl {
    private RecipeDAO recipeDAO = new RecipeDAO();
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    public void insertRating(int userId, int beerRecipeId, int rating) throws SQLException, ClassNotFoundException, InvalidRatingException {
        if (rating > 0 && rating < 6) {
            recipeDAO.insertRating(userId, beerRecipeId, rating);
        }
        throw new InvalidRatingException();
    }

    public List<Recipe> list(int page) throws SQLException, ClassNotFoundException {
        return recipeDAO.list(page);
    }

    public void insertRecipe(int userid, String name, String description, String style, String statstics, String ingredients, String production, UploadedFile picture) throws SQLException, ClassNotFoundException, IOException {
        String picturename = AvatarStorage.save(picture, "picture/" + name);
        recipeDAO.insertRecipe(
                new Recipe(
                        usuarioDAO.getUserById(userid),
                        name,
                        description,
                        style,
                        statstics,
                        ingredients,
                        production,
                        new ArrayList<>(),
                        picturename
                )
        );
    }
}
