package myapp.tae.ac.uk.makelondoneasy.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import myapp.tae.ac.uk.makelondoneasy.R;
import myapp.tae.ac.uk.makelondoneasy.adapters.AdapterJSHistory;
import myapp.tae.ac.uk.makelondoneasy.api.DataManager;

/**
 * Created by Karma on 28/01/16.
 */
public class JSHistory extends AppCompatActivity {
    private DataManager dataManager;
    private RecyclerView rcJSHistory;
    private AdapterJSHistory adapterJSHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jsearch_history_saved_layout);
        rcJSHistory = (RecyclerView) findViewById(R.id.rcJSearchHistory);
        dataManager = new DataManager(this);
        adapterJSHistory = new AdapterJSHistory(this, dataManager.getAllJourneys());
        rcJSHistory.setAdapter(adapterJSHistory);
    }

    public boolean rmJHistoryItem(int id) {
        return dataManager.rmJourney(id);
    }
}
