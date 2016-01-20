package myapp.tae.ac.uk.makelondoneasy.api;

import java.util.Map;

import myapp.tae.ac.uk.makelondoneasy.constants.Constants;
import myapp.tae.ac.uk.makelondoneasy.model.lineStatus.TFLLineStatus;
import myapp.tae.ac.uk.makelondoneasy.model.searchP.SearchPlace;
import myapp.tae.ac.uk.makelondoneasy.model.tofromJourney.ToFrom;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.http.QueryMap;

/**
 * Created by Karma on 17/01/16.
 */
public interface TFLInterface {
    //https://api.tfl.gov.uk/journey/journeyresults/1000248/to/1000068?nationalsearch=false&timeis=departing&journeypreference=leasttime&walkingspeed=average&cyclepreference=none&alternativecycle=false&alternativewalking=true&applyhtmlmarkup=false&usemultimodalcall=false

    /**
     * This method request for route for FROM place to TO place. The returned response contains journey
     * duration, full path details, path status, and many more.
     *
     * @param toFrom
     * @param myQuery
     * @param options
     */
    @GET(Constants.JOURNEY_TO_FROM_QUERY)
    public void getJourney(Callback<ToFrom> toFrom, @Path("to_from_query") String myQuery, @QueryMap Map<String, String> options);

    /**
     * The method is for TO and FROM form fields. It will suggests user (auto-suggest) names of place that matched
     * user typed text.
     * Constants.SEARCH_STOPPOINT_REQUEST_QUERY has an option (modes=tube,dlr,bus,many more). The option filters search and reduce
     * search scope. If mode is not specified the query search names of places in whole UK.
     *
     * @param searchSuggest
     * @param userSearch
     */
    @GET(Constants.SEARCH_STOPPOINT_REQUEST_QUERY)
    public void getSearchSuggestion(Callback<SearchPlace> searchSuggest, @Path("query-terms") String userSearch);

    //https://api.tfl.gov.uk/Line/Mode/tube,dlr,overground,tflrail/Status

    /**
     * The method makes query to the TFL about the status of train, tube, bus (modes),etc.
     * The response for the query request returns how good are lines for specified mode(s), if there
     * is(are) any line disruption, delay and many more.
     *
     * @param status
     * @param modesForStatus
     */
    @GET(Constants.JOURNEY_LINE_STATUS_QUERY)
    public void getLineStatus(Callback<TFLLineStatus> status, @Query("modes") String modesForStatus);


}
