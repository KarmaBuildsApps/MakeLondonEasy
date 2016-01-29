package myapp.tae.ac.uk.makelondoneasy.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.EditText;

import java.util.List;

import myapp.tae.ac.uk.makelondoneasy.constants.Constants;
import myapp.tae.ac.uk.makelondoneasy.data.DJourney;
import myapp.tae.ac.uk.makelondoneasy.data.LocalDatabaseHandler;

/**
 * As the name suggests this class give media to communicate with data. Type of data this class deals
 * with are data of database and shared preferences.
 * Created by Karma on 22/01/16.
 */
public class DataManager {
    private LocalDatabaseHandler databaseHandler;
    private SharedPreferences sharedPreferences;

    public DataManager(Context context) {
        databaseHandler = new LocalDatabaseHandler(context);
//        sharedPreferences = context.getSharedPreferences(Constants.SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    public boolean add(DJourney journey) {
        return databaseHandler.addJourney(journey);
    }

    public List<DJourney> getJourneyByDate(String date) {
        return databaseHandler.getHistory(date);
    }

    public List<DJourney> getAllJourneys() {
        return databaseHandler.getAllHistory();
    }

    public boolean rmJourney(int id) {
        return databaseHandler.removeHistory(id);
    }

//    public void saveString(String name, String value) {
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putString(name, value);
//        editor.commit();
//    }
//
//    public String getStringData(String name) {
//        String error = "error";
//        return sharedPreferences.getString(name, error);
//    }

}
