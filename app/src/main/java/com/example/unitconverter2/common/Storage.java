package com.example.unitconverter2.common;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import com.example.unitconverter2.R;

import java.text.DecimalFormat;

public class Storage extends AppCompatActivity {
    // RadioButtons for input and output units to set default option
    private RadioButton ikb;
    private RadioButton okb;

    // Input and Output Text Fields
    private AppCompatEditText inputValue;
    private AppCompatEditText outputValue;

    // RadioGroups for input and output units
    private RadioGroup iRadioGroup;
    private RadioGroup oRadioGroup;

    // Selected units
    String inputUnit = "kiloBytes";
    String outputUnit = "kiloBytes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);

        initializeUIElements();

        setDefaultRadioButtonOptions();

        setRadioGroupListeners();
    }

    private void initializeUIElements() {
        inputValue = findViewById(R.id.et_time_input);
        outputValue = findViewById(R.id.et_time_output);

        iRadioGroup = findViewById(R.id.i_radio_buttons);
        ikb = findViewById(R.id.i_kb);

        oRadioGroup = findViewById(R.id.o_radio_buttons);
        okb = findViewById(R.id.o_kb);
    }

    // Set default RadioButton options
    private void setDefaultRadioButtonOptions() {
        ikb.setChecked(true);
        okb.setChecked(true);
    }

    // Set listeners for RadioGroups
    private void setRadioGroupListeners() {
        iRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton selectedRadioButton = findViewById(checkedId);
            inputUnit = selectedRadioButton.getText().toString();
            TextView inputUnitText = findViewById(R.id.input_storage_text);
            inputUnitText.setText(inputUnit);
            convertUnits();
        });

        oRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton selectedRadioButton = findViewById(checkedId);
            outputUnit = selectedRadioButton.getText().toString();
            TextView outputUnitText = findViewById(R.id.output_storage_text);
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

        if (inputUnit.equals("kiloBytes") && outputUnit.equals("kiloBytes")) {
            result = inputValueDouble;
        } else if (inputUnit.equals("kiloBytes") && outputUnit.equals("MegaBytes")) {
            result = inputValueDouble / 1024;
        } else if (inputUnit.equals("kiloBytes") && outputUnit.equals("GigaBytes")) {
            result = inputValueDouble / 1000000;
        } else if (inputUnit.equals("MegaBytes") && outputUnit.equals("MegaBytes")) {
            result = inputValueDouble;
        } else if (inputUnit.equals("MegaBytes") && outputUnit.equals("kiloBytes")) {
            result = inputValueDouble * 1024;
        } else if (inputUnit.equals("MegaBytes") && outputUnit.equals("GigaBytes")) {
            result = inputValueDouble / 100;
        } else if (inputUnit.equals("GigaBytes") && outputUnit.equals("GigaBytes")) {
            result = inputValueDouble;
        } else if (inputUnit.equals("GigaBytes") && outputUnit.equals("kiloBytes")) {
            result = inputValueDouble * 1000000;
        } else if (inputUnit.equals("GigaBytes") && outputUnit.equals("MegaBytes")) {
            result = inputValueDouble / 1024;
        } else {
            throw new IllegalArgumentException("Invalid unit conversion");
        }
        return result;
    }

    public void displayResult (double result){
    DecimalFormat df = new DecimalFormat("#.###");
    outputValue.setText(df.format(result));
    }
}

