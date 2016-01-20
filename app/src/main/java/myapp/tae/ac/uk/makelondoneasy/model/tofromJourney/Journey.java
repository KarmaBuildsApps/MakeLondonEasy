package myapp.tae.ac.uk.makelondoneasy.model.tofromJourney;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class Journey implements Parcelable {

    @SerializedName("$type")
    @Expose
    private String $type;
    @SerializedName("startDateTime")
    @Expose
    private String startDateTime;
    @SerializedName("duration")
    @Expose
    private Integer duration;
    @SerializedName("arrivalDateTime")
    @Expose
    private String arrivalDateTime;
    @SerializedName("legs")
    @Expose
    private List<Leg> legs = new ArrayList<Leg>();
    public final static Parcelable.Creator<Journey> CREATOR = new Creator<Journey>() {


        public Journey createFromParcel(Parcel in) {
            Journey instance = new Journey();
            instance.$type = ((String) in.readValue((String.class.getClassLoader())));
            instance.startDateTime = ((String) in.readValue((String.class.getClassLoader())));
            instance.duration = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.arrivalDateTime = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.legs, (Leg.class.getClassLoader()));
            return instance;
        }

        public Journey[] newArray(int size) {
            return (new Journey[size]);
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
     * @return The startDateTime
     */
    public String getStartDateTime() {
        return startDateTime;
    }

    /**
     * @param startDateTime The startDateTime
     */
    public void setStartDateTime(String startDateTime) {
        this.startDateTime = startDateTime;
    }

    /**
     * @return The duration
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * @param duration The duration
     */
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    /**
     * @return The arrivalDateTime
     */
    public String getArrivalDateTime() {
        return arrivalDateTime;
    }

    /**
     * @param arrivalDateTime The arrivalDateTime
     */
    public void setArrivalDateTime(String arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    /**
     * @return The legs
     */
    public List<Leg> getLegs() {
        return legs;
    }

    /**
     * @param legs The legs
     */
    public void setLegs(List<Leg> legs) {
        this.legs = legs;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append($type).append(startDateTime).append(duration).append(arrivalDateTime).append(legs).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Journey) == false) {
            return false;
        }
        Journey rhs = ((Journey) other);
        return new EqualsBuilder().append($type, rhs.$type).append(startDateTime, rhs.startDateTime).append(duration, rhs.duration).append(arrivalDateTime, rhs.arrivalDateTime).append(legs, rhs.legs).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue($type);
        dest.writeValue(startDateTime);
        dest.writeValue(duration);
        dest.writeValue(arrivalDateTime);
        dest.writeList(legs);
    }

    public int describeContents() {
        return 0;
    }

}
