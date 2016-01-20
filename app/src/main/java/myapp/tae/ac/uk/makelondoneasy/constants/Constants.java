package myapp.tae.ac.uk.makelondoneasy.constants;

/**
 * Created by Karma on 17/01/16.
 */
public class Constants {
    public static final String BASE_URL = "https://api.tfl.gov.uk";
    public static final String JOURNEY_TO_FROM_QUERY = "/journey/journeyresults/{to_from_query}";
    public static final String SEARCH_STOPPOINT_REQUEST_QUERY = "https://api.tfl.gov.uk/Stoppoint/Search/{query-terms}";
    public static final String SEARCH_MODE_TUBE = "?modes=tube";
    public static final String JOURNEY_LINE_STATUS_QUERY = "https://api.tfl.gov.uk/Line/Mode/{modes}/Status";
    public static final String AUTO_TEXT_SUGGEST = "/Stoppoint/Search/";
    public static final String LINE_DISRUPTION_STATUS = "/Line/Mode/tube,dlr,overground,tflrail/Status";
    public static final String STOP_TYPE_TUBE = "NaptanMetroStation";
    public static final String STOP_TYPE_BUS = "NaptanPublicBusCoachTram";
    public static final String LINE_MODE_TUBE = "tube";
    public static final String LINE_MODE_RAIL = "tflrai";
    public static final String LINE_MODE_DLR = "dlr";
    public static final String LINE_MODE_OVERGROUND = "overground";


    /**
     * For Journey Planner
     */

    public static final String JOURNEY_NATIONAL_SEARCH_DEFAULT = "False";
    public static final String JOURNEY_TIMEIS_DEFAULT = "Departing";//other option arriving
    public static final String JOURNEY_PREFERENCE_DEFAULT = "LeastTime";//other options: "leastinterchange" | "leasttime" | "leastwalking"
}
