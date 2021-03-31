package com.example.pinnplanner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.MyViewHolder>{
    private ArrayList<task> tasksList;

    public recyclerAdapter(ArrayList<task> tasksList){
        this.tasksList = tasksList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView titleText;
        private TextView descriptionText;
        private TextView dateText;
        private TextView timeText;

        public MyViewHolder(final View view){
            super(view);
            titleText = view.findViewById(R.id.titleText);
            descriptionText = view.findViewById(R.id.descText);
            dateText = view.findViewById(R.id.dateText);
            timeText = view.findViewById(R.id.timeText);
        }
    }
    @NonNull
    @Override
    public recyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items,parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerAdapter.MyViewHolder holder, int position) {
        String title = tasksList.get(position).getTitle();
        holder.titleText.setText(title);

        String desc = tasksList.get(position).getDescription();
        holder.descriptionText.setText(desc);

        String date = tasksList.get(position).getDueDate();
        holder.dateText.setText(date);

        String time = tasksList.get(position).getDueTime();
        holder.timeText.setText(time);
    }

    @Override
    public int getItemCount() {
        return tasksList.size();
    }
}
