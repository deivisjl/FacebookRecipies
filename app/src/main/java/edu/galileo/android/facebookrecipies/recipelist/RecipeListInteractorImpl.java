package edu.galileo.android.facebookrecipies.recipelist;

/**
 * Created by Usuario_Privado on 11/07/2016.
 */
public class RecipeListInteractorImpl implements RecipeListInteractor{
    private RecipeListRepository repository;

    public RecipeListInteractorImpl(RecipeListRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        repository.getSavedRecipes();
    }
}
