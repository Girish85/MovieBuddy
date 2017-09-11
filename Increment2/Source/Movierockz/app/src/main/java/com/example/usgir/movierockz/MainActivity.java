package com.example.usgir.movierockz;

import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import layout.Movie;
import layout.Movie1;
import layout.movieupdate;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ListView listView;
    ActionBarDrawerToggle drawerToggle;
    String categories[];
    android.app.FragmentManager fragmentManager;
    FragmentTransaction transaction;
    Movie movie;
    Toolbar toolbar;
    Movie1 mov1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.list);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer);
        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        categories = new String[]{"Movies","TV Shows","Latest","Account","Share","settings"};
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,R.layout.listitem,R.id.textView,categories);
        listView.setAdapter(arrayAdapter);
        toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setActionBar(toolbar);
        //getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        movie = new Movie();
        mov1 = new Movie1();
        movieupdate movie1 = new movieupdate();
        fragmentManager = getFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.content,movie1);
        transaction.commit();
        drawerToggle.syncState();
    }
    private void setActionBar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuitems,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }
}
