package edu.galileo.android.facebookrecipies.recipemain.ui.iu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


import java.util.List;


import butterknife.Bind;
import butterknife.ButterKnife;
import edu.galileo.android.facebookrecipies.FacebookRecipiesApp;
import edu.galileo.android.facebookrecipies.R;
import edu.galileo.android.facebookrecipies.entities.Recipe;

import edu.galileo.android.facebookrecipies.recipelist.RecipeListPresenter;

import edu.galileo.android.facebookrecipies.recipelist.di.RecipeListComponent;
import edu.galileo.android.facebookrecipies.recipelist.ui.RecipeListView;
import edu.galileo.android.facebookrecipies.recipelist.ui.adapters.OnItemClickListener;
import edu.galileo.android.facebookrecipies.recipelist.ui.adapters.RecipeAdapter;

/**
 * Created by Usuario_Privado on 25/06/2016.
 */
public class RecipeListActivity extends AppCompatActivity implements RecipeListView, OnItemClickListener{
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

   private  RecipeAdapter adapter;
    private RecipeListPresenter presenter;
    private RecipeListComponent component;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);
        ButterKnife.bind(this);
        setupToolbar();
        setupInjection();
        setupRecyclerView();
        presenter.onCreate();
        presenter.getRecipes();
    }

    private void setupInjection() {
        FacebookRecipiesApp app = (FacebookRecipiesApp)getApplication();
        component = app.getRecipeListComponent(this, this, this);
        presenter = getPresenter();
        adapter = getAdapter();
    }

    private RecipeAdapter getAdapter() {
        return component.getAdapter();
    }

    private RecipeListPresenter getPresenter() {
        return component.getPresenter();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_recipes_list, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_main){
            navigateToMainScreen();
        }else if(id == R.id.action_logout){
            logout();
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        FacebookRecipiesApp app = (FacebookRecipiesApp)getApplication();
        app.logout();
    }

    private void navigateToMainScreen() {
        startActivity(new Intent(this, RecipeMainActivity.class));
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    private void setupRecyclerView() {
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
    }

    @Override
    public void setRecipes(List<Recipe> data) {
        adapter.setRecipes(data);
    }

    @Override
    public void recipeUpdate() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void recipeDeleted(Recipe recipe) {
        adapter.removeRecipe(recipe);
    }

    @Override
    public void onFavClick(Recipe recipe) {
        presenter.toggleFavorite(recipe);
    }

    @Override
    public void onItemClick(Recipe recipe) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(recipe.getSourceURL()));
        startActivity(intent);
    }

    @Override
    public void onDeleteClick(Recipe recipe) {
        presenter.removeRecipe(recipe);
    }
}
