package myapp.tae.ac.uk.makelondoneasy;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;

import java.util.HashMap;
import java.util.Map;

import myapp.tae.ac.uk.makelondoneasy.adapters.RestroInterface;
import myapp.tae.ac.uk.makelondoneasy.api.TFLInterface;
import myapp.tae.ac.uk.makelondoneasy.model.tofromJourney.ToFrom;
import myapp.tae.ac.uk.makelondoneasy.ui.Fragment1;
import myapp.tae.ac.uk.makelondoneasy.ui.LineStatusFragment;
import myapp.tae.ac.uk.makelondoneasy.ui.NavigationMenuFragment;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private DrawerLayout navDrawerLayout;
    private Toolbar toolbar;
    private ActionBarDrawerToggle navToggleBar;
    NavigationMenuFragment nvMenuFragment;
    LineStatusFragment lineStatusFragment;
    private TFLInterface tflInterface;
    Map<String, String> queryOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);
        navDrawerLayout = (DrawerLayout) findViewById(R.id.navDrawerLayout);
        setToolbar();
        setToggle();
        navDrawerLayout.setDrawerListener(navToggleBar);
        nvMenuFragment = (NavigationMenuFragment) getSupportFragmentManager().findFragmentById(R.id.nvMenuFragment);
        nvMenuFragment.sendDrawerLayout(navDrawerLayout);
        startBodyFragment();
        queryOptions = new HashMap<>();
        tflInterface = RestroInterface.getTFLInterface();
        tflInterface.getJourney("1000248/to/1000068", queryOptions, new Callback<ToFrom>() {
            @Override
            public void success(ToFrom toFrom, Response response) {

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
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
//                navDrawerLayout.closeDrawers();
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

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                navDrawerLayout.openDrawer(GravityCompat.START);  // OPEN DRAWER
//                return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
//        return super.onPrepareOptionsMenu(menu);
        // If the nav drawer is open, hide action items related to the content view
//        boolean drawerOpen = navDrawerLayout.isDrawerOpen(GravityCompat.START);
//        menu.findItem(R.id.action_websearch).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void onClick(View v) {
        navDrawerLayout.openDrawer(GravityCompat.START);
    }
}
