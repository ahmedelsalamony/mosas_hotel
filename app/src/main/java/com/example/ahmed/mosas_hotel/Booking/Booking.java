package com.example.ahmed.mosas_hotel.Booking;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.Display;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.dd.CircularProgressButton;
import com.example.ahmed.mosas_hotel.R;
import com.example.ahmed.mosas_hotel.fonts.MySpinnerAdapter;

import java.util.Arrays;
import java.util.Calendar;

public class Booking extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    int year_x, day_x, month_x;
    int flag = 0;
    static final int Dilog_Id = 0;
    EditText name, country, email, from, to;
    CardView card;
    Spinner s1, s2;
    String[] arrays1, arrays2;
    CircularProgressButton b1;

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
        //card.setMinimumHeight(height - 230);
        final Calendar cal = Calendar.getInstance();
        year_x = cal.get(Calendar.YEAR);
        month_x = cal.get(Calendar.MONTH);
        day_x = cal.get(Calendar.DAY_OF_MONTH);
        component();
        click();
        arrays1 = new String[]{"Transfer", "Yes", "No"};
        arrays2 = new String[]{"How Did Y Hear About Us", "Internet Search", "Recommended By Friend", "Positive Media Review"};
        SpinnerDate(arrays1, s1);
        SpinnerDate(arrays2, s2);

        b1.setIndeterminateProgressMode(true);


    }

    public void click() {
        b1.setOnClickListener(this);
        from.setOnClickListener(this);
        to.setOnClickListener(this);
    }

    public void component() {
        s1 = (Spinner) findViewById(R.id.s1);
        s2 = (Spinner) findViewById(R.id.s2);
        b1 = (CircularProgressButton) findViewById(R.id.btnWithText);
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        from = (EditText) findViewById(R.id.from);
        to = (EditText) findViewById(R.id.to);
        country = (EditText) findViewById(R.id.country);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnWithText:
                b1.setProgress(50); // set progress > 0 & < 100 to display indeterminate progress
                // b1.setProgress(0);


                break;
            case R.id.from:
                showDialog(Dilog_Id);
                flag = 1;
                break;
            case R.id.to:
                showDialog(Dilog_Id);
                flag=2;
                break;
        }

    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == Dilog_Id) {
            return new DatePickerDialog(this, DateP, year_x, month_x, day_x);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener DateP = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            day_x = dayOfMonth;
            year_x = year;
            month_x = month + 1;
            if (flag == 1) {
                from.setText(day_x + "/" + month_x + "/" + year_x);
            } else if (flag == 2) {
                to.setText(day_x + "/" + month_x + "/" + year_x);
            }
        }
    };


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void SpinnerDate(String[] array1, Spinner s) {
        MySpinnerAdapter adapter = new MySpinnerAdapter(
                Booking.this,
                R.layout.spinrtitem,
                Arrays.asList(array1)
        );
        adapter.setDropDownViewResource(R.layout.downspinner);
        s.setAdapter(adapter);
    }

}
