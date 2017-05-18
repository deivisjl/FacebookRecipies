package edu.galileo.android.facebookrecipies.recipelist;

import edu.galileo.android.facebookrecipies.entities.Recipe;

/**
 * Created by Usuario_Privado on 08/07/2016.
 */
public interface StoredrecipesInteractor {
    void executeUpdate(Recipe recipe);
    void executeDelete(Recipe recipe);
}
