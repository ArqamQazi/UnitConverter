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

//        getSupportActionBar().setTitle("MeasureMate");

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


    }
}