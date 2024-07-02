package com.example.unitconverter2.common;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import com.example.unitconverter2.R;

import java.text.DecimalFormat;

public class Speed extends AppCompatActivity {

    // RadioButtons for input and output units to set default option
    RadioButton iKmph;
    RadioButton oKmph;

    // Input and Output Text Fields
    AppCompatEditText inputValue;
    AppCompatEditText outputValue;

    // RadioGroups for input and output units
    RadioGroup iRadioGroup;
    RadioGroup oRadioGroup;

    // Selected units
    String inputUnit = "Kmph";
    String outputUnit = "Kmph";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("Hello world1");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed);
        System.out.println("Hello world2");
//        getSupportActionBar().setTitle("MeasureMate");
        initializeUIElements();
        System.out.println("Hello world3");
        setDefaultRadioButtonOptions();
        System.out.println("Hello world4");
        setRadioGroupListeners();
        System.out.println("Hello world5");
    }

    // Initialize UI elements
    private void initializeUIElements() {
        inputValue = findViewById(R.id.et_name_input);
        outputValue = findViewById(R.id.et_name_output);

        iRadioGroup = findViewById(R.id.i_radio_buttons);
        iKmph = findViewById(R.id.i_kmph);

        oRadioGroup = findViewById(R.id.o_radio_buttons);
        oKmph = findViewById(R.id.o_Kmph);
    }

    // Set default RadioButton options
    private void setDefaultRadioButtonOptions() {
        iKmph.setChecked(true);
        oKmph.setChecked(true);
    }

    // Set listeners for RadioGroups
    private void setRadioGroupListeners() {
        System.out.println("Hello world41");
        iRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            System.out.println("Hello world42");
            RadioButton selectedRadioButton = findViewById(checkedId);
            System.out.println("Hello world4.1");
            inputUnit = selectedRadioButton.getText().toString();
            TextView inputUnitText = findViewById(R.id.input_unit_text);
            inputUnitText.setText(inputUnit);
            System.out.println("hello world4.1");
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

        if (inputUnit.equals("Kmph") && outputUnit.equals("Kmph")) {
            result = inputValueDouble;
        } else if (inputUnit.equals("Kmph") && outputUnit.equals("Kms")) {
            result = inputValueDouble / 3600;
        } else if (inputUnit.equals("Kmph") && outputUnit.equals("Mph")) {
            result = inputValueDouble * 0.621371;
        } else if (inputUnit.equals("Kms") && outputUnit.equals("Kms")) {
            result = inputValueDouble;
        } else if (inputUnit.equals("Kms") && outputUnit.equals("Kmph")) {
            result = inputValueDouble * 3600;
        } else if (inputUnit.equals("Kms") && outputUnit.equals("Mph")) {
            result = (inputValueDouble - 32) * 5/9 + 273.15;
        } else if (inputUnit.equals("Mph") && outputUnit.equals("Mph")) {
            result = inputValueDouble;
        } else if (inputUnit.equals("Mph") && outputUnit.equals("Kmph")) {
            result = inputValueDouble * 1.60934;
        } else if (inputUnit.equals("Mph") && outputUnit.equals("Kms")) {
            result = inputValueDouble * 1.60934;
        } else {
            throw new IllegalArgumentException("Invalid unit conversion");
        }

        return result;
    }

    // Display the result in the output TextView
    private void displayResult(double result) {
        DecimalFormat df = new DecimalFormat("#.#######");
        outputValue.setText(df.format(result));
    }
}
