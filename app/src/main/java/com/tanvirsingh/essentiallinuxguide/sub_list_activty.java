package com.tanvirsingh.essentiallinuxguide;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class sub_list_activty extends AppCompatActivity {

    private DrawerLayout subListDrawerLayout;
    private List<SubList> sublist = new ArrayList<>();
    private RecyclerView recyclerView;
    private SubListAdapter mSubListAdapter;

    String[] introductionToLinux = {"General Information About Linux","Why use Linux?","How to use this guide?"};
    String[] whatIsTheTerminal = {"Introduction to the terminal","Basic Commands","How do I install applications","man pages","Command Line Arguments and How To Use Them"};
    String[] programmersGuide = {"Pre installed Compilers and Interpreters","Text Editors"};
    String basicsTopicString;
    //Intent getintent = getIntent();
//    Bundle extras = getIntent().getExtras();
//    String temp = extras.getString("dataFromBasics");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Select Sub-Topic!");
        setContentView(R.layout.activity_sub_list_activty);

        basicsTopicString = getIntent().getExtras().getString("dataFromBasics");
        //get basics topic string for sublist adapter to be used in article

        Log.d(TAG, "Received " + basicsTopicString + ".");


        //shared preferences to store basics topic
        SharedPreferences.Editor editor = getSharedPreferences("fromBasics", MODE_PRIVATE).edit();
        editor.putString("basicsTopic", basicsTopicString);
        editor.apply();

        //adding toolbar to main screen
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // set recycler view
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mSubListAdapter = new SubListAdapter(sublist);
        final RecyclerView.LayoutManager subListLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(subListLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mSubListAdapter);

        int basicsTopicInt = Integer.parseInt(basicsTopicString);
        prepareSubListData(basicsTopicInt);

        // Create Navigation drawer and inflate layout

        NavigationView subListNavigationView = (NavigationView) findViewById(R.id.nav_view);
        subListDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);

        // Adding menu icon to Toolbar
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Set behavior of Navigation drawer
        subListNavigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    // This method will trigger on item Click of navigation menu
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // Set item in checked state
                        menuItem.setChecked(true);
                        // TODO: handle navigation
                        // Closing drawer on item click
                        subListDrawerLayout.closeDrawers();
                        return true;
                    }
                });

    }

    private void prepareSubListData(int BasicsTopic){

        SubList subListObject;

        switch (BasicsTopic) {
            case 0:
                for (int i = 0; i < introductionToLinux.length; i++){
                    subListObject = new SubList(introductionToLinux[i]);
                    sublist.add(subListObject);
                };
                break;
            case 1:
                for (int i = 0; i < whatIsTheTerminal.length; i++){
                    subListObject = new SubList(whatIsTheTerminal[i]);
                    sublist.add(subListObject);
                };
                break;
            case 2:
                for (int i = 0; i < programmersGuide.length; i++){
                    subListObject = new SubList(programmersGuide[i]);
                    sublist.add(subListObject);
                };
                break;
        }

        mSubListAdapter.notifyDataSetChanged();
    }

}
