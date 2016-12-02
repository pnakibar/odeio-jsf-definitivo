package beerzeit.model;

import beerzeit.utils.AvatarStorage;
import org.primefaces.component.rating.Rating;
import org.primefaces.model.StreamedContent;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by pedro on 29/11/16.
 */
public class Recipe {

    private int id;
    private Usuario usuario;
    private String name;
    private String description;
    private String style;
    private String statistics;
    private String ingredients;
    private String production;
    private String picture;
    private List<RecipeRating> ratings;
    private StreamedContent pictureToShow;

    public Recipe(int id, Usuario usuario, String name, String description, String style, String statistics, String ingredients, String production, List<RecipeRating> ratings, String picture) {
        this.id = id;
        this.usuario = usuario;
        this.name = name;
        this.description = description;
        this.style = style;
        this.statistics = statistics;
        this.ingredients = ingredients;
        this.production = production;
        this.ratings = ratings;
        this.picture = picture;
    }

    public Recipe(Usuario usuario, String name, String description, String style, String statistics, String ingredients, String production, List<RecipeRating> ratings, String picture) {
        this.usuario = usuario;
        this.name = name;
        this.description = description;
        this.style = style;
        this.statistics = statistics;
        this.ingredients = ingredients;
        this.production = production;
        this.ratings = ratings;
        this.picture = picture;
    }

    public List<RecipeRating> getRatings() {
        return ratings;
    }

    public void setRatings(List<RecipeRating> ratings) {
        this.ratings = ratings;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

    public String getStatistics() {
        return statistics;
    }

    public void setStatistics(String statistics) {
        this.statistics = statistics;
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public float getAverageRating() {
        if (this.getRatings().size() == 0) {
            return 0;
        }
        float average = 0;
        for (RecipeRating rp : this.getRatings()) {
            average += rp.getNota();
        }
        return average / this.getRatings().size();
    }

    public StreamedContent getAvatarToShow() {
        try {
            this.pictureToShow = AvatarStorage.showFile(this.picture);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return pictureToShow;
    }
}
