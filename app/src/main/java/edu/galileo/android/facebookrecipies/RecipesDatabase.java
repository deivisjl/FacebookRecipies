package edu.galileo.android.facebookrecipies;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by Usuario_Privado on 23/06/2016.
 */
@Database(name = RecipesDatabase.NAME, version = RecipesDatabase.VERSION)
public class RecipesDatabase {
    public static final int VERSION = 1;
    public static final String NAME = "Recipes";
}
