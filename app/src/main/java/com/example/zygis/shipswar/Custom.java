package com.example.zygis.shipswar;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.widget.TextView;

public class Custom extends android.support.v7.widget.AppCompatTextView {
    private Paint paint = new Paint();

    public Custom(Context context) {
        super(context);
        init();
    }
    private void init(){
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(4);
    }
}
