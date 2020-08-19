package com.yash.onsitetask_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    Handler handler;
    ConstraintLayout main_rl;
    dials dial;
    customView customView;
    draw_numbers drawNumbers;
    float screenWidth;
    float screenHeight;
    public static boolean isRunning = false, isStopped;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler = new Handler();
        main_rl = findViewById(R.id.rl);
        Button start = findViewById(R.id.btn_start);
        Button reset = findViewById(R.id.btn_reset);
        Button pause = findViewById(R.id.btn_pause);
        final Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getMetrics(displayMetrics);

        screenWidth = displayMetrics.widthPixels;
        screenHeight = displayMetrics.heightPixels;
        customView = new customView(MainActivity.this, main_rl, screenWidth, screenHeight);
        dial = new dials(this, main_rl, screenWidth, screenHeight);
        drawNumbers = new draw_numbers(this, main_rl, screenWidth, screenHeight);
        main_rl.addView(customView);
        main_rl.addView(dial);
        main_rl.addView(drawNumbers);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRunning = true;
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRunning = false;
                dial.angle = Math.PI / 2D;
                dial.smallAngle = Math.PI / 2D;
                dial.postInvalidate();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRunning = false;
            }
        });
    }
}