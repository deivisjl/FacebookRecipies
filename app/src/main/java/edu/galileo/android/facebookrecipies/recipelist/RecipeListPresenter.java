package edu.galileo.android.facebookrecipies.recipelist;

import edu.galileo.android.facebookrecipies.entities.Recipe;
import edu.galileo.android.facebookrecipies.recipelist.events.RecipeListEvent;
import edu.galileo.android.facebookrecipies.recipelist.ui.RecipeListView;

/**
 * Created by Usuario_Privado on 08/07/2016.
 */
public interface RecipeListPresenter {
    void onCreate();
    void onDestroy();

    void getRecipes();
    void removeRecipe(Recipe recipe);
    void toggleFavorite(Recipe recipe);
    void onEventMainThread(RecipeListEvent event);

    RecipeListView getView();
}
