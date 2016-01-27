package myapp.tae.ac.uk.makelondoneasy.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


import myapp.tae.ac.uk.makelondoneasy.R;

/**
 * Created by Karma on 26/01/16.
 */
public class JSearchMap extends FragmentActivity implements OnMapReadyCallback {
    private SupportMapFragment jPlannerMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jsearch_direction_map_layout);
        jPlannerMap =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.fJPlannerMap);
        jPlannerMap.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        map.setMyLocationEnabled(true);
        map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        map.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
    }
}
