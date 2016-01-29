package myapp.tae.ac.uk.makelondoneasy.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Karma on 22/01/16.
 */
public class LocalDatabaseHandler extends SQLiteOpenHelper {
    private Context context;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "makeLondonEasy_db";

    //For Search History Table
    private static final String SEARCH_HISTORY_TABLE = "Immigrants";
    private static final String sID = "ID";
    private static final String sFrom = "From";
    private static final String sTo = "To";
    private static final String sNationSearch = "Nation_Search";
    private static final String sModes = "Mode";
    private static final String sJourneyPref = "Journey_Preference";
    private static final String sTimeIs = "Time_Is";
    private static final String sToPlaceCode = "To_Place_Code";
    private static final String sFromPlaceCode = "From_Place_Code";
    private static final String sDate = "Date";

    public LocalDatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_SEARCH_HISTORY_TABLE = "CREATE TABLE " + "SEARCH_HISTORY_TABLE" + " (" + "sID" + " INTEGER PRIMARY KEY, " +
                "sFrom" + " TEXT NOT NULL, " + " sTo" + " TEXT, " + "sNationSearch" + " INTEGER, " + "sModes" + " TEXT, " +
                "sJourneyPref" + " TEXT, " + "sTimeIs" + " TEXT " + "sToPlaceCode" + " TEXT " +
                "sFromPlaceCode" + " TEXT" + "sDate" + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP)";
        db.execSQL(CREATE_SEARCH_HISTORY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + SEARCH_HISTORY_TABLE);
        onCreate(db);
    }

    public boolean addJourney(DJourney journey) {
        JPlace from = journey.getFromPlace();
        JPlace to = journey.getToPlace();
        try {
            ContentValues cv = new ContentValues();
            cv.put(sTo, to.getName());
            cv.put(sFrom, from.getName());
            cv.put(sToPlaceCode, to.getIcsCode());
            cv.put(sFromPlaceCode, from.getIcsCode());
            cv.put(sNationSearch, journey.isNationSearch());
            cv.put(sModes, journey.getMode());
            cv.put(sJourneyPref, journey.getJourneyPref());
            cv.put(sTimeIs, journey.getTimeIs());
            getWritableDB().insert(SEARCH_HISTORY_TABLE, null, cv);
        } catch (SQLiteException e) {
            Log.d("SQLite Exception", e.getMessage());
            return false;
        } finally {
            getWritableDB().close();
        }
        return true;
    }

    public List<DJourney> getHistory(String date) {
        List<DJourney> journeysOfDate = new ArrayList<>();
        Cursor cursor = getReadableDB().rawQuery("SELECT * from " + SEARCH_HISTORY_TABLE +
                "WHERE " + sDate + " ? ", new String[]{date});
        journeysOfDate = getCursorJItems(cursor);
        return journeysOfDate;
    }

    public boolean removeHistory(int sJourneyId) {
        boolean isRemoved = false;
        Cursor cursor = getWritableDB().rawQuery("SELECT * from " + SEARCH_HISTORY_TABLE +
                "WHERE " + sID + " ? ", new String[]{"" + sJourneyId});
        if (cursor.moveToFirst() == true) {
            isRemoved = true;
            getWritableDB().rawQuery("DELETE from " + SEARCH_HISTORY_TABLE + " WHERE " + sID + " ?", new String[]{"" + sJourneyPref});
        }
        getWritableDB().close();
        return isRemoved;
    }

    public List<DJourney> getAllHistory() {
        List<DJourney> jHistory = new ArrayList<>();
        Cursor cursor = getReadableDB().query(SEARCH_HISTORY_TABLE, null, null, null, null, null, null);
        jHistory = getCursorJItems(cursor);
        return jHistory;
    }

    private List<DJourney> getCursorJItems(Cursor cursor) {
        List<DJourney> journeys = new ArrayList<>();
        JPlace to = new JPlace("", "");
        JPlace from = new JPlace("", "");
        DJourney journey = new DJourney(from, to);
        if (cursor.moveToFirst())
            do {
                to.setName(cursor.getString(cursor.getColumnIndex(sTo)));
                to.setIcsCode(cursor.getString(cursor.getColumnIndex(sToPlaceCode)));
                from.setName(cursor.getString(cursor.getColumnIndex(sFrom)));
                from.setIcsCode(cursor.getString(cursor.getColumnIndex(sFromPlaceCode)));
                journey.setId(cursor.getInt(cursor.getColumnIndex(sID)));
                journey.setNationSearch(cursor.getInt(cursor.getColumnIndex(sNationSearch)));
                journey.setMode(cursor.getString(cursor.getColumnIndex(sModes)));
                journey.setJourneyPref(cursor.getColumnName(cursor.getColumnIndex(sTimeIs)));
                journey.setFromPlace(from);
                journey.setToPlace(to);
                journeys.add(journey);
            } while (cursor.moveToNext());
        return journeys;
    }

    private SQLiteDatabase getReadableDB() {
        return this.getReadableDatabase();
    }

    private SQLiteDatabase getWritableDB() {
        return this.getWritableDatabase();
    }

}
