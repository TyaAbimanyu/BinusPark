package com.example.binuspark;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Find the Button by its ID
        Button button = findViewById(R.id.button);

        // Set a click listener for the Button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pay = new Intent(MainActivity2.this, PaymentActivity.class);
                pay.putExtra("location","Binus Kemanggisan");
                pay.putExtra("price", 25000);
                startActivity(pay);
            }
        });
    }
}
