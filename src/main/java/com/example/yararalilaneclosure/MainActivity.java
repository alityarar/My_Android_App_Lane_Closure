package com.example.yararalilaneclosure;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;


@SuppressWarnings("ALL")

public class MainActivity extends AppCompatActivity implements Fragment2.DataAddedListener, Fragment2.FragmentNavigationListener, Fragment1.FragmentNavigationListener {
    private Fragment1 fragment1;
    private Fragment2 fragment2;

    private ViewPagerAdapter viewPagerAdapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        viewPager = findViewById(R.id.viewpager);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);


        // setting up the adapter
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        // Create instances of Fragment1 and Fragment2
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();

        // Pass the DataAddedListener and FragmentNavigationListener to Fragment2
        fragment2.setDataAddedListener(this);

        // add the fragments
        viewPagerAdapter.add(fragment1, "Lane Closure List");
        viewPagerAdapter.add(fragment2, "Select Lane Closure");

        // Set the adapter
        viewPager.setAdapter(viewPagerAdapter);

        // The Page (fragment) titles will be displayed in the
        // tabLayout hence we need to set the page viewer
        // we use the setupWithViewPager().
        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onDataAdded() {
        // Called when data is added in Fragment2
        // Update Fragment1
        fragment1.updateLayouts();
    }

    @Override
    public void navigateToFragment1() {
        viewPager.setCurrentItem(0);
    }
    @Override
    public void navigateToFragment2() {
        viewPager.setCurrentItem(1);
    }
}

