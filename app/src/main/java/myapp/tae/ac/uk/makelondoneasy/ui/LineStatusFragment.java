package myapp.tae.ac.uk.makelondoneasy.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import myapp.tae.ac.uk.makelondoneasy.R;
import myapp.tae.ac.uk.makelondoneasy.adapters.AdapterLineStatus;
import myapp.tae.ac.uk.makelondoneasy.adapters.RestroInterface;
import myapp.tae.ac.uk.makelondoneasy.api.TFLInterface;
import myapp.tae.ac.uk.makelondoneasy.constants.Constants;
import myapp.tae.ac.uk.makelondoneasy.model.lineStatus.TFLLineStatus;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Karma on 20/01/16.
 */
public class LineStatusFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private String TAG = "Line Status";
    private RecyclerView rcStatus;
    private AdapterLineStatus adapterLineStatus;
    private TFLLineStatus tflLineStatusInfo;
    private ProgressDialog progressDialog;
    private SwipeRefreshLayout swipeLayout;

    //    private ProgressDialog progressDialog = RestroInterface.getProgressDialog(getActivity());
    private TFLInterface tflInterface = RestroInterface.getTFLInterface();//get interface

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lines_status_layout, container, false);
        swipeLayout = (SwipeRefreshLayout) view.findViewById(R.id.srlLineStatus);
        swipeLayout.setOnRefreshListener(this);
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading ...");
        progressDialog.show();
        rcStatus = (RecyclerView) view.findViewById(R.id.rcLineStatus);
        rcStatus.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateStatus();
        return view;
    }

    public void updateStatus() {
        if (!swipeLayout.isRefreshing())
            progressDialog.show();
        if (isNetworkAvailable()) {
            tflInterface.getLineStatus(Constants.LINE_MODE_DEFAULT, new Callback<List<TFLLineStatus>>() {
                @Override
                public void success(List<TFLLineStatus> tflLineStatuses, Response response) {
                    Log.i("StatusBar", "Success");
                    progressDialog.dismiss();
                    tflLineStatusInfo = tflLineStatuses.get(0);
                    adapterLineStatus = new AdapterLineStatus(getActivity(), tflLineStatuses);
                    rcStatus.setAdapter(adapterLineStatus);
                    if (swipeLayout.isRefreshing()) {
                        rcStatus.invalidate();
                        swipeLayout.setRefreshing(false);
                    }
                }

                @Override
                public void failure(RetrofitError error) {
                    progressDialog.dismiss();
                    if (swipeLayout.isRefreshing())
                        swipeLayout.setRefreshing(false);

                }
            });
        } else {
            adapterLineStatus = new AdapterLineStatus(getActivity(), null);
            rcStatus.setAdapter(adapterLineStatus);
            Toast.makeText(getActivity(), "Intent Not Found!", Toast.LENGTH_LONG).show();
            progressDialog.dismiss();
            swipeLayout.setRefreshing(false);
        }

    }

    @Override
    public void onRefresh() {
//        new StatusUpdater().execute();
        updateStatus();
//        swipeLayout.setRefreshing(false);
    }

    public String getTagName() {
        return TAG;
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}
