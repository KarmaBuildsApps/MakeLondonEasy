package myapp.tae.ac.uk.makelondoneasy.adapters;

import myapp.tae.ac.uk.makelondoneasy.api.TFLInterface;
import myapp.tae.ac.uk.makelondoneasy.constants.Constants;
import retrofit.RestAdapter;

/**
 * Created by Karma on 20/01/16.
 */
public class RestroInterface {
    private RestAdapter restAdapter;

    private RestroInterface() {
        this.restAdapter = new RestAdapter.Builder().setEndpoint(Constants.BASE_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL).build();
    }

//    public static TFLInterface getTFLInterface(){
//        restAdapter.create(TFLInterface.class);
//    }

}
