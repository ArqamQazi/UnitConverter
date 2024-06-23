package com.example.unitconverter2.common;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import com.example.unitconverter2.R;

import java.text.DecimalFormat;

public class Length extends AppCompatActivity {

    // RadioButtons for input and output units to set default option
    RadioButton ikm;
    RadioButton okm;

    // Input and Output Text Fields
    AppCompatEditText inputValue;
    AppCompatEditText outputValue;

    // RadioGroups for input and output units
    RadioGroup iRadioGroup;
    RadioGroup oRadioGroup;

    // Conversion factors
    double conversionFactor = 1000.0;
    double oConversionFactor = 1000.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);

        initializeUIElements();

        setDefaultRadioButtonOptions();

        setRadioGroupListeners();
    }

    // Initialize UI elements
    private void initializeUIElements() {
        inputValue = findViewById(R.id.et_name_input);
        outputValue = findViewById(R.id.et_name_output);

        iRadioGroup = findViewById(R.id.i_radio_buttons);
        ikm = findViewById(R.id.i_km);

        oRadioGroup = findViewById(R.id.o_radio_buttons);
        okm = findViewById(R.id.o_km);
    }

    // Set default RadioButton options
    private void setDefaultRadioButtonOptions() {
        ikm.setChecked(true);
        okm.setChecked(true);
    }

    // Set listeners for RadioGroups
    private void setRadioGroupListeners() {
        iRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton selectedRadioButton = findViewById(checkedId);
            String selectedText = selectedRadioButton.getText().toString();
            TextView inputUnitText = findViewById(R.id.input_unit_text);
            inputUnitText.setText(selectedText);
            conversionFactor = getConversionFactor(selectedText);
            convertUnits();
        });

        oRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton selectedRadioButton = findViewById(checkedId);
            String selectedText = selectedRadioButton.getText().toString();
            TextView outputUnitText = findViewById(R.id.output_unit_text);
            outputUnitText.setText(selectedText);
            oConversionFactor = getConversionFactor(selectedText);
            convertUnits();
        });
    }

    // Get conversion factor based on selected unit
    private double getConversionFactor(String unit) {
        switch (unit) {
            case "Centimeter":
                return 0.01;
            case "Meter":
                return 1.0;
            case "Kilometer":
                return 1000.0;
            default:
                return 1.0;
        }
    }

    // Convert units and update the output value
    public void convertUnits() {
        String inputString = inputValue.getText().toString();
        double inputValueDouble = parseInputValue(inputString);
        double result = calculateConversion(inputValueDouble);
        displayResult(result);
    }

    // Parse input value and handle potential NumberFormatException
    private double parseInputValue(String inputString) {
        try {
            return Double.parseDouble(inputString);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    // Calculate conversion result
    private double calculateConversion(double inputValueDouble) {
        return inputValueDouble * conversionFactor / oConversionFactor;
    }

    // Display the result in the output TextView
    private void displayResult(double result) {
        DecimalFormat df = new DecimalFormat("#.########");
        outputValue.setText(df.format(result));
    }
}