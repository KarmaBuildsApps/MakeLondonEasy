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

public class Path implements Parcelable
{

    @SerializedName("$type")
    @Expose
    private String $type;
    @SerializedName("lineString")
    @Expose
    private String lineString;
    @SerializedName("stopPoints")
    @Expose
    private List<StopPoint> stopPoints = new ArrayList<StopPoint>();
    public final static Parcelable.Creator<Path> CREATOR = new Creator<Path>() {


        public Path createFromParcel(Parcel in) {
            Path instance = new Path();
            instance.$type = ((String) in.readValue((String.class.getClassLoader())));
            instance.lineString = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.stopPoints, (StopPoint.class.getClassLoader()));
            return instance;
        }

        public Path[] newArray(int size) {
            return (new Path[size]);
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
     *     The lineString
     */
    public String getLineString() {
        return lineString;
    }

    /**
     * 
     * @param lineString
     *     The lineString
     */
    public void setLineString(String lineString) {
        this.lineString = lineString;
    }

    /**
     * 
     * @return
     *     The stopPoints
     */
    public List<StopPoint> getStopPoints() {
        return stopPoints;
    }

    /**
     * 
     * @param stopPoints
     *     The stopPoints
     */
    public void setStopPoints(List<StopPoint> stopPoints) {
        this.stopPoints = stopPoints;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append($type).append(lineString).append(stopPoints).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Path) == false) {
            return false;
        }
        Path rhs = ((Path) other);
        return new EqualsBuilder().append($type, rhs.$type).append(lineString, rhs.lineString).append(stopPoints, rhs.stopPoints).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue($type);
        dest.writeValue(lineString);
        dest.writeList(stopPoints);
    }

    public int describeContents() {
        return  0;
    }

}
