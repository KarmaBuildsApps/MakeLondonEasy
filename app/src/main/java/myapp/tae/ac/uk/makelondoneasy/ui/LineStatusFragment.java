package myapp.tae.ac.uk.makelondoneasy.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
public class LineStatusFragment extends Fragment {
    private RecyclerView rcStatus;
    private AdapterLineStatus adapterLineStatus;
    private TFLLineStatus tflLineStatusInfo;
    ProgressDialog progressDialog;
    //    private ProgressDialog progressDialog = RestroInterface.getProgressDialog(getActivity());
    private TFLInterface tflInterface = tflInterface = RestroInterface.getTFLInterface();//get interface

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lines_status_layout, container, false);
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading ..");
        progressDialog.show();
        rcStatus = (RecyclerView) view.findViewById(R.id.rcLineStatus);
        rcStatus.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateStatus();
        return view;
    }

    public void updateStatus() {
        progressDialog.show();
        tflInterface.getLineStatus(Constants.LINE_MODE_DEFAULT, new Callback<List<TFLLineStatus>>() {
            @Override
            public void success(List<TFLLineStatus> tflLineStatuses, Response response) {
                Log.i("StatusBar", "Success");
                progressDialog.dismiss();
                tflLineStatusInfo = tflLineStatuses.get(0);
                adapterLineStatus = new AdapterLineStatus(getActivity(), tflLineStatuses);
                rcStatus.setAdapter(adapterLineStatus);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

}
