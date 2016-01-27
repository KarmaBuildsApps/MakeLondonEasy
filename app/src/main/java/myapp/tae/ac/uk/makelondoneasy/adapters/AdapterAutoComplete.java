package myapp.tae.ac.uk.makelondoneasy.adapters;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import myapp.tae.ac.uk.makelondoneasy.R;
import myapp.tae.ac.uk.makelondoneasy.api.ItemOnClickInterface;
import myapp.tae.ac.uk.makelondoneasy.api.OnItemSelectedListenerAuto;
import myapp.tae.ac.uk.makelondoneasy.api.TFLInterface;
import myapp.tae.ac.uk.makelondoneasy.model.searchP.Match;
import myapp.tae.ac.uk.makelondoneasy.model.searchP.SearchPlace;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Karma on 25/01/16.
 */
public class AdapterAutoComplete extends BaseAdapter implements Filterable {
    private List<Match> matchedSuggestion = new ArrayList<>();
    private Context context;
    private TFLInterface tflInterface = RestroInterface.getTFLInterface();
    private static final String TAG = "AdapterAutoComplete";
    private boolean isValueChange = false;

    public AdapterAutoComplete(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return matchedSuggestion.size();
    }

    @Override
    public String getItem(int position) {
        return matchedSuggestion.get(position).getName();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * This method is used in JPlannerFragment when user select from autocomplete suggestions.
     *
     * @return
     */
    public List<Match> getLatestSelectedMatch() {
        return matchedSuggestion;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        TextView tvListItem;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.autocomplete_list_item_layout, parent, false);
        }
        tvListItem = (TextView) convertView.findViewById(R.id.tvAutocompleteList);
        tvListItem.setText(matchedSuggestion.get(position).getName());
        return convertView;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                final FilterResults filterResults = new FilterResults();
                if (constraint != null) {
                    tflInterface.getSearchSuggestion(constraint.toString(), new Callback<SearchPlace>() {
                        @Override
                        public void success(SearchPlace searchPlace, Response response) {
                            Log.i(TAG, "success: " + searchPlace.getMatches().size() + "");
                            List<Match> autoSuggestionMatches = searchPlace.getMatches();
                            filterResults.values = autoSuggestionMatches;
                            filterResults.count = autoSuggestionMatches.size();
                            matchedSuggestion = autoSuggestionMatches;
                            isValueChange = true;
                        }

                        @Override
                        public void failure(RetrofitError error) {
                            Log.i(TAG, "failure: Auto search failed");
                        }
                    });
                }
                Log.i(TAG, "performFiltering: match size " + matchedSuggestion.size());
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                if (isValueChange && matchedSuggestion.size() > 0) {
                    isValueChange = false;
                    results.values = matchedSuggestion;
                    results.count = matchedSuggestion.size();
                    notifyDataSetChanged();
                } else {
                    notifyDataSetInvalidated();
                }
            }
        };
        return filter;
    }

}
