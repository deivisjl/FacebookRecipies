package edu.galileo.android.facebookrecipies.recipemain.ui.di;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import edu.galileo.android.facebookrecipies.api.RecipeClient;
import edu.galileo.android.facebookrecipies.api.RecipeService;
import edu.galileo.android.facebookrecipies.entities.Recipe;
import edu.galileo.android.facebookrecipies.recipemain.ui.GetNextRecipeInteractor;
import edu.galileo.android.facebookrecipies.recipemain.ui.GetNextRecipeInteractorImpl;
import edu.galileo.android.facebookrecipies.recipemain.ui.RecipeMainPresenter;
import edu.galileo.android.facebookrecipies.recipemain.ui.RecipeMainPresenterImpl;
import edu.galileo.android.facebookrecipies.recipemain.ui.RecipeMainRepository;
import edu.galileo.android.facebookrecipies.recipemain.ui.RecipeMainRepositoryImpl;
import edu.galileo.android.facebookrecipies.recipemain.ui.SaveRecipeInteractor;
import edu.galileo.android.facebookrecipies.recipemain.ui.SaveRecipeInteractorImpl;
import edu.galileo.android.facebookrecipies.recipemain.ui.event.RecipeMainEvent;
import edu.galileo.android.facebookrecipies.recipemain.ui.iu.RecipeMainView;

/**
 * Creat
 * ed by Usuario_Privado on 27/06/2016.
 */
@Module
public class RecipeMainModule {
    RecipeMainView view;

    public RecipeMainModule(RecipeMainView view) {
        this.view = view;
    }
    @Provides
    @Singleton
    RecipeMainView providesRecipeMainView(){
        return this.view;
    }
    @Provides
    @Singleton
    RecipeMainPresenter providesRecipeMainPresenter(EventBus eventBus, RecipeMainView view, SaveRecipeInteractor saveInteractor, GetNextRecipeInteractor getNextRecipeInteractor){
        return new RecipeMainPresenterImpl( eventBus, view,  saveInteractor, getNextRecipeInteractor);
    }
    @Provides
    @Singleton
    SaveRecipeInteractor providesSaveRecipeInteractor(RecipeMainRepository repository){
        return new SaveRecipeInteractorImpl(repository);
    }
    @Provides
    @Singleton
    GetNextRecipeInteractor providesGetNextRecipeInteractor(RecipeMainRepository repository){
        return new GetNextRecipeInteractorImpl(repository);
    }
    @Provides
    @Singleton
    RecipeMainRepository providesRecipeMainRepository(EventBus eventBus, RecipeService service){
        return new RecipeMainRepositoryImpl(eventBus, service);
    }
    @Provides
    @Singleton
    RecipeService providesRecipeService(){
        return new RecipeClient().getRecipeService();
    }


}
