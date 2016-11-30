package beerzeit.beans;

import beerzeit.control.RecipeControl;
import beerzeit.model.Recipe;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by pedro on 30/11/16.
 */
@ManagedBean(name = "recipes")
@SessionScoped
public class RecipesBean {
    RecipeControl recipeControl = new RecipeControl();
    public List<Recipe> list() throws SQLException, ClassNotFoundException {
        return recipeControl.list(0);
    }
}
