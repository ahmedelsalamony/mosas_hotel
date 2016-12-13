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
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        mAdapter = new activities_Adapter(disList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplication());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        prepareMovieData();
    }
    private void prepareMovieData() {

        String[] names = {"احمد عبدالحميد شعبان السلامونى", "احمد عبدالحميد شعبان السلامونى", "احمد عبدالحميد شعبان السلامونى"
                , "احمد عبدالحميد شعبان السلامونى", "احمد عبدالحميد شعبان السلامونى"};

        String[] dates = {"20/1/2016", "20/1/2016", "20/1/2016", "20/1/2016", "20/1/2016"};

        int[] activites_pics={R.drawable.email,R.drawable.about,R.drawable.heart,R.drawable.email,R.drawable.info};

        for (int x = 0; x < names.length; x++) {
            model_activities model_activities = new model_activities( names[x],  dates[x],activites_pics[x]);
            disList.add(model_activities);
            mAdapter.notifyDataSetChanged();


        }
    }
}
