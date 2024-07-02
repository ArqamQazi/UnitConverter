package com.example.unitconverter2.common;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import com.example.unitconverter2.R;

import java.text.DecimalFormat;

public class Mass extends AppCompatActivity {

    private RadioButton ikl;
    private RadioButton okl;

    // Input and Output Text Fields
    private AppCompatEditText inputValue;
    private AppCompatEditText outputValue;

    // RadioGroups for input and output units
    private RadioGroup iRadioGroup;
    private RadioGroup oRadioGroup;

    String inputUnit = "Kilogram";
    String outputUnit = "Kilogram";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mass);
        initializeUIElements();

        setDefaultRadioButtonOptions();

        setRadioGroupListeners();
    }


    private void initializeUIElements() {
        inputValue = findViewById(R.id.et_name_input);
        outputValue = findViewById(R.id.et_name_output);

        iRadioGroup = findViewById(R.id.i_radio_buttons);
        ikl = findViewById(R.id.i_kl);

        oRadioGroup = findViewById(R.id.o_radio_buttons);
        okl = findViewById(R.id.o_kl);
    }


    private void setDefaultRadioButtonOptions() {
        ikl.setChecked(true);
        okl.setChecked(true);
    }


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


    public void convertUnits() {
        String inputString = inputValue.getText().toString();
        double inputValueDouble = parseInputValue(inputString);
        double result = calculateConversion(inputValueDouble);
        displayResult(result);
    }


    private double parseInputValue(String inputString) {
        try {
            return Double.parseDouble(inputString);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }


    private double calculateConversion(double inputValueDouble) {
        double result = inputValueDouble;
        if (inputUnit.equals("Kilogram") && outputUnit.equals("Kilogram")) {
            result = inputValueDouble;
        } else if (inputUnit.equals("Kilogram") && outputUnit.equals("Grams")) {
            result = inputValueDouble * 1000 ;
        } else if (inputUnit.equals("Kilogram") && outputUnit.equals("Pounds")) {
            result = inputValueDouble * 2.2;
        } else if (inputUnit.equals("Grams") && outputUnit.equals("Grams")) {
            result = inputValueDouble;
        } else if (inputUnit.equals("Grams") && outputUnit.equals("Kilogram")) {
            result = inputValueDouble/1000;
        } else if (inputUnit.equals("Grams") && outputUnit.equals("Pounds")) {
            result = inputValueDouble * 0.00220462;
        } else if (inputUnit.equals("Pounds") && outputUnit.equals("Kilogram")) {
            result = inputValueDouble * 0.45359237;
        } else if (inputUnit.equals("Pounds") && outputUnit.equals("Pounds")) {
            result = inputValueDouble;
        } else if (inputUnit.equals("Pounds") && outputUnit.equals("Grams")) {
            result = inputValueDouble * 453.592;
        } else {
            throw new IllegalArgumentException("Invalid unit conversion");
        }
        return result;
    }


    private void displayResult(double result) {
        DecimalFormat df = new DecimalFormat("#.########");
        outputValue.setText(df.format(result));
    }
}

