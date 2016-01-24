package myapp.tae.ac.uk.makelondoneasy.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import myapp.tae.ac.uk.makelondoneasy.R;
import myapp.tae.ac.uk.makelondoneasy.adapters.AdapterJSearchResult;
import myapp.tae.ac.uk.makelondoneasy.adapters.RestroInterface;
import myapp.tae.ac.uk.makelondoneasy.api.TFLInterface;
import myapp.tae.ac.uk.makelondoneasy.constants.Constants;
import myapp.tae.ac.uk.makelondoneasy.model.tofromJourney.ToFrom;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Karma on 19/01/16.
 */
public class Fragment1 extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private String TAG = "Journey Planner";
    private SwipeRefreshLayout swipeLayout;
    private ProgressDialog progressDialog;
    private TFLInterface tflInterface;
    private RecyclerView rcJSearchResult;
    private AdapterJSearchResult adapterJSearchResult;
    private Map<String, String> searchFilter;
    private boolean isSearched = false;
    private String query = "1000238/to/1000226";
    private List<myapp.tae.ac.uk.makelondoneasy.model.tofromJourney.Journey> journeyOptions;

    public Fragment1() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1_layout, container, false);
        swipeLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeLayout);
        swipeLayout.setOnRefreshListener(this);
        rcJSearchResult = (RecyclerView) view.findViewById(R.id.rcJourneySearchResults);
        rcJSearchResult.setHasFixedSize(true);
        rcJSearchResult.setLayoutManager(new LinearLayoutManager(rcJSearchResult.getContext()));
        searchFilter = new HashMap<>();
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading...");
        tflInterface = RestroInterface.getTFLInterface();
        updateJourneySearch();
        return view;
    }

    public void updateJourneySearch() {
        if (!swipeLayout.isRefreshing())
            progressDialog.show();
        tflInterface.getJourney(query, searchFilter, new Callback<ToFrom>() {
            @Override
            public void success(ToFrom toFrom, Response response) {
                progressDialog.dismiss();
                journeyOptions = toFrom.getJourneys();
                adapterJSearchResult = new AdapterJSearchResult(getActivity(), journeyOptions);
                rcJSearchResult.setAdapter(adapterJSearchResult);
            }

            @Override
            public void failure(RetrofitError error) {
                progressDialog.dismiss();

            }
        });
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeLayout.setRefreshing(false);
            }
        }, 1000);
    }

    public String getTagName() {
        return TAG;
    }

}