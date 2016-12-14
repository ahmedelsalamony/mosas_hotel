package com.example.ahmed.mosas_hotel.Home;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.ahmed.mosas_hotel.Booking.Booking;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.example.ahmed.mosas_hotel.R;
import com.example.ahmed.mosas_hotel.activities.activities_activity;
import com.example.ahmed.mosas_hotel.team.team_activity;

import java.util.HashMap;

public class home_activity extends AppCompatActivity implements View.OnClickListener, BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {
    View Booking;

    private SliderLayout mDemoSlider;
    public int x;
    LinearLayout booking, about, activities, team, contactus, rateus;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_activity);
        /*intialization for slider */

        Booking = findViewById(R.id.Booking);
        Booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(home_activity.this, Booking.class);
                startActivity(i);
            }
        });
        mDemoSlider = (SliderLayout) findViewById(R.id.slider);
        HashMap<String, String> url_maps = new HashMap<String, String>();
        url_maps.put("Hannibal", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
        url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
        url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");
        for (String name : url_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(home_activity.this);
            // initialize a SliderLayout
            textSliderView
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
            ;

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(home_activity.this);
        mDemoSlider.setPresetTransformer("ZoomOut");

        booking = (LinearLayout) findViewById(R.id.Booking);
        about = (LinearLayout) findViewById(R.id.about);
        activities = (LinearLayout) findViewById(R.id.activities);
        team = (LinearLayout) findViewById(R.id.team);
        contactus = (LinearLayout) findViewById(R.id.contactus);
        rateus = (LinearLayout) findViewById(R.id.rateus);
        booking.setOnClickListener(this);
        about.setOnClickListener(this);
        activities.setOnClickListener(this);
        team.setOnClickListener(this);
        contactus.setOnClickListener(this);
        rateus.setOnClickListener(this);
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {
        Intent i = null;
        switch (v.getId()) {
            case R.id.Booking:
                i = new Intent(home_activity.this, com.example.ahmed.mosas_hotel.Booking.Booking.class);
                startActivity(i);
                break;
            case R.id.about:
                Toast.makeText(getApplication(), "about", Toast.LENGTH_SHORT).show();
                break;
            case R.id.activities:
                i = new Intent(home_activity.this, activities_activity.class);
                startActivity(i);
                break;
            case R.id.team:
                i = new Intent(home_activity.this, team_activity.class);
                startActivity(i);
                break;
            case R.id.contactus:
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.custom_dialog_contactus);
                // Custom Android Allert Dialog Title
                dialog.setTitle("feel free to Contact us");

                Button dail = (Button) dialog.findViewById(R.id.btn_dial);

                Button email = (Button) dialog.findViewById(R.id.btn_mail);

                // Click cancel to dismiss android custom dialog box
                dail.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:0693774345"));
                        startActivity(intent);
                    }
                });

                // Your android custom dialog ok action
                // Action for custom dialog ok button click
                email.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_SEND);
                        intent.setType("text/plain");
                        intent.putExtra(Intent.EXTRA_EMAIL, "info@mosesbayhotel.com");
                        intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                        intent.putExtra(Intent.EXTRA_TEXT, "I'm email body.");

                        startActivity(Intent.createChooser(intent, "Send Email"));
                    }
                });
                dialog.show();
                break;
            case R.id.rateus:
                Toast.makeText(getApplication(), "rate us", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
