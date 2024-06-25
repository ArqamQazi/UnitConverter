package com.example.unitconverter2.common;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import com.example.unitconverter2.R;

import java.text.DecimalFormat;

public class TimeConverterActivity extends AppCompatActivity {

    // RadioButtons for input and output units to set default option
    private RadioButton iSeconds;
    private RadioButton oSeconds;

    // Input and Output Text Fields
    private AppCompatEditText inputValue;
    private AppCompatEditText outputValue;

    // RadioGroups for input and output units
    private RadioGroup iRadioGroup;
    private RadioGroup oRadioGroup;

    // Conversion factors
    private double conversionFactor = 1.0;
    private double oConversionFactor = 1.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        getSupportActionBar().setTitle("MeasureMate");
        initializeUIElements();

        setDefaultRadioButtonOptions();

        setRadioGroupListeners();
    }

    // Initialize UI elements
    private void initializeUIElements() {
        inputValue = findViewById(R.id.et_time_input);
        outputValue = findViewById(R.id.et_time_output);

        iRadioGroup = findViewById(R.id.i_time_radio_buttons);
        iSeconds = findViewById(R.id.i_seconds);

        oRadioGroup = findViewById(R.id.o_time_radio_buttons);
        oSeconds = findViewById(R.id.o_seconds);
    }

    // Set default RadioButton options
    private void setDefaultRadioButtonOptions() {
        iSeconds.setChecked(true);
        oSeconds.setChecked(true);
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
            case "Minutes":
                return 60.0;
            case "Hours":
                return 3600.0;
            case "Seconds":
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
