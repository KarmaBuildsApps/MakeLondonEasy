package myapp.tae.ac.uk.makelondoneasy.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.*;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import myapp.tae.ac.uk.makelondoneasy.R;
import myapp.tae.ac.uk.makelondoneasy.adapters.AdapterJSearchResult;
import myapp.tae.ac.uk.makelondoneasy.adapters.RestroInterface;
import myapp.tae.ac.uk.makelondoneasy.api.TFLInterface;
import myapp.tae.ac.uk.makelondoneasy.constants.Constants;
import myapp.tae.ac.uk.makelondoneasy.model.tofromJourney.Journey;
import myapp.tae.ac.uk.makelondoneasy.model.tofromJourney.ToFrom;
import myapp.tae.ac.uk.makelondoneasy.ui.extra.QueryOptions;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Karma on 26/01/16.
 */
public class JSearchResults extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    public static final String TAG = "JSearchResults";
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView rcJSearchResult;
    private AdapterJSearchResult adapterJSearchResult;
    private ProgressDialog progressDialog;
    private TFLInterface tflInterface = RestroInterface.getTFLInterface();
    private String fromIcsCode, toIcsCode;
    private QueryOptions parcelQOptions;
    private Map<String, String> queryOptions;
    private List<Journey> journeyOptions;
    private boolean isFirstStart = true;
    private String queryString;
    private Context thisClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jsearch_result_matched_options_layout);
        thisClass = this;
        rcJSearchResult = (RecyclerView) findViewById(R.id.rcJSearchResults);
        rcJSearchResult.setLayoutManager(new LinearLayoutManager(this));
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.srlJourneyResultsRefresh);
        swipeRefreshLayout.setOnRefreshListener(this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading Data...");
        if (savedInstanceState == null) {
            Bundle jSearchQueryBundle = getIntent().getExtras();
            fromIcsCode = jSearchQueryBundle.getString(Constants.FROM_ICSCODE);
            toIcsCode = jSearchQueryBundle.getString(Constants.TO_ICSCODE);
            parcelQOptions = jSearchQueryBundle.getParcelable(Constants.JOURNEY_INFO_BUNDLE);
        } else {
            fromIcsCode = savedInstanceState.getString(Constants.FROM_ICSCODE);
            toIcsCode = savedInstanceState.getString(Constants.TO_ICSCODE);
            parcelQOptions = savedInstanceState.getParcelable(Constants.JOURNEY_INFO_BUNDLE);
        }
        queryOptions = parcelQOptions.getQueryOptions();
        queryString = fromIcsCode + "/to/" + toIcsCode;
        getOrUpdateJourney();
    }

    public void getOrUpdateJourney() {
        if (!swipeRefreshLayout.isRefreshing())
            progressDialog.show();
        tflInterface.getJourney(queryString, queryOptions, new Callback<ToFrom>() {
            @Override
            public void success(ToFrom toFrom, Response response) {
                if (swipeRefreshLayout.isRefreshing())
                    swipeRefreshLayout.setRefreshing(false);
                else
                    progressDialog.dismiss();
                journeyOptions = toFrom.getJourneys();
                Log.i(TAG, "success: ");
                adapterJSearchResult = new AdapterJSearchResult(thisClass, journeyOptions);
                rcJSearchResult.setAdapter(adapterJSearchResult);
            }

            @Override
            public void failure(RetrofitError error) {
                if (swipeRefreshLayout.isRefreshing())
                    swipeRefreshLayout.setRefreshing(false);
                else
                    progressDialog.dismiss();
                Log.i(TAG, "failure: ");
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(Constants.JOURNEY_INFO_BUNDLE, parcelQOptions);
        outState.putString(Constants.FROM_ICSCODE, fromIcsCode);
        outState.putString(Constants.TO_ICSCODE, toIcsCode);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onRefresh() {
        getOrUpdateJourney();
    }

    public void showDetail(Journey journeyOption) {
        Intent i = new Intent(this, JSearchDirecText.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(Constants.JOURNEY_OPTION_DETAIL, journeyOption);
        i.putExtras(bundle);
        startActivity(i);
    }
}
