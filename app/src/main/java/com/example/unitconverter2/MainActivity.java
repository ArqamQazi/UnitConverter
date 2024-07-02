package com.example.unitconverter2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.MenuItem;
import android.widget.Toast;

import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.annotation.NonNull;


import com.example.unitconverter2.common.Length;
import com.example.unitconverter2.common.Mass;
import com.example.unitconverter2.common.Speed;
import com.example.unitconverter2.common.Storage;
import com.example.unitconverter2.common.Temperature;
import com.example.unitconverter2.common.TimeConverterActivity;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ImageButton buttonDrawerToggle;
    NavigationView navigationView;

    MaterialCardView b1;
    MaterialCardView timeCard;
    MaterialCardView tempCard;
    MaterialCardView storageCard;
    MaterialCardView massCard;
    MaterialCardView speedCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        drawerLayout = findViewById(R.id.main);
        buttonDrawerToggle = findViewById(R.id.ButtonDrwaertoggle);
        navigationView = findViewById(R.id.navigationview);
        buttonDrawerToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.open();
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int itemId = item.getItemId();
                if(itemId == R.id.navLength) {
                    Intent intent = new Intent(MainActivity.this, Length.class);
                    startActivity(intent);
                }

                if(itemId == R.id.navTemperature) {
                    Intent intent = new Intent(MainActivity.this, Temperature.class);
                    startActivity(intent);
                }

                if(itemId == R.id.navTime) {
                    Intent intent = new Intent(MainActivity.this, TimeConverterActivity.class);
                    startActivity(intent);
                }

                drawerLayout.close();

                return false;
            }
        });

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

        tempCard = findViewById(R.id.temperature_card);
        tempCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Temperature.class);
                startActivity(intent);
            }
        });

        storageCard = findViewById(R.id.storage);
        storageCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.print("Hello world");
                Intent intent = new Intent(MainActivity.this, Storage.class);
                startActivity(intent);
            }
        });

        massCard = findViewById(R.id.Mass);
        massCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Mass.class);
                startActivity(intent);
         }
        });

        speedCard = findViewById(R.id.Speed);
        speedCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Speed.class);
                startActivity(intent);
            }
        });

    }
}