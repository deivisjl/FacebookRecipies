package edu.galileo.android.facebookrecipies.libs.base;

import android.widget.ImageView;

/**
 * Created by Usuario_Privado on 23/06/2016.
 */
public interface ImageLoader {
    void load(ImageView imageView, String URL);
    void setOnFinishedImageLoadingListener(Object listener);
}
