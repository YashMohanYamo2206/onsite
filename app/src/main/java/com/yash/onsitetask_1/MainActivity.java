package com.yash.onsitetask_1;

import androidx.appcompat.app.AppCompatActivity;

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
    RelativeLayout main_rl;
    dials dial;
    customView customView;
    float screenWidth;
    float screenHeight;
    public static boolean isRunning = false, isStopped;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler = new Handler();
        main_rl = findViewById(R.id.rl);
        Button start = findViewById(R.id.btn_startPause);
        Button reset = findViewById(R.id.btn_reset);

        final Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getMetrics(displayMetrics);

        screenWidth = displayMetrics.widthPixels;
        screenHeight = displayMetrics.heightPixels;
        customView = new customView(MainActivity.this, main_rl, screenWidth, screenHeight);
        dial = new dials(this, main_rl, screenWidth, screenHeight);
        main_rl.addView(customView);
        main_rl.addView(dial);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRunning = true;
                start_watch();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRunning=false;
                dial.angle = Math.PI / 2D;
                dial.postInvalidate();
            }
        });
    }

    public void start_watch() {
        if(!isRunning)
            return;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                dial.validate();
            }
        }, 1000L);
        start_watch();
    }

    public void stop() {

    }
}