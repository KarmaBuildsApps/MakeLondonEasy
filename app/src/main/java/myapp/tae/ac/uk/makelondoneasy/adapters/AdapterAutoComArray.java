package myapp.tae.ac.uk.makelondoneasy.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Filterable;

/**
 * Created by Karma on 25/01/16.
 */
public class AdapterAutoComArray extends ArrayAdapter<String> implements Filterable {
    public AdapterAutoComArray(Context context, int resource) {
        super(context, resource);
    }
}
