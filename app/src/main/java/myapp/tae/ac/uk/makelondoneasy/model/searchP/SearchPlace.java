
package myapp.tae.ac.uk.makelondoneasy.model.searchP;

import java.util.ArrayList;
import java.util.List;

//import javax.annotation.Generated;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

//@Generated("org.jsonschema2pojo")
public class SearchPlace implements Parcelable {

    @SerializedName("$type")
    @Expose
    private String $type;
    @SerializedName("query")
    @Expose
    private String query;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("matches")
    @Expose
    private List<Match> matches = new ArrayList<Match>();
    public final static Parcelable.Creator<SearchPlace> CREATOR = new Creator<SearchPlace>() {


        public SearchPlace createFromParcel(Parcel in) {
            SearchPlace instance = new SearchPlace();
            instance.$type = ((String) in.readValue((String.class.getClassLoader())));
            instance.query = ((String) in.readValue((String.class.getClassLoader())));
            instance.total = ((Integer) in.readValue((Integer.class.getClassLoader())));
            in.readList(instance.matches, (myapp.tae.ac.uk.makelondoneasy.model.searchP.
                    Match.class.getClassLoader()));
            return instance;
        }

        public SearchPlace[] newArray(int size) {
            return (new SearchPlace[size]);
        }

    };

    /**
     * @return The $type
     */
    public String get$type() {
        return $type;
    }

    /**
     * @param $type The $type
     */
    public void set$type(String $type) {
        this.$type = $type;
    }

    /**
     * @return The query
     */
    public String getQuery() {
        return query;
    }

    /**
     * @param query The query
     */
    public void setQuery(String query) {
        this.query = query;
    }

    /**
     * @return The total
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * @param total The total
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * @return The matches
     */
    public List<Match> getMatches() {
        return matches;
    }

    /**
     * @param matches The matches
     */
    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append($type).append(query).append(total).append(matches).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SearchPlace) == false) {
            return false;
        }
        SearchPlace rhs = ((SearchPlace) other);
        return new EqualsBuilder().append($type, rhs.$type).append(query, rhs.query).append(total, rhs.total).append(matches, rhs.matches).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue($type);
        dest.writeValue(query);
        dest.writeValue(total);
        dest.writeList(matches);
    }

    public int describeContents() {
        return 0;
    }

}
