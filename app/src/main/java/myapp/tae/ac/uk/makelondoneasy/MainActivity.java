package myapp.tae.ac.uk.makelondoneasy;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import com.astuetz.PagerSlidingTabStrip;
import com.crashlytics.android.Crashlytics;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONObject;

import io.fabric.sdk.android.Fabric;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import myapp.tae.ac.uk.makelondoneasy.adapters.AdapterPager;
import myapp.tae.ac.uk.makelondoneasy.adapters.RestroInterface;
import myapp.tae.ac.uk.makelondoneasy.api.TFLInterface;
import myapp.tae.ac.uk.makelondoneasy.model.lineStatus.TFLLineStatus;
import myapp.tae.ac.uk.makelondoneasy.model.searchP.SearchPlace;
import myapp.tae.ac.uk.makelondoneasy.model.tofromJourney.ToFrom;
import myapp.tae.ac.uk.makelondoneasy.push_notification.GcmRegistrationAsyncTask;
import myapp.tae.ac.uk.makelondoneasy.ui.JPlannerFragment;
import myapp.tae.ac.uk.makelondoneasy.ui.LineStatusFragment;
import myapp.tae.ac.uk.makelondoneasy.ui.NavigationMenuFragment;
import myapp.tae.ac.uk.makelondoneasy.ui.PMethodPayPal;
import myapp.tae.ac.uk.makelondoneasy.ui.JSHistory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    static final String TAG = "MainActivity";
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
    LoginButton fButton;


    Map<String, String> queryOptions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startFacebookService();
        Fabric.with(this, new Crashlytics());
        startGCMService();
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


    public void performActionOnNavClicked(int pos) {
        switch (pos) {
            case 0:
                viewPager.setCurrentItem(0);
                break;
            case 1:
                viewPager.setCurrentItem(1);
                break;
            case 2:
                Intent i = new Intent(this, JSHistory.class);
                startActivity(i);
                break;
            case 3:
                fButton.performClick();
                break;
            case 4:
                Intent intent = new Intent(this, PMethodPayPal.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Logs 'install' and 'app activate' App Events.
        AppEventsLogger.activateApp(this);
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Logs 'app deactivate' App Event.
        AppEventsLogger.deactivateApp(this);
    }

    private void startFacebookService() {
        FacebookSdk.sdkInitialize(getApplicationContext());
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "myapp.tae.ac.uk.makelondoneasy",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
        fButton = new LoginButton(this);
        CallbackManager callbackManager = CallbackManager.Factory.create();
        fButton.setReadPermissions(Arrays.asList("public_profile", "user_friends", "user_birthday", "email", "user_status"));
        fButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.i(TAG, "onSuccess: Facebook sign in done");
                GraphRequest graphRequest = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {

                    }
                });
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id, name , link, birthday, picture, email, gender");
                graphRequest.setParameters(parameters);
                graphRequest.setParameters(parameters);
                graphRequest.executeAsync();
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {
                Log.e(TAG, "onError: Error login in Facebook", error);
            }
        });
    }

    private void startGCMService() {
        GcmRegistrationAsyncTask gcm = new GcmRegistrationAsyncTask(this);
        gcm.execute();
        Log.i(TAG, "startGCMService: has started");
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

    public void toolBarItemClick(View view) {
        switch (view.getId()) {
            case R.id.ivToolBarFacebook:
                fButton.performClick();
                break;
            case R.id.ivToolbarPaypal:
                Intent i = new Intent(this, PMethodPayPal.class);
                startActivity(i);
                break;
            default:
                break;
        }
    }

    /**
     * Set a callback in the facebook button to retrieve a response from Facebook with the user data
     */
    private void showFacebookLogin() {
        Log.i(TAG, "setFacebookLoginButton: ");


    }

}
