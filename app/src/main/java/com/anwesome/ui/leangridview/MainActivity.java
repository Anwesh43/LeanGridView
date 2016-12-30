package com.anwesome.ui.leangridview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.anwesome.ui.leangridviewmodule.GridViewElement;
import com.anwesome.ui.leangridviewmodule.LeanGridViewGroup;

public class MainActivity extends AppCompatActivity {
    private String title[] = {"title 1","title 2","title 3","title 4","title 5","title 6"};
    private int res[] = {R.drawable.car,R.drawable.car1,R.drawable.car2,R.drawable.car3,R.drawable.car4,R.drawable.profile};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        LeanGridViewGroup leanGridViewGroup = new LeanGridViewGroup(this);
        for(int i=0;i<9;i++) {
            GridViewElement element = new GridViewElement(BitmapFactory.decodeResource(getResources(),res[i%6]),title[i%6]);
            leanGridViewGroup.addElement(element);
        }
        setContentView(leanGridViewGroup);
    }

}
