package myapp.tae.ac.uk.makelondoneasy.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import myapp.tae.ac.uk.makelondoneasy.R;
import myapp.tae.ac.uk.makelondoneasy.adapters.AdapterJSearchDirText;
import myapp.tae.ac.uk.makelondoneasy.constants.Constants;
import myapp.tae.ac.uk.makelondoneasy.model.tofromJourney.Journey;

/**
 * Created by Karma on 26/01/16.
 */
public class JSearchDirecText extends AppCompatActivity {
    private RecyclerView rcOptionDirection;
    private AdapterJSearchDirText adapterJSearchDirText;
    private Journey journeyOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jsearch_direction_text_layout);
        journeyOption = getIntent().getParcelableExtra(Constants.JOURNEY_OPTION_DETAIL);
        adapterJSearchDirText = new AdapterJSearchDirText(this, journeyOption);
        rcOptionDirection = (RecyclerView) findViewById(R.id.rcJSearchDirText);
        rcOptionDirection.setAdapter(adapterJSearchDirText);
    }
}
