package beerzeit.beans;

import beerzeit.control.RecipeControl;
import beerzeit.utils.AvatarStorage;
import beerzeit.utils.SessionUtils;
import org.primefaces.model.UploadedFile;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by pedro on 30/11/16.
 */
@ManagedBean(name = "newrecipe")
@SessionScoped
public class NewRecipeBean {
    RecipeControl recipeControl = new RecipeControl();
    private String name;
    private String description;
    private String style;
    private String statstics;
    private String ingredients;
    private String production;
    private UploadedFile file;
    public UploadedFile getFile() {
        return file;
    }
    private boolean canSubmit = false;

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public String createRecipe() throws Exception {
        try {
            if (file != null) {
                recipeControl.insertRecipe(
                        new Integer(SessionUtils.getUserId()),
                        name,
                        description,
                        style,
                        statstics,
                        ingredients,
                        production,
                        file
                );
                name = null;
                description = null;
                style = null;
                statstics = null;
                ingredients = null;
                production = null;
                file = null;
                return "sucess";
            }
            else {
                FacesContext.getCurrentInstance().addMessage("btn-newrecipe", new FacesMessage(FacesMessage.SEVERITY_INFO, "Insira uma foto!", ""));
            }
        } catch (SQLException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Já existe uma cerveja com esse nome.", ""));
        }
        return "CHUPA MEU PAU FILHO DA PUTA";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getStatstics() {
        return statstics;
    }

    public void setStatstics(String statstics) {
        this.statstics = statstics;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public boolean isDisabled() {
        if (this.name == null){
            System.out.println("name");
            return true;
        }
        if (this.description == null){
            System.out.println("description");
            return true;
        }
        if (this.style == null){
            System.out.println("style");
            return true;
        }
        if (this.statstics == null){
            System.out.println("statistcs");
            return true;
        }
        if (this.ingredients == null){
            System.out.println("ingredientes");
            return true;
        }
        if (this.production == null){
            System.out.println("production");
            return true;
        }

        return false;
    }
}
