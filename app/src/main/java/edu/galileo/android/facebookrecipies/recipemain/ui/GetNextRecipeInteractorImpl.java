package edu.galileo.android.facebookrecipies.recipemain.ui;

import java.util.Random;

/**
 * Created by Usuario_Privado on 27/06/2016.
 */
public class GetNextRecipeInteractorImpl implements  GetNextRecipeInteractor{
    RecipeMainRepository repository;

    public GetNextRecipeInteractorImpl(RecipeMainRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        int recipePage = new Random().nextInt(RecipeMainRepository.RECIPE_RANGE);
        repository.setRecipePage(recipePage);
        repository.getNextRecipe();
    }
}
