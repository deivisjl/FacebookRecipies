package edu.galileo.android.facebookrecipies.recipelist.di;

import javax.inject.Singleton;

import dagger.Component;
import edu.galileo.android.facebookrecipies.libs.di.LibsModule;
import edu.galileo.android.facebookrecipies.recipelist.RecipeListPresenter;
import edu.galileo.android.facebookrecipies.recipelist.ui.adapters.RecipeAdapter;
import edu.galileo.android.facebookrecipies.recipemain.ui.RecipeMainPresenter;

/**
 * Created by Usuario_Privado on 11/07/2016.
 */
@Singleton
@Component(modules ={RecipeListModule.class, LibsModule.class})
public interface RecipeListComponent {
    RecipeAdapter getAdapter();
    RecipeListPresenter getPresenter();
}
