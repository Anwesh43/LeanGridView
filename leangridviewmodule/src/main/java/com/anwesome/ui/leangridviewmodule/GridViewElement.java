package com.anwesome.ui.leangridviewmodule;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;

/**
 * Created by anweshmishra on 30/12/16.
 */
public class GridViewElement {
    private Bitmap bitmap;
    private String title;
    private View.OnClickListener onClickListener;
    public GridViewElement(Bitmap bitmap,String title){
        this.bitmap = bitmap;
        this.title = title;
    }
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
    public View.OnClickListener getOnClickListener() {
        return onClickListener;
    }
    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public int hashCode() {
        return title.hashCode()+bitmap.hashCode();
    }
}
