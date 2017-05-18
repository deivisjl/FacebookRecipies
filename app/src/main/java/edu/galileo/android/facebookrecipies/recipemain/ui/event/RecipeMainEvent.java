package edu.galileo.android.facebookrecipies.recipemain.ui.event;

import edu.galileo.android.facebookrecipies.entities.Recipe;

/**
 * Created by Usuario_Privado on 25/06/2016.
 */
public class RecipeMainEvent {
    private int type;
    private String error;
    private Recipe recipe;

    public final static int NEXT_EVENT =0;
    public final static int SAVE_EVENT =1;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public static int getNextEvent() {
        return NEXT_EVENT;
    }

    public static int getSaveEvent() {
        return SAVE_EVENT;
    }
}
