package com.tanvirsingh.essentiallinuxguide;

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
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class sub_list_activty extends AppCompatActivity {

    private DrawerLayout subListDrawerLayout;
    private List<SubList> sublist = new ArrayList<>();
    private RecyclerView recyclerView;
    private SubListAdapter mSubListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Select Sub-Topic!");
        setContentView(R.layout.activity_sub_list_activty);

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

        prepareSubListData();

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

    private void prepareSubListData(){
        SubList subListObject = new SubList("Test 1");
        sublist.add(subListObject);

        subListObject = new SubList("Test 2");
        sublist.add(subListObject);

        subListObject = new SubList("Test 3");
        sublist.add(subListObject);

        mSubListAdapter.notifyDataSetChanged();
    }

}
