package com.anwesome.ui.leangridviewmodule;

import android.content.Context;
import android.graphics.*;
import android.renderscript.Element;
import android.util.AttributeSet;
import android.view.*;

import java.util.*;


/**
 * Created by anweshmishra on 30/12/16.
 */
public class LeanGridViewGroup extends ViewGroup {
    private boolean measured = false;
    private boolean layoutDone = false;
    private int w,h;
    private List<GridViewElement> elements = new ArrayList<>();
    public void addElement(GridViewElement...elements) {
        for(GridViewElement element:elements) {
            this.elements.add(element);
        }
    }
    public LeanGridViewGroup(Context context, AttributeSet attrs) {
        super(context,attrs);
    }
    public LeanGridViewGroup(Context context){
        super(context);
    }
    public void onMeasure(int wspec,int hspec) {
        Point size = new Point();
        getDisplay().getRealSize(size);
        w = size.x;
        h = size.y;
        int k = Math.round(elements.size()/3);
        if(!measured) {
            for(GridViewElement element:elements) {
                LeanView leanView = new LeanView(getContext(),element);
                addView(leanView,new ViewGroup.LayoutParams(w/4,h/4));
                leanView.measure(wspec,hspec);
            }
            measured = true;
        }
        setMeasuredDimension(w,(h/3)*k);
    }
    public void onLayout(boolean refreshed,int a,int b,int w1,int h1) {
        if(!layoutDone) {
            for(int i=0;i<getChildCount();i++) {
                View child = getChildAt(i);
                int x = w/24*(i%3+1)+(i%3)*(w/4),y = h/24+(i/3)*(h/4+h/24);
                child.layout(x,y,x+w/4,y+h/4);
            }
            layoutDone = true;
        }
    }
    private class LeanView extends View{
        private GridViewElement element;
        public LeanView(Context context,GridViewElement gridViewElement) {
            super(context);
            this.element = gridViewElement;
            this.setOnClickListener(element.getOnClickListener());
        }
        public void onDraw(Canvas canvas) {
            Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
            int w = canvas.getWidth(),h = canvas.getHeight();
            Bitmap bitmap = element.getBitmap();
            if(bitmap!=null) {
                Bitmap newBitmap = Bitmap.createScaledBitmap(bitmap, w, (3 * h) / 4, true);
                canvas.drawBitmap(newBitmap, 0, 0, paint);
            }
            String title = element.getTitle();
            paint.setTextSize(h/8);
            if(title!=null) {
                float textWidth = paint.measureText(title);
                canvas.drawText(title,w/2-textWidth/2,7*h/8,paint);
            }
        }

    }
}
