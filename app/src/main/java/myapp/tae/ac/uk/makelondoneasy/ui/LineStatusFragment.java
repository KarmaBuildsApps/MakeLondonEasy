package myapp.tae.ac.uk.makelondoneasy.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import myapp.tae.ac.uk.makelondoneasy.R;
import myapp.tae.ac.uk.makelondoneasy.adapters.AdapterLineStatus;

/**
 * Created by Karma on 20/01/16.
 */
public class LineStatusFragment extends Fragment {
    private RecyclerView rcStatus;
    private AdapterLineStatus adapterLineStatus;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lines_status, container, false);
        rcStatus = (RecyclerView) view.findViewById(R.id.rcLineStatus);
        rcStatus.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapterLineStatus = new AdapterLineStatus(getActivity());
        rcStatus.setAdapter(adapterLineStatus);
        return view;
    }
}
