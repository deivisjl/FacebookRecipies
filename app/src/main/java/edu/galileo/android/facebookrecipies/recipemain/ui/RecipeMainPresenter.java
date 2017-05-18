package edu.galileo.android.facebookrecipies.recipemain.ui;

import edu.galileo.android.facebookrecipies.entities.Recipe;
import edu.galileo.android.facebookrecipies.recipemain.ui.event.RecipeMainEvent;
import edu.galileo.android.facebookrecipies.recipemain.ui.iu.RecipeMainView;

/**
 * Created by Usuario_Privado on 25/06/2016.
 */
public interface RecipeMainPresenter {
    void onCreate();
    void onDestroy();

    void dismissRecipe();
    void getNextRecipe();
    void saveRecipe(Recipe recipe);
    void onEventMainThread(RecipeMainEvent event);

    void imageReady();
    void imageError(String error);

    RecipeMainView getView();
}
