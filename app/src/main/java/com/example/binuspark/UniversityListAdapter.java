package com.example.binuspark;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UniversityListAdapter extends RecyclerView.Adapter<UniversityListViewHolder> {
    private ArrayList<University> universityList;

    private Context context;

    public UniversityListAdapter(ArrayList<University> universityList, Context context){
        this.universityList = universityList;

        this.context = context;
    }

    public UniversityListViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.university_item, parent, false);

        return new UniversityListViewHolder(view);
    }

    public void onBindViewHolder(UniversityListViewHolder viewHolder, int position){
        University university = universityList.get(position);

        viewHolder.nameTV.setText(university.getName());

        viewHolder.locationTV.setText(university.getLocation());

        viewHolder.parkingSlotTV.setText(university.getParkingSlot());

        if(university.getLocation().toLowerCase().contains("alamsutera")){
            viewHolder.itemView.setBackgroundResource(R.drawable.alam_sutera);
        }
        else if(university.getLocation().toLowerCase().contains("anggrek")){
            viewHolder.itemView.setBackgroundResource(R.drawable.anggrek);
        }
        else if(university.getLocation().toLowerCase().contains("bandung")){
            viewHolder.itemView.setBackgroundResource(R.drawable.bandung);
        }
        else if(university.getLocation().toLowerCase().contains("bekasi")){
            viewHolder.itemView.setBackgroundResource(R.drawable.bekasi);
        }

//        viewHolder.itemView.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//                Intent intent = new Intent(context, MapActivity.class);
//
//                intent.putExtra("title", university.getName() + " " + university.getLocation());
//
//                intent.putExtra("latitude", university.getLatitude());
//
//                intent.putExtra("longitude", university.getLongitude());
//
//                context.startActivity(intent);
//            }
//        });
    }

    public int getItemCount(){
        int universityListSize = universityList.size();

        return universityListSize;
    }
}
