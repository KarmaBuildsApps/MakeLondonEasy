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
import android.widget.ArrayAdapter;

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
public class Fragment1 extends Fragment {
    private String TAG = "Journey Planner";
    private ProgressDialog progressDialog;
    private TFLInterface tflInterface;
    private AdapterJSearchResult adapterJSearchResult;
    private Map<String, String> searchFilter;
    private String query = "1000238/to/1000226";
    private ArrayAdapter<String> arrayAdapter;

    public Fragment1() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1_layout, container, false);
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading...");
        tflInterface = RestroInterface.getTFLInterface();
        return view;
    }


    public void updateJourneySearch() {
        progressDialog.show();
        tflInterface.getJourney(query, searchFilter, new Callback<ToFrom>() {
            @Override
            public void success(ToFrom toFrom, Response response) {
                progressDialog.dismiss();
            }

            @Override
            public void failure(RetrofitError error) {
                progressDialog.dismiss();

            }
        });
    }

}