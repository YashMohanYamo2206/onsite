package com.yash.onsitetask_1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;


import androidx.constraintlayout.widget.ConstraintLayout;

@SuppressLint("ViewConstructor")
public class customView extends View {
    Paint p;
    ConstraintLayout relativeLayout;
    float width, height;
    double angle_of_lines;

    public customView(Context context, ConstraintLayout relativeLayout, float x, float y) {
        super(context);
        this.relativeLayout = relativeLayout;
        p = new Paint();
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(10);
        p.setColor(Color.BLACK);
        angle_of_lines = Math.PI / 30D;
        width = x;
        height = y;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(width / 2, height / 2, width / 3, p);
        p.setStrokeWidth(5f);
        canvas.drawCircle(width / 2, height / 2 - width / 8, width / 15, p);
        p.setStyle(Paint.Style.FILL);
        canvas.drawCircle(width / 2, height / 2, 10f, p);
        canvas.drawCircle(width / 2, height / 2 - width / 8, 6.66f, p);
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(5f);

        for (int i = 1; i < 16; i++) {
            canvas.drawLine((float) (width / 2 + (width / 3) * Math.cos(angle_of_lines)),
                    (float) (height / 2 + (width / 3) * Math.sin(angle_of_lines)),
                    (float) (width / 2 + (width / 3 - 50f) * Math.cos(angle_of_lines)),
                    (float) (height / 2 + (width / 3 - 50f) * Math.sin(angle_of_lines)),
                    p);
            angle_of_lines += Math.PI / 7.5D;
        }
        angle_of_lines = Math.PI / 10D;
        for (int i = 1; i < 16; i++) {
            canvas.drawLine((float) (width / 2 + (width / 3) * Math.cos(angle_of_lines)),
                    (float) (height / 2 + (width / 3) * Math.sin(angle_of_lines)),
                    (float) (width / 2 + (width / 3 - 25f) * Math.cos(angle_of_lines)),
                    (float) (height / 2 + (width / 3 - 25f) * Math.sin(angle_of_lines)),
                    p);
            angle_of_lines += Math.PI / 7.5D;
        }

        angle_of_lines = Math.PI / 30D;
        for (int i = 1; i < 16; i++) {
            canvas.drawLine((float) (width / 2 + (width / 15) * Math.cos(angle_of_lines)),
                    (float) (height / 2 - width / 8 + (width / 15) * Math.sin(angle_of_lines)),
                    (float) (width / 2 + (width / 15 - 15f) * Math.cos(angle_of_lines)),
                    (float) (height / 2 - width / 8 + (width / 15 - 15f) * Math.sin(angle_of_lines)),
                    p);
            angle_of_lines += Math.PI / 7.5D;
        }
    }


}
