package com.yash.onsitetask_1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;


import androidx.constraintlayout.widget.ConstraintLayout;

import static com.yash.onsitetask_1.MainActivity.isRunning;

@SuppressLint("ViewConstructor")
public class dials extends View {
    ConstraintLayout relativeLayout;
    Paint p, p2;
    public float width, height;
    public double angle, smallAngle;

    public dials(Context context, ConstraintLayout relativeLayout, float x, float y) {
        super(context);
        this.relativeLayout = relativeLayout;
        p = new Paint();
        p2 = new Paint();
        p2.setStyle(Paint.Style.STROKE);
        p2.setStrokeWidth(5);
        p2.setColor(Color.BLUE);
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(10);
        p.setColor(Color.BLACK);
        width = x;
        height = y;
        angle = Math.PI / 2D;
        smallAngle = Math.PI / 2D;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(width / 2,
                height / 2 - width / 8,
                (float) ((width / 2) + (width / 15 - 10f) * Math.cos(-smallAngle)),
                (float) ((height / 2 - width / 8) + (width / 15 - 20f) * Math.sin(-smallAngle)),
                p2);


        canvas.drawLine(width / 2, height / 2, (float) ((width / 2) + (width / 4 - 10f) * Math.cos(-angle)), (float) (height / 2 + (width / 4 - 10f) * Math.sin(-angle)), p2);
        if (isRunning) {
            validate();
        }
        invalidate();
    }

    public void validate() {
        angle -= Math.PI / 900D;
        smallAngle -= Math.PI / 27000D;
    }

}
