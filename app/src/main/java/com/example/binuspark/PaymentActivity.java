package com.example.binuspark;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class PaymentActivity extends AppCompatActivity
{
  TextView locationTextView, priceTextView;
  ImageView qrCode;
  int price = 0;
  String location;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_payment);

    locationTextView = findViewById(R.id.location);
    priceTextView = findViewById(R.id.price);
    qrCode = findViewById(R.id.QRCode);

    Bundle extras = getIntent().getExtras();
    if(extras != null)
    {
      location = extras.getString("location");
      if(location == null) locationTextView.setText("Binus Alam Sutera");
      else locationTextView.setText(location);
      price = extras.getInt("price");
      priceTextView.setText("Total Fee: "+PriceFormat(price));
    }

    qrCode.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View view) {
        Intent next = new Intent(PaymentActivity.this, SuccessActivity.class);
        startActivity(next);
      }
    });
  }

  public String PriceFormat(int amount)
  {
    Locale idr = new Locale("id", "ID");
    NumberFormat numberFormat = NumberFormat.getCurrencyInstance(idr);

    // Set the currency to IDR
    numberFormat.setCurrency(java.util.Currency.getInstance("IDR"));

    return numberFormat.format(amount);
  }
}