package com.example.binuspark;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class UniversityList extends AppCompatActivity {

    private RecyclerView universityRV;

    private ArrayList<University> universityList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university_list);

        createData();

        universityRV = findViewById(R.id.universityRV);

        UniversityListAdapter adapter = new UniversityListAdapter(universityList, this);

        universityRV.setLayoutManager(new GridLayoutManager(this, 2));

        universityRV.setAdapter(adapter);
    }

    public void createData(){
        universityList = new ArrayList<>();

        University university1 = new University("@AlamSutera", 48);

        University university2 = new University("@Anggrek", 6);

        University university3 = new University("@Bandung", 18);

        University university4 = new University("@Bekasi", 14);

        universityList.add(university1);

        universityList.add(university2);

        universityList.add(university3);

        universityList.add(university4);
    }
}