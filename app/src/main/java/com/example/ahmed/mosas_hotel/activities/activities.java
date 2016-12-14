package com.example.ahmed.mosas_hotel.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.example.ahmed.mosas_hotel.Adapters.activities_Adapter;
import com.example.ahmed.mosas_hotel.R;
import com.example.ahmed.mosas_hotel.model.model_activities;
import java.util.ArrayList;
import java.util.List;

public class activities extends AppCompatActivity {

    View v;
    private List<model_activities> disList = new ArrayList<>();
    private RecyclerView recyclerView;
    private activities_Adapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        mAdapter = new activities_Adapter(disList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplication());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        prepareMovieData();
    }
    private void prepareMovieData() {

        String[] names = {"Sports", "Relaxing", "sun tan"
                , "Snorkeling and fishing", "Monastery of ST.Catherine 120 km",
        "Ras Mohamed national park 70 km","Overnight in Sharm 90 km","Bedouin dinner","Trip to Cairo",
                "Moses bath (natural spring) 1.5 km"};

        String[] dates = {" (windsurfing , kitesurfing & water sports)",
                " ( yoga & natural springs meditation)", "Enjoy the sun tan ", "Enjoy the adventure of climming ST.Catherine",
                "Enjoy with the beauty of nature","","Taking dinner in bedouin style is so good",
                "see pyramids and cairo Tourist Attractions","",""};

        int[] activites_pics={R.drawable.windsurfingimg,R.drawable.yogaimg,R.drawable.sunimg,R.drawable.snorkingimg
                ,R.drawable.catrenaimg,R.drawable.rasimg,R.drawable.overnightimg,R.drawable.dinnerimg,R.drawable.cairoimg,R.drawable.pathimg};

        for (int x = 0; x < names.length; x++) {
            model_activities model_activities = new model_activities( names[x],  dates[x],activites_pics[x]);
            disList.add(model_activities);
            mAdapter.notifyDataSetChanged();


        }
    }
}
