package com.example.ahmed.mosas_hotel.team;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.ahmed.mosas_hotel.Adapters.activities_Adapter;
import com.example.ahmed.mosas_hotel.R;
import com.example.ahmed.mosas_hotel.model.model_activities;
import java.util.ArrayList;
import java.util.List;

public class team_activity extends AppCompatActivity {

    View v;
    private List<model_activities> disList = new ArrayList<>();
    private RecyclerView recyclerView;
    private activities_Adapter mAdapter;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        mAdapter = new activities_Adapter(disList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplication());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        prepareMovieData();
        setTitle("Hotel Team");

        Button btn=(Button) findViewById(R.id.btn_contactus);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                // custom dialog
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
            }
        });
    }
    private void prepareMovieData() {

        String[] names = {"Dhiaa Habib ","Ahmed Badawy ","Amr ","Hassan El Daly "};

        String[] dates = {"General Manager ","assistant general manager ","Restaurant Manager ","Owner"};

        int[] activites_pics={R.drawable.chara,R.drawable.chara,R.drawable.chara,R.drawable.chara,};

        for (int x = 0; x < names.length; x++) {
            model_activities model_activities = new model_activities( names[x],  dates[x],activites_pics[x]);
            disList.add(model_activities);
            mAdapter.notifyDataSetChanged();


        }
    }
}
