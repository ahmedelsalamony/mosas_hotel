package com.example.ahmed.mosas_hotel.About;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Display;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ahmed.mosas_hotel.R;


import java.util.ArrayList;

public class About extends AppCompatActivity {
TextView pargraph;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        pargraph=(TextView)findViewById(R.id.pargraph);
        pargraph.setHeight(height-400);
        pargraph.setMovementMethod(new ScrollingMovementMethod());

    }
}
