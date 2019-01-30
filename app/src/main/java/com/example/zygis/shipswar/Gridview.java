package com.example.zygis.shipswar;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

public  class  Gridview {
    TextView[][] textViews=new TextView[10][10];

   static TextView[][] textViews1=new TextView[10][10];
    public void grid(Context context, GridLayout gridLayout, View.OnClickListener listener){
        for (int row = 0; row < 10; ++row) {
            for (int col = 0; col < 10; ++col) {

                TextView textView1 =new TextView(context);
                textView1.setBackgroundColor(Color.BLACK);
                GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL,1f);
                params.width = 0;
                params.rowSpec = GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL,1f);
                params.height = 0;

                textView1.setLayoutParams(params);
                gridLayout.addView(textView1);

                textView1.setTag(new Grid(row, col));
                textView1.setOnClickListener(listener);
                textViews[row][col]=textView1;
            }
        }
    }

    public static TextView[][] getTextViews1() {
        return textViews1;
    }

    public TextView[][] getTextViews() {
        return textViews;
    }

    public void grid(Context context, GridLayout gridLayout){
        for (int row = 0; row < 10; ++row) {
            for (int col = 0; col < 10; ++col) {

                TextView textView1 =new TextView(context);
                textView1.setBackgroundColor(Color.BLACK);
                GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL,1f);
                params.width = 0;
                params.rowSpec = GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL,1f);
                params.height = 0;

                textView1.setLayoutParams(params);
                gridLayout.addView(textView1);

                textView1.setTag(new Grid(row, col));
                textViews1[row][col]=textView1;
            }
        }
    }
}
