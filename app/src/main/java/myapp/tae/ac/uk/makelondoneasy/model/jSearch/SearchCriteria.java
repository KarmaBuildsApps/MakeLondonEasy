package myapp.tae.ac.uk.makelondoneasy.model.jSearch;

//import javax.annotation.Generated;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
//import org.apache.commons.lang.builder.EqualsBuilder;
//import org.apache.commons.lang.builder.HashCodeBuilder;
//import org.apache.commons.lang.builder.ToStringBuilder;

//@Generated("org.jsonschema2pojo")
public class SearchCriteria implements Parcelable
{

    @SerializedName("$type")
    @Expose
    private String $type;
    @SerializedName("dateTime")
    @Expose
    private String dateTime;
    @SerializedName("dateTimeType")
    @Expose
    private String dateTimeType;
    public final static Parcelable.Creator<SearchCriteria> CREATOR = new Creator<SearchCriteria>() {


        public SearchCriteria createFromParcel(Parcel in) {
            SearchCriteria instance = new SearchCriteria();
            instance.$type = ((String) in.readValue((String.class.getClassLoader())));
            instance.dateTime = ((String) in.readValue((String.class.getClassLoader())));
            instance.dateTimeType = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public SearchCriteria[] newArray(int size) {
            return (new SearchCriteria[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The $type
     */
    public String get$type() {
        return $type;
    }

    /**
     * 
     * @param $type
     *     The $type
     */
    public void set$type(String $type) {
        this.$type = $type;
    }

    /**
     * 
     * @return
     *     The dateTime
     */
    public String getDateTime() {
        return dateTime;
    }

    /**
     * 
     * @param dateTime
     *     The dateTime
     */
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * 
     * @return
     *     The dateTimeType
     */
    public String getDateTimeType() {
        return dateTimeType;
    }

    /**
     * 
     * @param dateTimeType
     *     The dateTimeType
     */
    public void setDateTimeType(String dateTimeType) {
        this.dateTimeType = dateTimeType;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append($type).append(dateTime).append(dateTimeType).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SearchCriteria) == false) {
            return false;
        }
        SearchCriteria rhs = ((SearchCriteria) other);
        return new EqualsBuilder().append($type, rhs.$type).append(dateTime, rhs.dateTime).append(dateTimeType, rhs.dateTimeType).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue($type);
        dest.writeValue(dateTime);
        dest.writeValue(dateTimeType);
    }

    public int describeContents() {
        return  0;
    }

}
