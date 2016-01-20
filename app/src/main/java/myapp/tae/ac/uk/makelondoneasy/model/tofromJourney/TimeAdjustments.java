package myapp.tae.ac.uk.makelondoneasy.model.tofromJourney;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class TimeAdjustments implements Parcelable {

    @SerializedName("$type")
    @Expose
    private String $type;
    @SerializedName("earliest")
    @Expose
    private Earliest earliest;
    @SerializedName("earlier")
    @Expose
    private Earlier earlier;
    @SerializedName("later")
    @Expose
    private Later later;
    @SerializedName("latest")
    @Expose
    private Latest latest;
    public final static Parcelable.Creator<TimeAdjustments> CREATOR = new Creator<TimeAdjustments>() {


        public TimeAdjustments createFromParcel(Parcel in) {
            TimeAdjustments instance = new TimeAdjustments();
            instance.$type = ((String) in.readValue((String.class.getClassLoader())));
            instance.earliest = ((Earliest) in.readValue((Earliest.class.getClassLoader())));
            instance.earlier = ((Earlier) in.readValue((Earlier.class.getClassLoader())));
            instance.later = ((Later) in.readValue((Later.class.getClassLoader())));
            instance.latest = ((Latest) in.readValue((Latest.class.getClassLoader())));
            return instance;
        }

        public TimeAdjustments[] newArray(int size) {
            return (new TimeAdjustments[size]);
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
     * @return The earliest
     */
    public Earliest getEarliest() {
        return earliest;
    }

    /**
     * @param earliest The earliest
     */
    public void setEarliest(Earliest earliest) {
        this.earliest = earliest;
    }

    /**
     * @return The earlier
     */
    public Earlier getEarlier() {
        return earlier;
    }

    /**
     * @param earlier The earlier
     */
    public void setEarlier(Earlier earlier) {
        this.earlier = earlier;
    }

    /**
     * @return The later
     */
    public Later getLater() {
        return later;
    }

    /**
     * @param later The later
     */
    public void setLater(Later later) {
        this.later = later;
    }

    /**
     * @return The latest
     */
    public Latest getLatest() {
        return latest;
    }

    /**
     * @param latest The latest
     */
    public void setLatest(Latest latest) {
        this.latest = latest;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append($type).append(earliest).append(earlier).append(later).append(latest).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TimeAdjustments) == false) {
            return false;
        }
        TimeAdjustments rhs = ((TimeAdjustments) other);
        return new EqualsBuilder().append($type, rhs.$type).append(earliest, rhs.earliest).append(earlier, rhs.earlier).append(later, rhs.later).append(latest, rhs.latest).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue($type);
        dest.writeValue(earliest);
        dest.writeValue(earlier);
        dest.writeValue(later);
        dest.writeValue(latest);
    }

    public int describeContents() {
        return 0;
    }

}
