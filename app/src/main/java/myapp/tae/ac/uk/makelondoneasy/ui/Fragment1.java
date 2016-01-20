package myapp.tae.ac.uk.makelondoneasy.ui;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import myapp.tae.ac.uk.makelondoneasy.R;

/**
 * Created by Karma on 19/01/16.
 */
public class Fragment1 extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private SwipeRefreshLayout swipeLayout;

    public Fragment1(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1_layout, container, false);
        swipeLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeLayout);
        swipeLayout.setOnRefreshListener(this);
        return view;
    }


    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeLayout.setRefreshing(false);
            }
        }, 5000);
    }
}