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

public class RouteOption implements Parcelable
{

    @SerializedName("$type")
    @Expose
    private String $type;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("directions")
    @Expose
    private List<String> directions = new ArrayList<String>();
    @SerializedName("lineIdentifier")
    @Expose
    private LineIdentifier lineIdentifier;
    public final static Parcelable.Creator<RouteOption> CREATOR = new Creator<RouteOption>() {


        public RouteOption createFromParcel(Parcel in) {
            RouteOption instance = new RouteOption();
            instance.$type = ((String) in.readValue((String.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.directions, (java.lang.String.class.getClassLoader()));
            instance.lineIdentifier = ((LineIdentifier) in.readValue((LineIdentifier.class.getClassLoader())));
            return instance;
        }

        public RouteOption[] newArray(int size) {
            return (new RouteOption[size]);
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
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The directions
     */
    public List<String> getDirections() {
        return directions;
    }

    /**
     * 
     * @param directions
     *     The directions
     */
    public void setDirections(List<String> directions) {
        this.directions = directions;
    }

    /**
     * 
     * @return
     *     The lineIdentifier
     */
    public LineIdentifier getLineIdentifier() {
        return lineIdentifier;
    }

    /**
     * 
     * @param lineIdentifier
     *     The lineIdentifier
     */
    public void setLineIdentifier(LineIdentifier lineIdentifier) {
        this.lineIdentifier = lineIdentifier;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append($type).append(name).append(directions).append(lineIdentifier).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RouteOption) == false) {
            return false;
        }
        RouteOption rhs = ((RouteOption) other);
        return new EqualsBuilder().append($type, rhs.$type).append(name, rhs.name).append(directions, rhs.directions).append(lineIdentifier, rhs.lineIdentifier).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue($type);
        dest.writeValue(name);
        dest.writeList(directions);
        dest.writeValue(lineIdentifier);
    }

    public int describeContents() {
        return  0;
    }

}
