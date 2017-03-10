package com.myolin.optimisermobile;

import android.app.DatePickerDialog;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.InputStream;
import java.util.Calendar;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class AuditorFragment extends Fragment {

    Calendar calendar = Calendar.getInstance();
    TextView date;

    public AuditorFragment(){}

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_auditor, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        date = (TextView)getView().findViewById(R.id.Date);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(getContext(), listener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            date.setText((month+1) + "/" + dayOfMonth + "/" + year);
        }
    };

    /*@Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button b = (Button)view.findViewById(R.id.button2);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    AssetManager am = getActivity().getAssets();
                    InputStream is = am.open("name.xls");
                    Workbook wb = Workbook.getWorkbook(is);
                    Sheet s = wb.getSheet(0);
                    int row = s.getRows();
                    int col = s.getColumns();
                    String xx="";
                    for(int i=0; i<row; i++){
                        for(int j=0; j<col; j++){
                            Cell z = s.getCell(j,i);
                            xx = xx + z.getContents();
                        }
                        xx = xx + "\n";
                    }
                    display(xx);
                }catch(Exception e){

                }
            }
        });
    }

    public void display(String value){
        TextView v = (TextView)getView().findViewById(R.id.textView);
        v.setText(value);
    }*/
}
