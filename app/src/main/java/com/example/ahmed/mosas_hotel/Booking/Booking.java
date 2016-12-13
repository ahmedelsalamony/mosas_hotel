package com.example.ahmed.mosas_hotel.Booking;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.Display;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.example.ahmed.mosas_hotel.R;
import com.example.ahmed.mosas_hotel.fonts.MySpinnerAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Booking extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemSelectedListener {
    CardView card;
    Spinner s1, s2;
String[] arrays1,arrays2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        card = (CardView) findViewById(R.id.Card);
        card.setMinimumHeight(height - 250);
        component();
        arrays1=new String[]{"Transfer","Yes","No"};
        arrays2=new String[]{"How Did Y Hear About Us","Internet Search","Recommended By Friend","Positive Media Review"};

    }
public void component(){
    s1=(Spinner)findViewById(R.id.s1);
    s2=(Spinner)findViewById(R.id.s2);
}

    @Override
    public void onClick(View view) {


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void SpinnerDate(String[] array1, Spinner s) {
        MySpinnerAdapter adapter = new MySpinnerAdapter(
               this,
                R.layout.spinrtitem,
                Arrays.asList(array1)
        );
        adapter.setDropDownViewResource(R.layout.downspinner);
        s.setAdapter(adapter);
    }

}
