package myapp.tae.ac.uk.makelondoneasy.ui;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatSpinner;
import android.util.ArrayMap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.github.johnpersano.supertoasts.SuperToast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import myapp.tae.ac.uk.makelondoneasy.R;
import myapp.tae.ac.uk.makelondoneasy.adapters.AdapterAutoComplete;
import myapp.tae.ac.uk.makelondoneasy.adapters.AdapterJSearchResult;
import myapp.tae.ac.uk.makelondoneasy.adapters.RestroInterface;
import myapp.tae.ac.uk.makelondoneasy.api.TFLInterface;
import myapp.tae.ac.uk.makelondoneasy.constants.Constants;
import myapp.tae.ac.uk.makelondoneasy.model.searchP.Match;
import myapp.tae.ac.uk.makelondoneasy.model.searchP.SearchPlace;
import myapp.tae.ac.uk.makelondoneasy.model.tofromJourney.ToFrom;
import myapp.tae.ac.uk.makelondoneasy.ui.extra.DelayAutoCompleteTextView;
import myapp.tae.ac.uk.makelondoneasy.ui.extra.QueryOptions;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Karma on 19/01/16.
 */
public class JPlannerFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    private static final int THRESHOLD = 3;
    private static final String TAG = "Fragment1";
    private Button btSearch;
    private DelayAutoCompleteTextView autoToPlace, autoFromPlace;
    private ProgressBar pBarToAuto, pBarFromAuto;
    private TextView filterOptions;
    private RelativeLayout rlFilter;
    private CheckBox chNationSearch;
    private RadioGroup rgTimeIs;
    private Spinner spJPref;
    private ArrayAdapter<String> spinnerAdapter;
    private List<String> jPrefOptions = new ArrayList<>();


    private ProgressDialog progressDialog;
    private TFLInterface tflInterface;
    private AdapterJSearchResult adapterJSearchResult;
    private HashMap<String, String> searchFilter = new HashMap<>();
    private String query = "1000238/to/1000226";
    private AdapterAutoComplete autoCompleteAdapter;
    private String toPlaceIcsCode = "";
    private String fromPlaceIcsCode = "";

    public JPlannerFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.jplanner_fragment_layout, container, false);
        startViews(view);
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading...");
        tflInterface = RestroInterface.getTFLInterface();
//        getAutoSuggest();
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(Constants.FROM_ICSCODE, fromPlaceIcsCode);
        outState.putString(Constants.TO_ICSCODE, toPlaceIcsCode);
        outState.putParcelable(Constants.JOURNEY_INFO_BUNDLE, new QueryOptions(searchFilter));

        super.onSaveInstanceState(outState);
    }



    private void startViews(View view) {
        btSearch = (Button) view.findViewById(R.id.btSearchJourney);
        autoCompleteAdapter = new AdapterAutoComplete(getActivity());
        autoFromPlace = (DelayAutoCompleteTextView) view.findViewById(R.id.actvFromSearch);
        pBarFromAuto = (ProgressBar) view.findViewById(R.id.pbFromAutoComplete);
        autoFromPlace.setThreshold(THRESHOLD);
        autoFromPlace.setAdapter(autoCompleteAdapter);
        autoFromPlace.setmLoadingIndicator(pBarFromAuto);
        autoFromPlace.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                List<Match> matches = autoCompleteAdapter.getLatestSelectedMatch();
                Match match = matches.get(position);
                if (match != null) {
                    fromPlaceIcsCode = match.getIcsId();
                    Log.i(TAG, "onItemClick: fromicsid" + fromPlaceIcsCode);
                    Log.i(TAG, "onItemClick: Name" + match.getName());
                }
            }
        });

        autoToPlace = (DelayAutoCompleteTextView) view.findViewById(R.id.actvToSearch);
        pBarToAuto = (ProgressBar) view.findViewById(R.id.pbToAutoComplete);
        autoToPlace.setThreshold(THRESHOLD);
        autoToPlace.setAdapter(autoCompleteAdapter);
        autoToPlace.setmLoadingIndicator(pBarToAuto);
        autoToPlace.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // FIXME: 27/01/16 parent.getItem method does returns null inplace of Match object
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                List<Match> matches = autoCompleteAdapter.getLatestSelectedMatch();
                Match match = matches.get(position);
                if (match != null) {
                    toPlaceIcsCode = match.getIcsId();
                    Log.i(TAG, "onItemClick: toicscode " + toPlaceIcsCode);
                    Log.i(TAG, "onItemClick: Name " + match.getName());
                }
            }
        });
        btSearch.setOnClickListener(this);

        filterOptions = (TextView) view.findViewById(R.id.tvFilterSearch);
        filterOptions.setOnClickListener(this);
        rlFilter = (RelativeLayout) view.findViewById(R.id.rlJSearchFilter);
        rlFilter.setVisibility(View.GONE);
        chNationSearch = (CheckBox) view.findViewById(R.id.cbJFilterNation);
        rgTimeIs = (RadioGroup) view.findViewById(R.id.rgJSFilterTimeIs);
        spJPref = (Spinner) view.findViewById(R.id.spJSearchFilterJPref);
        fillSpinnerList();
        spinnerAdapter = new ArrayAdapter<String>(getActivity(), R.layout.support_simple_spinner_dropdown_item, jPrefOptions);
        spJPref.setAdapter(spinnerAdapter);
        spJPref.setOnItemSelectedListener(this);

    }

    private void fillSpinnerList() {
        jPrefOptions.add("Least Interchange");
        jPrefOptions.add("Least Time");
        jPrefOptions.add("Least Walking");
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

    public void getAutoSuggest(String curTypingText) {
        tflInterface.getSearchSuggestion(curTypingText, new Callback<SearchPlace>() {
            @Override
            public void success(SearchPlace searchPlace, Response response) {
                Log.i("Fragment", "Success: " + searchPlace.getMatches());
            }

            @Override
            public void failure(RetrofitError error) {
                Log.i("Fragment", "Failure: ");
            }
        });
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        switch (viewId) {
            case R.id.btSearchJourney:
                if (fromPlaceIcsCode.equals("") | toPlaceIcsCode.equals("")) {
                    SuperToast.create(getActivity(), "Journey Search is invalid", Toast.LENGTH_LONG).show();
                } else {
                    Intent i = new Intent(getActivity(), JSearchResults.class);
                    Bundle bundle = new Bundle();
                    bundle.putString(Constants.FROM_ICSCODE, fromPlaceIcsCode);
                    bundle.putString(Constants.TO_ICSCODE, toPlaceIcsCode);
                    bundle.putParcelable(Constants.JOURNEY_INFO_BUNDLE, new QueryOptions(searchFilter));
                    i.putExtras(bundle);
                    startActivity(i);
                }
                break;
            case R.id.tvFilterSearch:
                if (rlFilter.getVisibility() == View.GONE) {
                    expand();
                } else {
                    collapse();
                }
                break;
            default:
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    /*----- For Animation ---------*/

    private void expand() {
        //set Visible
        rlFilter.setVisibility(View.VISIBLE);

        int widthSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int heightSpec = View.MeasureSpec.makeMeasureSpec(rlFilter.getHeight(), View.MeasureSpec.UNSPECIFIED);
        rlFilter.measure(widthSpec, heightSpec);

        ValueAnimator mAnimator = slideAnimator(0, rlFilter.getMeasuredHeight());
        mAnimator.start();
    }

    private ValueAnimator slideAnimator(int start, int end) {

        ValueAnimator animator = ValueAnimator.ofInt(start, end);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                //Update Height
                int value = (Integer) valueAnimator.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = rlFilter.getLayoutParams();
                layoutParams.height = value;
                rlFilter.requestLayout();
            }
        });
        return animator;
    }

    private void collapse() {
        int finalHeight = rlFilter.getHeight();

        ValueAnimator mAnimator = slideAnimator(finalHeight, 0);

        mAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                //Height=0, but it set visibility to GONE
                rlFilter.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        mAnimator.start();
    }
}