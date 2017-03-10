package com.myolin.optimisermobile;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;

import java.io.InputStream;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ReadAsset {

    Sheet workSheet;

    public ReadAsset(Context context){
        workSheet = getWorkSheet(context);
    }

    public Sheet getWorkSheet(Context context) {
        Sheet s = null;
        try {
            AssetManager am = context.getAssets();
            InputStream is = am.open("mobiletakeoff.xls.xls");
            Workbook wb = Workbook.getWorkbook(is);
            s = wb.getSheet(1);
        } catch (Exception e) {

        }
        return s;
    }

    public String getStringDataCell(int col, int row){
        String result = "";
        Cell cell = workSheet.getCell(col,row);
        result = result + cell.getContents();
        return result;
    }
}
