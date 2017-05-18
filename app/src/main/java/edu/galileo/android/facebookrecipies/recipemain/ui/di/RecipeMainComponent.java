package edu.galileo.android.facebookrecipies.recipemain.ui.di;

import javax.inject.Singleton;

import dagger.Component;
import edu.galileo.android.facebookrecipies.libs.base.ImageLoader;
import edu.galileo.android.facebookrecipies.libs.di.LibsModule;
import edu.galileo.android.facebookrecipies.recipemain.ui.RecipeMainPresenter;
import edu.galileo.android.facebookrecipies.recipemain.ui.iu.RecipeMainActivity;

/**
 * Created by Usuario_Privado on 27/06/2016.
 */
@Singleton
@Component(modules = {RecipeMainModule.class, LibsModule.class})
public interface RecipeMainComponent {
   // void inject(RecipeMainActivity activity);
    ImageLoader getImageLoader();
    RecipeMainPresenter getPresenter();
}
