package com.example.unitconverter2.common;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import com.example.unitconverter2.R;

import java.text.DecimalFormat;

public class Temperature extends AppCompatActivity {

    // RadioButtons for input and output units to set default option
    RadioButton iCelsius;
    RadioButton oCelsius;

    // Input and Output Text Fields
    AppCompatEditText inputValue;
    AppCompatEditText outputValue;

    // RadioGroups for input and output units
    RadioGroup iRadioGroup;
    RadioGroup oRadioGroup;

    // Selected units
    String inputUnit = "Celsius";
    String outputUnit = "Celsius";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);
//        getSupportActionBar().setTitle("MeasureMate");
        initializeUIElements();

        setDefaultRadioButtonOptions();

        setRadioGroupListeners();
    }

    // Initialize UI elements
    private void initializeUIElements() {
        inputValue = findViewById(R.id.et_temp_input);
        outputValue = findViewById(R.id.et_temp_output);

        iRadioGroup = findViewById(R.id.i_temp_radio_buttons);
        iCelsius = findViewById(R.id.i_celsius);

        oRadioGroup = findViewById(R.id.o_temp_radio_buttons);
        oCelsius = findViewById(R.id.o_celsius);
    }

    // Set default RadioButton options
    private void setDefaultRadioButtonOptions() {
        iCelsius.setChecked(true);
        oCelsius.setChecked(true);
    }

    // Set listeners for RadioGroups
    private void setRadioGroupListeners() {
        iRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton selectedRadioButton = findViewById(checkedId);
            inputUnit = selectedRadioButton.getText().toString();
            TextView inputUnitText = findViewById(R.id.input_unit_text);
            inputUnitText.setText(inputUnit);
            convertUnits();
        });

        oRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton selectedRadioButton = findViewById(checkedId);
            outputUnit = selectedRadioButton.getText().toString();
            TextView outputUnitText = findViewById(R.id.output_unit_text);
            outputUnitText.setText(outputUnit);
            convertUnits();
        });
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
        double result = inputValueDouble;

        if (inputUnit.equals("Celsius") && outputUnit.equals("Celsius")) {
            result = inputValueDouble;
        } else if (inputUnit.equals("Celsius") && outputUnit.equals("Fahrenheit")) {
            result = inputValueDouble * 9/5 + 32;
        } else if (inputUnit.equals("Celsius") && outputUnit.equals("Kelvin")) {
            result = inputValueDouble + 273.15;
        } else if (inputUnit.equals("Fahrenheit") && outputUnit.equals("Fahrenheit")) {
            result = inputValueDouble;
        } else if (inputUnit.equals("Fahrenheit") && outputUnit.equals("Celsius")) {
            result = (inputValueDouble - 32) * 5/9;
        } else if (inputUnit.equals("Fahrenheit") && outputUnit.equals("Kelvin")) {
            result = (inputValueDouble - 32) * 5/9 + 273.15;
        } else if (inputUnit.equals("Kelvin") && outputUnit.equals("Kelvin")) {
            result = inputValueDouble;
        } else if (inputUnit.equals("Kelvin") && outputUnit.equals("Celsius")) {
            result = inputValueDouble - 273.15;
        } else if (inputUnit.equals("Kelvin") && outputUnit.equals("Fahrenheit")) {
            result = (inputValueDouble - 273.15) * 9/5 + 32;
        } else {
            throw new IllegalArgumentException("Invalid unit conversion");
        }

        return result;
    }

    // Display the result in the output TextView
    private void displayResult(double result) {
        DecimalFormat df = new DecimalFormat("#.##");
        outputValue.setText(df.format(result));
    }
}
