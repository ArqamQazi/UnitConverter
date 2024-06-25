package com.example.unitconverter2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.unitconverter2.common.Length;
import com.example.unitconverter2.common.Temperature;
import com.example.unitconverter2.common.TimeConverterActivity;
import com.google.android.material.card.MaterialCardView;

public class MainActivity extends AppCompatActivity {

    MaterialCardView b1;
    MaterialCardView timeCard;
    MaterialCardView tempCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.Length);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Length.class);
                startActivity(intent);
            }
        });
        timeCard = findViewById(R.id.Time);
        timeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TimeConverterActivity.class);
                startActivity(intent);
            }
        });
        tempCard = findViewById(R.id.temperature);
        tempCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Temperature.class);
                startActivity(intent);
            }
        });


    }
}