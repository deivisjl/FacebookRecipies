package edu.galileo.android.facebookrecipies.recipelist.ui.adapters;

import edu.galileo.android.facebookrecipies.entities.Recipe;

/**
 * Created by Usuario_Privado on 08/07/2016.
 */
public interface OnItemClickListener {
    void onFavClick(Recipe recipe);
    void onItemClick(Recipe recipe);
    void onDeleteClick(Recipe recipe);
}
