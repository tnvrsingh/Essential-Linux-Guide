package com.tanvirsingh.essentiallinuxguide;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class basics_list extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.basics_list_name);
        setContentView(R.layout.activity_basics_list);

        // Adding Toolbar to Main screen


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Create Navigation drawer and inflate layout
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);

// Adding menu icon to Toolbar
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }

// Set behavior of Navigation drawer
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    // This method will trigger on item Click of navigation menu
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // Set item in checked state
                        menuItem.setChecked(true);
                        // TODO: handle navigation
                        // Closing drawer on item click
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }
}
