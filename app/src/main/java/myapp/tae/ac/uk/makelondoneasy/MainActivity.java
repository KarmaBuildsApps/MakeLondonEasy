package myapp.tae.ac.uk.makelondoneasy;

import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import com.astuetz.PagerSlidingTabStrip;
import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import myapp.tae.ac.uk.makelondoneasy.adapters.AdapterPager;
import myapp.tae.ac.uk.makelondoneasy.adapters.RestroInterface;
import myapp.tae.ac.uk.makelondoneasy.api.TFLInterface;
import myapp.tae.ac.uk.makelondoneasy.model.lineStatus.TFLLineStatus;
import myapp.tae.ac.uk.makelondoneasy.model.searchP.SearchPlace;
import myapp.tae.ac.uk.makelondoneasy.model.tofromJourney.ToFrom;
import myapp.tae.ac.uk.makelondoneasy.ui.JPlannerFragment;
import myapp.tae.ac.uk.makelondoneasy.ui.LineStatusFragment;
import myapp.tae.ac.uk.makelondoneasy.ui.NavigationMenuFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    DrawerLayout navDrawerLayout;
    Toolbar toolbar;
    ViewPager viewPager;
    AdapterPager pagerAdapter;
    PagerSlidingTabStrip tabs;
    ActionBarDrawerToggle navToggleBar;
    NavigationMenuFragment nvMenuFragment;
    LineStatusFragment lineStatusFragment;
    TFLInterface tflInterface;
    TFLLineStatus lineStatus;
    SearchPlace searchPlace;
    ToFrom toFromJourney;


    Map<String, String> queryOptions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main_layout);
        viewPager = (ViewPager) findViewById(R.id.fragmentVPager);
        tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        List<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(new JPlannerFragment());
        fragments.add(new LineStatusFragment());
        pagerAdapter = new AdapterPager(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(pagerAdapter);
        tabs.setViewPager(viewPager);
        navDrawerLayout = (DrawerLayout) findViewById(R.id.navDrawerLayout);
        setToolbar();
        setToggle();
        navDrawerLayout.setDrawerListener(navToggleBar);
        nvMenuFragment = (NavigationMenuFragment) getSupportFragmentManager().findFragmentById(R.id.nvMenuFragment);
        nvMenuFragment.sendDrawerLayout(navDrawerLayout);
//        startBodyFragment();
        queryOptions = new HashMap<>();
        tflInterface = RestroInterface.getTFLInterface();
//        tflInterface.getJourney("1000248/to/1000068", queryOptions, new Callback<ToFrom>() {
//            @Override
//            public void success(ToFrom toFrom, Response response) {
//                Log.i("MainActivity", "Success");
//            }
//
//            @Override
//            public void failure(RetrofitError error) {
//                Log.i("MainActivity", "Failure");
//            }
//        });
    }

    private void startBodyFragment() {
        getSupportFragmentManager().beginTransaction().add(R.id.flBodyFragment, new LineStatusFragment()).commit();
    }

    private void setToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void setToggle() {
        navToggleBar = new ActionBarDrawerToggle(this, navDrawerLayout, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {


            }
        };
        navToggleBar.setDrawerIndicatorEnabled(false); //disable "hamburger to arrow" drawable
        navToggleBar.setHomeAsUpIndicator(R.drawable.menu);
        navToggleBar.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        navDrawerLayout.openDrawer(GravityCompat.START);
    }
}
