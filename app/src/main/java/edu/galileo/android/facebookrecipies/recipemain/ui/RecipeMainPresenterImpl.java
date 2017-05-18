package edu.galileo.android.facebookrecipies.recipemain.ui;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import edu.galileo.android.facebookrecipies.entities.Recipe;
import edu.galileo.android.facebookrecipies.recipemain.ui.event.RecipeMainEvent;
import edu.galileo.android.facebookrecipies.recipemain.ui.iu.RecipeMainView;

/**
 * Created by Usuario_Privado on 27/06/2016.
 */
public class RecipeMainPresenterImpl implements RecipeMainPresenter {
    private EventBus eventBus;
    private RecipeMainView view;
    SaveRecipeInteractor saveInteractor;
    GetNextRecipeInteractor getNextRecipeInteractor;

    public RecipeMainPresenterImpl(EventBus eventBus, RecipeMainView view, SaveRecipeInteractor saveInteractor, GetNextRecipeInteractor getNextRecipeInteractor) {
        this.eventBus = eventBus;
        this.view = view;
        this.saveInteractor = saveInteractor;
        this.getNextRecipeInteractor = getNextRecipeInteractor;
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        eventBus.unregister(this);
        view = null;
    }

    @Override
    public void dismissRecipe() {
        if(this.view!=null){
            view.dismissAnimation();
        }
        getNextRecipe();
    }

    @Override
    public void getNextRecipe() {
        if(this.view!=null){
            view.hideUIElements();
            view.showProgress();
        }
        getNextRecipeInteractor.execute();
    }

    @Override
    public void saveRecipe(Recipe recipe) {
        if(this.view!=null){
            view.saveAnimation();
            view.hideUIElements();
            view.showProgress();
        }
        saveInteractor.execute(recipe);
    }

    @Override
    @Subscribe
    public void onEventMainThread(RecipeMainEvent event) {
        if(this.view!=null){
            String error = event.getError();
            if(error!=null){
                view.hideProgress();
                view.onGetRecipeError(error);
            }else{
                if(event.getType()==RecipeMainEvent.NEXT_EVENT){
                    post(event.getRecipe());
                    //view.setRecipe(event.getRecipe());
                }else if(event.getType()==RecipeMainEvent.SAVE_EVENT){
                    view.onRecipeSaved();
                    getNextRecipeInteractor.execute();
                }
            }
        }
    }

    private void post(Recipe recipe) {
        if(view!= null){
            view.hideProgress();
            view.showUIElements();
        }
        view.setRecipe(recipe);
    }

    @Override
    public void imageReady() {
        if(this.view!=null){
            view.hideProgress();
            view.showUIElements();
        }
    }

    @Override
    public void imageError(String error) {
        if(this.view!=null) {
            view.onGetRecipeError(error);
        }
    }

    @Override
    public RecipeMainView getView() {
        return this.view;
    }
}
