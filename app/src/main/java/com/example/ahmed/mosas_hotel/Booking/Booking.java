package com.example.ahmed.mosas_hotel.Booking;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.dd.CircularProgressButton;
import com.example.ahmed.mosas_hotel.CircleTransform;
import com.example.ahmed.mosas_hotel.Home.home_activity;
import com.example.ahmed.mosas_hotel.R;
import com.example.ahmed.mosas_hotel.fonts.MySpinnerAdapter;
import com.example.ahmed.mosas_hotel.uilit.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.Calendar;

import cz.msebera.android.httpclient.Header;

public class Booking extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    int year_x, day_x, month_x;
    ImageView fromcel,tocel;
    int flag = 0;
    static final int Dilog_Id = 0;
    EditText name, country, email, from, to, details, type;
    CardView card;
    Spinner s1, s2;
    String[] arrays1, arrays2;
    CircularProgressButton b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        Display display = getWindowManager().getDefaultDisplay();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        ImageView logo=(ImageView)findViewById(R.id.logo) ;
        Picasso.with(this).load(R.drawable.small)
                .transform(new CircleTransform()).into(logo);
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
        fromcel.setOnClickListener(this);
        tocel.setOnClickListener(this);
    }

    public void component() {
        fromcel=(ImageView)findViewById(R.id.fromcel);
        tocel=(ImageView)findViewById(R.id.tocel);
        s1 = (Spinner) findViewById(R.id.s1);
        s2 = (Spinner) findViewById(R.id.s2);
        b1 = (CircularProgressButton) findViewById(R.id.btnWithText);
        type = (EditText) findViewById(R.id.type);
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        from = (EditText) findViewById(R.id.from);
        to = (EditText) findViewById(R.id.to);
        country = (EditText) findViewById(R.id.country);
        details = (EditText) findViewById(R.id.details);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnWithText:
                if (validate()) {
                    b1.setProgress(50);
                    try {
                        RequestParams params = new RequestParams();
                      //  params.put("request", "ideaformspinner");//åÊÛíÑ ÇáÇÓã ÍÓÈ ãÇ íÞæáß æåÊÈÚÊáÉ Çá id ãä Çáshared refrance
                        params.put("name", name.getText());
                        params.put("email", email.getText());
                        params.put("departure", to.getText());
                        params.put("arrival", from.getText());
                        params.put("type_of_room", type.getText());
                        params.put("country_name", country.getText());
                        params.put("message", details.getText());
                        params.put("transfer", arrays1[s1.getSelectedItemPosition()]);
                        params.put("hear_about", arrays2[s2.getSelectedItemPosition()]);
                        Load(params);
                    } catch (Exception ex) {
                        Toast.makeText(getApplicationContext(), "Exception" + ex, Toast.LENGTH_LONG).show();
                    }


                }// set progress > 0 & < 100 to display indeterminate progress
                // b1.setProgress(0);


                break;
            case R.id.from:
                getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
                showDialog(Dilog_Id);
                flag = 1;
                break;
            case R.id.to:
                getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
                showDialog(Dilog_Id);
                flag = 2;
                break;
            case R.id.fromcel:
                getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
                showDialog(Dilog_Id);
                flag = 1;
                break;
            case R.id.tocel:
                getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
                showDialog(Dilog_Id);
                flag = 2;
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


    public Boolean validate() {
        Boolean out = true;
        if (TextUtils.isEmpty(name.getText())) {
            name.setError("Enter Your Name");
            out = false;
        }
        if (TextUtils.isEmpty(type.getText())) {
            type.setError("Enter Room Type");
            out = false;
        }
        if (TextUtils.isEmpty(email.getText())|| !android.util.Patterns.EMAIL_ADDRESS.matcher(email.getText()).matches()) {
            email.setError("Enter Your Email");
            out = false;
        }
        if (TextUtils.isEmpty(from.getText())) {
            from.setError("Enter Your Date");
            out = false;
        }
        if (TextUtils.isEmpty(to.getText())) {
            to.setError("Enter Your Date");
            out = false;
        }
        if (TextUtils.isEmpty(details.getText())) {
            details.setError("Enter Your Descraption");
            out = false;
        }
        if (TextUtils.isEmpty(country.getText())) {
            country.setError("Enter Your Country");
            out = false;
        }
        if (s1.getSelectedItemPosition() == 0) {
            ((TextView) s1.getChildAt(0)).setError(".");
            out = false;
        }
        if (s2.getSelectedItemPosition() == 0) {
            ((TextView) s2.getChildAt(0)).setError(".");
            out = false;
        }

        return out;
    }

    public void Load(RequestParams params) throws JSONException {

        AsyncHttpClient.post("", params, new JsonHttpResponseHandler() {
            ProgressDialog progressDialog;

            @Override
            public void onStart() {
               /* progressDialog = new ProgressDialog(Booking.this);
                progressDialog.setCancelable(false);
                progressDialog.setMessage("ÌÇÑì ÇáÈÍË...");
                progressDialog.show();*/
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

                Log.e("onSuccess", response + "");
                Log.e("onSuccess", response.length() + "");
                try {
                    Intent i = new Intent(Booking.this, home_activity.class);
                    if (response.getInt("response") == 1) {
                        startActivity(i);
                        Toast.makeText(getApplicationContext(), "Saved Directly", Toast.LENGTH_LONG).show();
                    } else {
                        startActivity(i);
                        Toast.makeText(getApplicationContext(), "Try in another time", Toast.LENGTH_LONG).show();
                    }

                } catch (Exception ex) {

                    Toast.makeText(getApplicationContext(), "ÇÔÇÑå ÇáäÊ ÖÛíÝå", Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
                // Toast.makeText(getActivity().getApplicationContext(), "onFailure", Toast.LENGTH_LONG).show();
                // Log.e("onFailure", "----------" + responseString);

                Log.e("onFailure", "----------" + responseString);
            }

            @Override
            public void onFinish() {
                super.onFinish();
                // progressDialog.dismiss();


            }

        });


    }


}
