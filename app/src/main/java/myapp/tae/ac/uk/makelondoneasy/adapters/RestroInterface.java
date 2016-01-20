package myapp.tae.ac.uk.makelondoneasy.adapters;

import myapp.tae.ac.uk.makelondoneasy.api.TFLInterface;
import myapp.tae.ac.uk.makelondoneasy.constants.Constants;
import retrofit.RestAdapter;

/**
 * Created by Karma on 20/01/16.
 */
public class RestroInterface {
    private static TFLInterface tflInterface;

    static {
        setUpRestAPI();
    }

    private RestroInterface() {
    }

    public static TFLInterface getTFLInterface() {
        return tflInterface;
    }

    private static void setUpRestAPI() {
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(Constants.BASE_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL).build();
        tflInterface = restAdapter.create(TFLInterface.class);
    }


}
