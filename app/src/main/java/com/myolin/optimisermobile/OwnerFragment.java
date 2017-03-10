package com.myolin.optimisermobile;


import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.InputStream;
import java.util.ArrayList;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class OwnerFragment extends Fragment {

    private ReadAsset asset;
    private String[] stateArray;
    private CreateSpinner spinner;

    public OwnerFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        asset = new ReadAsset(getContext());
        spinner = new CreateSpinner(container, getContext());
        return inflater.inflate(R.layout.fragment_owner, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        stateSpinner();
    }

    public void stateSpinner(){
        String stateString = asset.getStringDataCell(7,15);
        stateArray = stateString.split(",");
        spinner.createStateSpinner(stateArray, R.id.State, "CO");
    }
}
