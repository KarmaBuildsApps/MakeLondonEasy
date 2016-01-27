package myapp.tae.ac.uk.makelondoneasy.ui.extra;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Karma on 25/01/16.
 */
public class QueryOptions implements Parcelable {
    Map<String, String> queryOptions;

    public QueryOptions(HashMap queryOptions) {
        this.queryOptions = queryOptions;
    }

    public Map<String, String> getQueryOptions() {
        return queryOptions;
    }

    protected QueryOptions(Parcel in) {
        this.queryOptions = in.readHashMap(ClassLoader.getSystemClassLoader());
    }

    public static final Creator<QueryOptions> CREATOR = new Creator<QueryOptions>() {
        @Override
        public QueryOptions createFromParcel(Parcel in) {
            return new QueryOptions(in);
        }

        @Override
        public QueryOptions[] newArray(int size) {
            return new QueryOptions[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeMap(queryOptions);
    }
}
