package edu.galileo.android.facebookrecipies.recipemain.ui;

import edu.galileo.android.facebookrecipies.entities.Recipe;

/**
 * Created by Usuario_Privado on 27/06/2016.
 */
public class SaveRecipeInteractorImpl implements SaveRecipeInteractor {
    RecipeMainRepository repository;

    public SaveRecipeInteractorImpl(RecipeMainRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(Recipe recipe) {
        repository.saveRecipe(recipe);
    }
}
