package myapp.tae.ac.uk.makelondoneasy.constants;

/**
 * Created by Karma on 20/01/16.
 * This enum is for Journey FROM to TO query and the values in this
 * enum are options for optional query parameter "journeyPreference"
 */
public enum JourneyPref {
    //"leastinterchange" | "leasttime" | "leastwalking"
    LINTERCHANGE("Leastinterchange"), LTIME("Leasttime"), LWALKING("Leastwalking");

    String value = "";

    JourneyPref(String value) {
        this.value = value;
    }
    public String getValue(){
        return value;
    }
}
