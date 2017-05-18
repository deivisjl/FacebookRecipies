package edu.galileo.android.facebookrecipies.recipelist.di;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


import edu.galileo.android.facebookrecipies.entities.Recipe;
import edu.galileo.android.facebookrecipies.libs.base.EventBus;
import edu.galileo.android.facebookrecipies.libs.base.ImageLoader;
import edu.galileo.android.facebookrecipies.recipelist.RecipeListInteractor;
import edu.galileo.android.facebookrecipies.recipelist.RecipeListInteractorImpl;
import edu.galileo.android.facebookrecipies.recipelist.RecipeListPresenter;
import edu.galileo.android.facebookrecipies.recipelist.RecipeListPresenterImpl;
import edu.galileo.android.facebookrecipies.recipelist.RecipeListRepository;
import edu.galileo.android.facebookrecipies.recipelist.RecipeListRepositoryImpl;
import edu.galileo.android.facebookrecipies.recipelist.StoredRecipesInteractorImpl;
import edu.galileo.android.facebookrecipies.recipelist.StoredrecipesInteractor;
import edu.galileo.android.facebookrecipies.recipelist.ui.RecipeListView;
import edu.galileo.android.facebookrecipies.recipelist.ui.adapters.OnItemClickListener;
import edu.galileo.android.facebookrecipies.recipelist.ui.adapters.RecipeAdapter;


/**
 * Created by Usuario_Privado on 11/07/2016.
 */
@Module
public class RecipeListModule {
    RecipeListView view;
    OnItemClickListener clickListener;

    public RecipeListModule(RecipeListView view, OnItemClickListener clickListener) {
        this.view = view;
        this.clickListener = clickListener;
    }

    @Provides
    @Singleton
    RecipeListView providesRecipeListView(){return this.view;}

    @Provides
    @Singleton
    RecipeListPresenter providesRecipeListPresenter(EventBus eventBus, RecipeListView view, RecipeListInteractor listInteractor, StoredrecipesInteractor storedInteractor){
        return new RecipeListPresenterImpl(eventBus,view,listInteractor,storedInteractor);
    }
    @Provides
    @Singleton
    StoredrecipesInteractor providesStoredrecipesInteractor(RecipeListRepository repository){
        return new StoredRecipesInteractorImpl(repository);
    }
    @Provides
    @Singleton
    RecipeListInteractor providesRecipeListInteractor(RecipeListRepository repository){
        return new RecipeListInteractorImpl(repository);
    }
    @Provides
    @Singleton
    RecipeListRepository providesRecipeListRepository(EventBus eventBus){
        return new RecipeListRepositoryImpl(eventBus);
    }
    @Provides
    @Singleton
    RecipeAdapter providesRecipeAdapter(List<Recipe> recipeList, ImageLoader imageLoader, OnItemClickListener onItemClickLister){
        return new RecipeAdapter(recipeList,imageLoader,onItemClickLister);
    }
    @Provides
    @Singleton
    OnItemClickListener providesOnItemClickListener(){return this.clickListener;}

    @Provides
    @Singleton
    List<Recipe> providesEmptyList(){return new ArrayList<Recipe>();}
}
