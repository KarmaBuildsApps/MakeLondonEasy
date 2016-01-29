package myapp.tae.ac.uk.makelondoneasy.data;

import cz.msebera.android.httpclient.extras.PRNGFixes;

/**
 * Journey class stores a journey details
 * Created by Karma on 22/01/16.
 */
public class DJourney {
    private JPlace fromPlace;
    private JPlace toPlace;
    private int id;
    private int nationSearch;
    private String mode;
    private String journeyPref;
    private String timeIs;
    private String date;

    public DJourney(JPlace from, JPlace to) {
        this.toPlace = to;
        this.fromPlace = from;
        mode = journeyPref = timeIs = "";//default values
        id = -1;
        nationSearch = 0;
        date = "";
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setFromPlace(JPlace fromPlace) {
        this.fromPlace = fromPlace;
    }

    public void setToPlace(JPlace toPlace) {
        this.toPlace = toPlace;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNationSearch(int nationSearch) {
        this.nationSearch = nationSearch;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public void setJourneyPref(String journeyPref) {
        this.journeyPref = journeyPref;
    }

    public void setTimeIs(String timeIs) {
        this.timeIs = timeIs;
    }

    public JPlace getFromPlace() {
        return fromPlace;
    }

    public JPlace getToPlace() {
        return toPlace;
    }


    public int getId() {
        return id;
    }

    public int isNationSearch() {
        return nationSearch;
    }

    public String getMode() {
        return mode;
    }

    public String getJourneyPref() {
        return journeyPref;
    }

    public String getTimeIs() {
        return timeIs;
    }
}
