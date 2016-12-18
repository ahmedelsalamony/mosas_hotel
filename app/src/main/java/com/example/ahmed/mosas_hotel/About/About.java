package com.example.ahmed.mosas_hotel.About;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ahmed.mosas_hotel.CircleTransform;
import com.example.ahmed.mosas_hotel.R;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;

public class About extends AppCompatActivity {
TextView pargraph;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Display display = getWindowManager().getDefaultDisplay();
        ImageView logo=(ImageView)findViewById(R.id.logo) ;
        Picasso.with(this).load(R.drawable.small)
                .transform(new CircleTransform()).into(logo);
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        pargraph=(TextView)findViewById(R.id.pargraph);
        pargraph.setHeight(height-(height/2));
        pargraph.setMovementMethod(new ScrollingMovementMethod());

    }
}
