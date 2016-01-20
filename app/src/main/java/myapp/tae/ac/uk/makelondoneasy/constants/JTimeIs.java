package myapp.tae.ac.uk.makelondoneasy.constants;

/**
 * Created by Karma on 20/01/16.
 * The options in the enum are values for the optional Journey query parameter "timeis"
 */
public enum JTimeIs {
    /////Journey/JourneyResults/1000248/to/1000068?nationalSearch=False&timeIs=Departing&journeyPreference=LeastTime&app_id=69e7863b&app_key=6e4d8b6e246808c7de67ec5f950c8c34
    DEPART("departing"), ARRIVE("arriving");
    String value = "";

    JTimeIs(String value) {
        this.value = value;
    }
}
