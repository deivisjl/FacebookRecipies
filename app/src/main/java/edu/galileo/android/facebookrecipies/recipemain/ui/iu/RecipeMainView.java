package edu.galileo.android.facebookrecipies.recipemain.ui.iu;

import edu.galileo.android.facebookrecipies.entities.Recipe;

/**
 * Created by Usuario_Privado on 25/06/2016.
 */
public interface RecipeMainView {
    void showProgress();
    void hideProgress();
    void showUIElements();
    void hideUIElements();
    void saveAnimation();
    void dismissAnimation();

    void onRecipeSaved();
    void setRecipe(Recipe recipe);
    void onGetRecipeError(String error);

}
