package myapp.tae.ac.uk.makelondoneasy.model.tofromJourney;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
public class Later implements Parcelable
{

    @SerializedName("$type")
    @Expose
    private String $type;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("timeIs")
    @Expose
    private String timeIs;
    @SerializedName("uri")
    @Expose
    private String uri;
    public final static Parcelable.Creator<Later> CREATOR = new Creator<Later>() {


        public Later createFromParcel(Parcel in) {
            Later instance = new Later();
            instance.$type = ((String) in.readValue((String.class.getClassLoader())));
            instance.date = ((String) in.readValue((String.class.getClassLoader())));
            instance.time = ((String) in.readValue((String.class.getClassLoader())));
            instance.timeIs = ((String) in.readValue((String.class.getClassLoader())));
            instance.uri = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Later[] newArray(int size) {
            return (new Later[size]);
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
     *     The date
     */
    public String getDate() {
        return date;
    }

    /**
     * 
     * @param date
     *     The date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * 
     * @return
     *     The time
     */
    public String getTime() {
        return time;
    }

    /**
     * 
     * @param time
     *     The time
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * 
     * @return
     *     The timeIs
     */
    public String getTimeIs() {
        return timeIs;
    }

    /**
     * 
     * @param timeIs
     *     The timeIs
     */
    public void setTimeIs(String timeIs) {
        this.timeIs = timeIs;
    }

    /**
     * 
     * @return
     *     The uri
     */
    public String getUri() {
        return uri;
    }

    /**
     * 
     * @param uri
     *     The uri
     */
    public void setUri(String uri) {
        this.uri = uri;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append($type).append(date).append(time).append(timeIs).append(uri).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Later) == false) {
            return false;
        }
        Later rhs = ((Later) other);
        return new EqualsBuilder().append($type, rhs.$type).append(date, rhs.date).append(time, rhs.time).append(timeIs, rhs.timeIs).append(uri, rhs.uri).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue($type);
        dest.writeValue(date);
        dest.writeValue(time);
        dest.writeValue(timeIs);
        dest.writeValue(uri);
    }

    public int describeContents() {
        return  0;
    }

}
