package edu.galileo.android.facebookrecipies;

import android.app.Application;
import android.content.Intent;

import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.raizlabs.android.dbflow.config.FlowManager;

import edu.galileo.android.facebookrecipies.libs.di.LibsModule;
import edu.galileo.android.facebookrecipies.login_ui.LoginActivity;

import edu.galileo.android.facebookrecipies.recipelist.di.DaggerRecipeListComponent;
import edu.galileo.android.facebookrecipies.recipelist.di.RecipeListComponent;
import edu.galileo.android.facebookrecipies.recipelist.di.RecipeListModule;
import edu.galileo.android.facebookrecipies.recipelist.ui.RecipeListView;
import edu.galileo.android.facebookrecipies.recipelist.ui.adapters.OnItemClickListener;

import edu.galileo.android.facebookrecipies.recipemain.ui.di.DaggerRecipeMainComponent;
import edu.galileo.android.facebookrecipies.recipemain.ui.di.RecipeMainComponent;
import edu.galileo.android.facebookrecipies.recipemain.ui.di.RecipeMainModule;
import edu.galileo.android.facebookrecipies.recipemain.ui.iu.RecipeListActivity;
import edu.galileo.android.facebookrecipies.recipemain.ui.iu.RecipeMainActivity;
import edu.galileo.android.facebookrecipies.recipemain.ui.iu.RecipeMainView;

/**
 * Created by Usuario_Privado on 23/06/2016.
 */
public class FacebookRecipiesApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initFacebook();
        initDB();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        DBTearDown();
    }

    private void DBTearDown() {
        FlowManager.destroy();
    }

    private void initDB() {
        FlowManager.init(this);
    }

    private void initFacebook() {
        FacebookSdk.sdkInitialize(this);
    }

    public void logout() {
        LoginManager.getInstance().logOut();
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                | Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    public RecipeMainComponent getRecipeMainComponent(RecipeMainActivity activity, RecipeMainView view){
        return DaggerRecipeMainComponent
                .builder()
                .libsModule(new LibsModule(activity))
                .recipeMainModule(new RecipeMainModule(view))
                .build();
    }
    public RecipeListComponent getRecipeListComponent(RecipeListActivity activity, RecipeListView view, OnItemClickListener clickListener){
        return  DaggerRecipeListComponent
                .builder()
                .libsModule(new LibsModule(activity))
                .recipeListModule(new RecipeListModule(view, clickListener))
                .build();
    }
}
