package com.example.thomas.gr23;

import android.app.ActionBar;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toolbar;

public class Store extends AppCompatActivity implements View.OnClickListener {

    private BottomNavigationView mainNavigation;
    private ViewPager viewPager;


    //vores fragmenter det hører til bund-navigations-menuen
    private HomeFragment homeFragment;
    private SearchFragment searchFragment;
    private PersonFragment personFragment;
    MenuItem tideligereMenuItem;

    private DrawerLayout drawerlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.menu_icon);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        mainNavigation =(BottomNavigationView) findViewById(R.id.store_navigation);


        setupViewPager(viewPager);

        mainNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int clicked = item.getItemId();

                if (clicked == R.id.navigation_hjem) {
                    viewPager.setCurrentItem(0);
                    return true;
                } else if (clicked == R.id.navigation_kategori) {
                    viewPager.setCurrentItem(1);
                    return true;
                } else if (clicked == R.id.navigation_person) {
                    viewPager.setCurrentItem(2);
                    return true;
                } else {
                    return false;
                }
            }

        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            public void onPageSelected(int position) {
                if (tideligereMenuItem != null) {
                    tideligereMenuItem.setChecked(false);
                } else {
                    mainNavigation.getMenu().getItem(0).setChecked(false);
                }
                mainNavigation.getMenu().getItem(position).setChecked(true);
                tideligereMenuItem = mainNavigation.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(this);


        drawerlayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.burgermenu);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                drawerlayout.closeDrawers();
                return false;
            }
        });


    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        homeFragment = new HomeFragment();
        searchFragment = new SearchFragment();
        personFragment = new PersonFragment();
        adapter.addFragment(homeFragment);
        adapter.addFragment(searchFragment );
        adapter.addFragment(personFragment);
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        if(v == findViewById(R.id.fab)){
            Intent i = new Intent(this, uploadopskrift.class);
            startActivity(i);
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerlayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.guidehækling:
                Intent i = new Intent(this, Guidehækling.class);
                startActivity(i);
                return true;
            case R.id.guidestrikning:
                Intent ii = new Intent(this, Guidestrikning.class);
                startActivity(ii);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
