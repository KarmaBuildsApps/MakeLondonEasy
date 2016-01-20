package myapp.tae.ac.uk.makelondoneasy.constants;

/**
 * Created by Karma on 20/01/16.
 * This enum provides value for Journey query parameter nationalSearch.
 * The true value for the parameter makes TFL API to run query about journey for whole country
 * rather than just for London.
 */
public enum JNationS {
    FALSE("False"), TRUE("True");

    String value = "";

    JNationS(String value) {
        this.value = value;
    }
}
