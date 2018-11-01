package com.example.thomas.gr23;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

public class Store extends AppCompatActivity implements View.OnClickListener {

    private BottomNavigationView mainNavigation;
    private ViewPager viewPager;

    //vores fragmenter det hører til bund-navigations-menuen
    private HomeFragment homeFragment;
    private SearchFragment searchFragment;
    private PersonFragment personFragment;
    MenuItem tideligereMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
}
