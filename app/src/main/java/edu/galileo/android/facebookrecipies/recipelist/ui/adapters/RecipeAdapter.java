package edu.galileo.android.facebookrecipies.recipelist.ui.adapters;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.SendButton;
import com.facebook.share.widget.ShareButton;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import edu.galileo.android.facebookrecipies.R;
import edu.galileo.android.facebookrecipies.entities.Recipe;
import edu.galileo.android.facebookrecipies.libs.base.ImageLoader;

/**
 * Created by Usuario_Privado on 08/07/2016.
 */
public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {

    private List<Recipe> recipeList;
    private ImageLoader imageLoader;
    private OnItemClickListener onItemClickLister;

    public RecipeAdapter(List<Recipe> recipeList, ImageLoader imageLoader, OnItemClickListener onItemClickLister) {
        this.recipeList = recipeList;
        this.imageLoader = imageLoader;
        this.onItemClickLister = onItemClickLister;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.elements_store_recipe, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Recipe currentRecipe = recipeList.get(position);
        imageLoader.load(holder.imgRecipe, currentRecipe.getImageURL());
        holder.txtRecipeName.setText(currentRecipe.getTitle());
        holder.imgFav.setTag(currentRecipe.getFavorite());
        if(currentRecipe.getFavorite()){
            holder.imgFav.setImageResource(android.R.drawable.btn_star_big_on);
        }else{
            holder.imgFav.setImageResource(android.R.drawable.btn_star_big_off);
        }
        holder.setOnItemClickListener(currentRecipe, onItemClickLister);
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipeList = recipes;
        notifyDataSetChanged();
    }

    public void removeRecipe(Recipe recipe) {
        recipeList.remove(recipe);
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.imgRecipe)
        ImageView imgRecipe;
        @Bind(R.id.txtRecipeName)
        TextView txtRecipeName;
        @Bind(R.id.imgFav)
        ImageButton imgFav;
        @Bind(R.id.imgDelete)
        ImageButton imgDelete;
        @Bind(R.id.layoutButtons)
        LinearLayout layoutButtons;
        @Bind(R.id.fbShare)
        ShareButton fbShare;
        @Bind(R.id.fbSend)
        SendButton fbSend;

        private  View view;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.view = itemView;
        }

        public void setOnItemClickListener(final Recipe currentRecipe, final OnItemClickListener onItemClickLister) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  onItemClickLister.onItemClick(currentRecipe);
                }
            });
            imgFav.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    onItemClickLister.onFavClick(currentRecipe);
                }
            });
            imgDelete.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    onItemClickLister.onDeleteClick(currentRecipe);
                }
            });
            ShareLinkContent content = new ShareLinkContent.Builder()
                    .setContentUrl(Uri.parse(currentRecipe.getImageURL()))
                    .build();
            fbShare.setShareContent(content);
            fbSend.setShareContent(content);
        }
    }
}
