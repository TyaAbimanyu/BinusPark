package com.example.binuspark;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class UniversityListViewHolder extends RecyclerView.ViewHolder {
    TextView nameTV;

    TextView locationTV;

    TextView parkingSlotTV;

    public UniversityListViewHolder(View itemView){
        super(itemView);

        nameTV = itemView.findViewById(R.id.nameTV);

        locationTV = itemView.findViewById(R.id.locationTV);

        parkingSlotTV = itemView.findViewById(R.id.parkingSlotTV);
    }
}
