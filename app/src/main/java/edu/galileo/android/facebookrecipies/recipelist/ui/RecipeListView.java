package edu.galileo.android.facebookrecipies.recipelist.ui;

import java.util.List;

import edu.galileo.android.facebookrecipies.entities.Recipe;

/**
 * Created by Usuario_Privado on 08/07/2016.
 */
public interface RecipeListView {
    void setRecipes(List<Recipe> data);
    void recipeUpdate();
    void recipeDeleted(Recipe recipe);
}
