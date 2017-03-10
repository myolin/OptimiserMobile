package com.myolin.optimisermobile;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class BuildingFragment extends Fragment {

    private ReadAsset asset;
    private CreateSpinner spinner;

    public BuildingFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        asset = new ReadAsset(getContext());
        spinner = new CreateSpinner(container, getContext());
        return inflater.inflate(R.layout.fragment_building, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        projectStateSpinner();
        yearBuiltSpinner();
        baseCondAreaSpinner();
        baseOccupantsSpinner();
        baseBedroomsSpinner();
        baseBuildingUnitsSpinner();
    }

    public void projectStateSpinner(){
        String stateString = asset.getStringDataCell(7,15);
        String[] projectStateArray = stateString.split(",");
        spinner.createStateSpinner(projectStateArray, R.id.ProjectState, "CO");
    }

    public void yearBuiltSpinner(){
        int lowLimit = Integer.parseInt(asset.getStringDataCell(8,29));
        int highLimit = Integer.parseInt(asset.getStringDataCell(9,29));
        int increment = Integer.parseInt(asset.getStringDataCell(10,29));
        int defaultValue = Integer.parseInt(asset.getStringDataCell(12,29));
        Integer[] lowHighArray = new Integer[(highLimit - lowLimit) / increment + 1];
        int index = 0;
        for(int i=lowLimit; i<=highLimit; i=i+increment){
            lowHighArray[index] = i;
            index++;
        }
        spinner.createLowHighSpinner(lowHighArray, R.id.YearBuilt, defaultValue);
    }

    public void baseCondAreaSpinner(){
        int lowLimit = Integer.parseInt(asset.getStringDataCell(8,30));
        int highLimit = Integer.parseInt(asset.getStringDataCell(9,30));
        int increment = Integer.parseInt(asset.getStringDataCell(10,30));
        int defaultValue = Integer.parseInt(asset.getStringDataCell(12,30));
        Integer[] lowHighArray = new Integer[(highLimit - lowLimit) / increment + 1];
        int index = 0;
        for(int i=lowLimit; i<=highLimit; i=i+increment){
            lowHighArray[index] = i;
            index++;
        }
        spinner.createLowHighSpinner(lowHighArray, R.id.BaseCondArea, defaultValue);
    }

    public void baseOccupantsSpinner(){
        int lowLimit = Integer.parseInt(asset.getStringDataCell(8,31));
        int highLimit = Integer.parseInt(asset.getStringDataCell(9,31));
        int increment = Integer.parseInt(asset.getStringDataCell(10,31));
        int defaultValue = Integer.parseInt(asset.getStringDataCell(12,31));
        Integer[] lowHighArray = new Integer[(highLimit - lowLimit) / increment + 1];
        int index = 0;
        for(int i=lowLimit; i<=highLimit; i=i+increment){
            lowHighArray[index] = i;
            index++;
        }
        spinner.createLowHighSpinner(lowHighArray, R.id.BaseOccupants, defaultValue);
    }

    public void baseBedroomsSpinner(){
        int lowLimit = Integer.parseInt(asset.getStringDataCell(8,32));
        int highLimit = Integer.parseInt(asset.getStringDataCell(9,32));
        int increment = Integer.parseInt(asset.getStringDataCell(10,32));
        int defaultValue = Integer.parseInt(asset.getStringDataCell(12,32));
        Integer[] lowHighArray = new Integer[(highLimit - lowLimit) / increment + 1];
        int index = 0;
        for(int i=lowLimit; i<=highLimit; i=i+increment){
            lowHighArray[index] = i;
            index++;
        }
        spinner.createLowHighSpinner(lowHighArray, R.id.BaseBedrooms, defaultValue);
    }

    public void baseBuildingUnitsSpinner(){
        int lowLimit = Integer.parseInt(asset.getStringDataCell(8,35));
        int highLimit = Integer.parseInt(asset.getStringDataCell(9,35));
        int increment = Integer.parseInt(asset.getStringDataCell(10,35));
        int defaultValue = Integer.parseInt(asset.getStringDataCell(12,35));
        Integer[] lowHighArray = new Integer[(highLimit - lowLimit) / increment + 1];
        int index = 0;
        for(int i=lowLimit; i<=highLimit; i=i+increment){
            lowHighArray[index] = i;
            index++;
        }
        spinner.createLowHighSpinner(lowHighArray, R.id.BaseBuildingUnits, defaultValue);
    }
}
