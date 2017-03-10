package com.myolin.optimisermobile;

import android.content.res.AssetManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.w3c.dom.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;

import jxl.Sheet;
import jxl.Workbook;

public class MainActivity extends AppCompatActivity {

    private Fragment auditorFragment;
    private Fragment ownerFragment;
    private Fragment buildingFragment;
    private Fragment windowsFragment;
    private Fragment doorsFragment;
    private Fragment crawlFragment;
    private Fragment basementFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayShowTitleEnabled(false);

        ActionBar.Tab auditorTab = actionBar.newTab().setText(getString(R.string.ui_tabname_auditor));
        ActionBar.Tab ownerTab = actionBar.newTab().setText(getString(R.string.ui_tabname_owner));
        ActionBar.Tab buildingTab = actionBar.newTab().setText(getString(R.string.ui_tabname_building));
        ActionBar.Tab windowsTab = actionBar.newTab().setText(getString(R.string.ui_tabname_windows));
        ActionBar.Tab doorsTab = actionBar.newTab().setText(getString(R.string.ui_tabname_doors));
        ActionBar.Tab crawlTab = actionBar.newTab().setText(getString(R.string.ui_tabname_crawl));
        ActionBar.Tab basementTab = actionBar.newTab().setText(getString(R.string.ui_tabname_basement));

        auditorFragment = new AuditorFragment();
        ownerFragment = new OwnerFragment();
        buildingFragment = new BuildingFragment();
        windowsFragment = new WindowsFragment();
        doorsFragment = new DoorsFragment();
        crawlFragment = new CrawlFragment();
        basementFragment = new BasementFragment();

        auditorTab.setTabListener(new MyTabsListener(auditorFragment, getApplicationContext()));
        ownerTab.setTabListener(new MyTabsListener(ownerFragment, getApplicationContext()));
        buildingTab.setTabListener(new MyTabsListener(buildingFragment, getApplicationContext()));
        windowsTab.setTabListener(new MyTabsListener(windowsFragment, getApplicationContext()));
        doorsTab.setTabListener(new MyTabsListener(doorsFragment, getApplicationContext()));
        crawlTab.setTabListener(new MyTabsListener(crawlFragment, getApplicationContext()));
        basementTab.setTabListener(new MyTabsListener(basementFragment, getApplicationContext()));

        actionBar.addTab(auditorTab);
        actionBar.addTab(ownerTab);
        actionBar.addTab(buildingTab);
        actionBar.addTab(windowsTab);
        actionBar.addTab(doorsTab);
        actionBar.addTab(crawlTab);
        actionBar.addTab(basementTab);
    }

    class MyTabsListener implements ActionBar.TabListener{
        public Fragment fragment;

        public MyTabsListener(Fragment f, Context context){
            fragment = f;
        }

        @Override
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
            ft.replace(R.id.fragment_container, fragment);
        }

        @Override
        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
            ft.remove(fragment);
        }

        @Override
        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

        }
    }
}
