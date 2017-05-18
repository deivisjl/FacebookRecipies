package edu.galileo.android.facebookrecipies.recipemain.ui;

import edu.galileo.android.facebookrecipies.entities.Recipe;

/**
 * Created by Usuario_Privado on 25/06/2016.
 */
public interface RecipeMainRepository {
    public final static int COUNT = 1;
    public final static String RECENT_SORT = "r";
    public final static int RECIPE_RANGE = 1000;

    void getNextRecipe();
    void saveRecipe(Recipe recipe);
    void setRecipePage(int recipePage);
}
