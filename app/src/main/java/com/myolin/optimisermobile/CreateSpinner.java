package com.myolin.optimisermobile;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class CreateSpinner {

    private View view;
    private Context context;
    private Spinner spinner;
    private ArrayAdapter<String> stringAdapter;
    private ArrayAdapter<Integer> intAdapter;

    public CreateSpinner(View view, Context context){
        this.view = view;
        this.context = context;
    }

    public Spinner createStateSpinner(String[] stateArray, int id, String defaultValue){
        spinner = (Spinner) view.findViewById(id);
        stringAdapter = new ArrayAdapter<String>(context, R.layout.support_simple_spinner_dropdown_item, stateArray);
        stringAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(stringAdapter);

        setStringDefaultValue(defaultValue);

        return spinner;
    }

    public Spinner createLowHighSpinner(Integer[] inputArray, int id, int defaultValue){
        spinner = (Spinner) view.findViewById(id);
        intAdapter = new ArrayAdapter<Integer>(context, R.layout.support_simple_spinner_dropdown_item, inputArray);
        intAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(intAdapter);

        setIntDefaultValue(defaultValue);

        return spinner;
    }

    public void setStringDefaultValue(String value){
        int spinnerPosition = stringAdapter.getPosition(value);
        spinner.setSelection(spinnerPosition);
    }

    public void setIntDefaultValue(int value){
        int spinnerPosition = intAdapter.getPosition(value);
        spinner.setSelection(spinnerPosition);
    }




}
