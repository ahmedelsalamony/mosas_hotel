package com.example.ahmed.mosas_hotel.Adapters;

/**
 * Created by ahmed on 10/20/2016.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ahmed.mosas_hotel.CircleTransform;
import com.example.ahmed.mosas_hotel.R;
import com.example.ahmed.mosas_hotel.model.model_activities;
import com.squareup.picasso.Picasso;

import java.util.List;

public class team_Adapter extends RecyclerView.Adapter<team_Adapter.MyViewHolder> {

    private List<model_activities> displayList;
    View itemView;
    public team_Adapter(List<model_activities> displayList) {
        this.displayList = displayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        itemView= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.team_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        model_activities model_activities = displayList.get(position);
        holder.title.setText(model_activities.getActvities_title());
        holder.description.setText(model_activities.getDiscripton());
        Picasso.with(itemView.getContext()).load(model_activities.getActivities_pics())
                .transform(new CircleTransform()).into(holder.img);


    }

    @Override
    public int getItemCount() {
        return displayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, description;
        public ImageView img;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            description = (TextView) view.findViewById(R.id.artist);
            img = (ImageView) view.findViewById(R.id.list_image);

        }
    }

}
