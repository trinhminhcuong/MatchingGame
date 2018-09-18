package com.example.cuong.trcxanh.DataModels;

import android.widget.ImageView;

/**
 * Created by Cuong on 7/22/2018.
 */

public class ImageObject {
    private ImageView imageView;
    private int keyword;

    public ImageObject() {
    }

    public ImageObject(ImageView imageView) {
        this.imageView = imageView;
    }

    public ImageObject(ImageView imageView, int keyword) {
        this.imageView = imageView;
        this.keyword = keyword;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public int getKeyword() {
        return keyword;
    }

    public void setKeyword(int keyword) {
        this.keyword = keyword;
    }

    public void setImageSource(int id){
        this.imageView.setImageResource(id);
    }
}
