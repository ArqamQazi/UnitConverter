package com.example.unitconverter2.common;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import com.example.unitconverter2.R;

public class Length extends AppCompatActivity {


    // Radio Buttons
    RadioButton iRadioButton;
    RadioButton oRadioButton;

    RadioButton ikm;
    RadioButton im;
    RadioButton icm;

    RadioButton okm;
    RadioButton om;
    RadioButton ocm;


    // Input and Output Text Field
    AppCompatEditText inputValue;
    AppCompatEditText outputValue;

    // Radio Group button and convert button
    RadioGroup iRadioGroup;
    RadioGroup oRadioGroup;
    Button convertButton;



    


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);


        inputValue = findViewById(R.id.et_name_input);
        outputValue = findViewById(R.id.et_name_output);
        convertButton = findViewById(R.id.tmp_btn);

        //Input Radio Buttons
        iRadioGroup = findViewById(R.id.i_radio_buttons);
        ikm = findViewById(R.id.i_km);
        im = findViewById(R.id.i_m);
        icm = findViewById(R.id.i_cm);

        // Output Radio Buttons
        oRadioGroup = findViewById(R.id.o_radio_buttons);
        okm = findViewById(R.id.o_km);
        om = findViewById(R.id.o_m);
        ocm = findViewById(R.id.o_cm);

        // set default options

        ikm.setChecked(true);
        okm.setChecked(true);







    }
    public void convertUnits() {
        String inputString = inputValue.getText().toString();
        double inputValueDouble;

        try {
            inputValueDouble = Double.parseDouble(inputString);
        } catch (NumberFormatException e) {
            inputValueDouble = 0.0;
        }

    }
}



// This is the dead code but it might awake
//
//        iRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//    @Override
//    public void onCheckedChanged(RadioGroup group, int checkedId) {
//        // Find the radio button that was selected
//        iRadioButton = findViewById(checkedId);
//
//        // Display a Toast message with the selected radio button text
//        Toast.makeText(getApplicationContext(), "Selected: " + iRadioButton.getText(), Toast.LENGTH_SHORT).show();
//    }
//});
//
//
//        oRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//    @Override
//    public void onCheckedChanged(RadioGroup group, int checkedId) {
//        // Find the radio button that was selected
//        oRadioButton = findViewById(checkedId);
//
//        // Display a Toast message with the selected radio button text
//        Toast.makeText(getApplicationContext(), "Selected: " + oRadioButton.getText(),
//                Toast.LENGTH_SHORT).show();
//    }
//});
