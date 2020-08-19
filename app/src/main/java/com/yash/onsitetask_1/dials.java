package com.yash.onsitetask_1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.widget.RelativeLayout;

public class dials extends View {
    RelativeLayout relativeLayout;
    Paint p, p2;
    public float width, height;
    public double angle;

    public dials(Context context, RelativeLayout relativeLayout, float x, float y) {
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
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(width / 2, height / 2, (float) ((width / 2) + (width / 4 - 10f) * Math.cos(-angle)), (float) (height / 2 + (width / 4 - 10f) * Math.sin(-angle)), p2);
        invalidate();
    }

    public void validate() {
        angle-= Math.PI / 15D;
        invalidate();
    }
}
