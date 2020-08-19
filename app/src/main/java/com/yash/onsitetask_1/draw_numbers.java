package com.yash.onsitetask_1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import androidx.constraintlayout.widget.ConstraintLayout;

public class draw_numbers extends View {
    Paint p;
    ConstraintLayout relativeLayout;
    float width, height;
    double angle_of_lines;
    int k = 8;

    public draw_numbers(Context context, ConstraintLayout relativeLayout, float x, float y) {
        super(context);
        this.relativeLayout = relativeLayout;
        p = new Paint();
        p.setAntiAlias(true);
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(1f);
        p.setColor(Color.BLACK);
        angle_of_lines = Math.PI / 30D;
        width = x;
        height = y;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 1; i < 16; i++) {
            if (k > 30) {
                k = 2;
            }
            canvas.drawText(String.valueOf(k),
                    (float) (width / 2 + (width / 3 - 80f) * Math.cos(angle_of_lines)),
                    (float) (height / 2 + (width / 3 - 80f) * Math.sin(angle_of_lines)),
                    p);
            angle_of_lines += Math.PI / 7.5D;
            k += 2;
        }
        angle_of_lines = Math.PI / 10D;
        k = 39;
        for (int i = 1; i < 16; i++) {
            if (k > 60) {
                k = 31;
            }
            canvas.drawText(String.valueOf(k),
                    (float) (width / 2 + (width / 3 - 40f) * Math.cos(angle_of_lines)),
                    (float) (height / 2 + (width / 3 - 40f) * Math.sin(angle_of_lines)),
                    p);
            angle_of_lines += Math.PI / 7.5D;
            k += 2;
        }
        angle_of_lines = Math.PI / 30D;
        k = 4;
        for (int i = 1; i < 16; i++) {
            if (k > 15) {
                k = 1;
            }
            canvas.drawText(String.valueOf(k),
                    (float) (width / 2 + (width / 15 - 20f) * Math.cos(angle_of_lines)),
                    (float) (height / 2 - width / 8 + (width / 15 - 20f) * Math.sin(angle_of_lines)),
                    p);
            angle_of_lines += Math.PI / 7.5D;
            k += 1;
        }
    }
}
