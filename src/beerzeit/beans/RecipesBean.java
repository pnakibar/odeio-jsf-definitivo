package beerzeit.beans;

import beerzeit.control.RecipeControl;
import beerzeit.model.Recipe;
import beerzeit.utils.exception.InvalidRatingException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by pedro on 30/11/16.
 */
@ManagedBean(name = "recipes")
@SessionScoped
public class RecipesBean implements Serializable{
    private static final long serialVersionUID = 6365342326524677975L;
    private RecipeControl recipeControl = new RecipeControl();
    private Recipe selectedRecipe;

    public String selectRecipe(Object r) {
        this.selectedRecipe = (Recipe) r;
        System.out.println(this.selectedRecipe.getName());
        return "recipe.xhtml";
    }

    public String voteRecipe(Recipe r, int userid, int rating) throws SQLException, InvalidRatingException, ClassNotFoundException {
        recipeControl.insertRating(userid, r.getId(), rating);
        selectedRecipe = recipeControl.getRecipe(selectedRecipe.getId());
        return "recipe.xhtml";
    }

    public List<Recipe> list() throws SQLException, ClassNotFoundException {
        return recipeControl.list(0);
    }


    public Recipe getSelectedRecipe() {
        return selectedRecipe;
    }

    public void setSelectedRecipe(Recipe selectedRecipe) {
        this.selectedRecipe = selectedRecipe;
    }
}
