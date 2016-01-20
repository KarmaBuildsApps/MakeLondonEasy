package myapp.tae.ac.uk.makelondoneasy.constants;

/**
 * Created by Karma on 17/01/16.
 */
public class Constants {
    public static final String BASE_URL = "https://api.tfl.gov.uk";
    public static final String JOURNEY_TO_FROM_QUERY = "/journey/journeyresults/{to_from_query}";
    public static final String SEARCH_STOPPOINT_REQUEST_QUERY = "/Stoppoint/Search/{query-terms}";
    public static final String SEARCH_MODE_TUBE = "?modes=tube";
    public static final String JOURNEY_LINE_STATUS_QUERY = "/Line/Mode/{modes}/Status";
    public static final String AUTO_TEXT_SUGGEST = "/Stoppoint/Search/";
    public static final String LINE_DISRUPTION_STATUS = "/Line/Mode/tube,dlr,overground,tflrail/Status";
    public static final String STOP_TYPE_TUBE = "NaptanMetroStation";
    public static final String STOP_TYPE_BUS = "NaptanPublicBusCoachTram";
    public static final String LINE_MODE_TUBE = "tube";
    public static final String LINE_MODE_RAIL = "tflrai";
    public static final String LINE_MODE_DLR = "dlr";
    public static final String LINE_MODE_OVERGROUND = "overground";
//https://api.tfl.gov.uk/Journey/JourneyResults/1000248/to/1000068?nationalSearch=False&timeIs=Departing&journeyPreference=LeastTime&app_id=69e7863b&app_key=6e4d8b6e246808c7de67ec5f950c8c34

    /**
     * For Journey Planner
     */
    public static final String JOURNEY_VAR_PREFERENCE = "journeyPreference";
    public static final String JOURNEY_VAR_TIMEIS = "timeis";
    public static final String JOURNEY_VAR_NSearch = "nationalSearch";
    public static final String JOURNEY_NATIONAL_SEARCH_DEFAULT = "False";

}