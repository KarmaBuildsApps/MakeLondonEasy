
package myapp.tae.ac.uk.makelondoneasy.model.searchP;

;

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
public class Match implements Parcelable {

    @SerializedName("$type")
    @Expose
    private String $type;
    @SerializedName("stationId")
    @Expose
    private String stationId;
    @SerializedName("icsId")
    @Expose
    private String icsId;
    @SerializedName("topMostParentId")
    @Expose
    private String topMostParentId;
    @SerializedName("modes")
    @Expose
    private List<String> modes = new ArrayList<String>();
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("lon")
    @Expose
    private Double lon;
    @SerializedName("stopLetter")
    @Expose
    private String stopLetter;
    public final static Parcelable.Creator<Match> CREATOR = new Creator<Match>() {


        public Match createFromParcel(Parcel in) {
            Match instance = new Match();
            instance.$type = ((String) in.readValue((String.class.getClassLoader())));
            instance.stationId = ((String) in.readValue((String.class.getClassLoader())));
            instance.icsId = ((String) in.readValue((String.class.getClassLoader())));
            instance.topMostParentId = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.modes, (java.lang.String.class.getClassLoader()));
            instance.status = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.lat = ((Double) in.readValue((Double.class.getClassLoader())));
            instance.lon = ((Double) in.readValue((Double.class.getClassLoader())));
            instance.stopLetter = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Match[] newArray(int size) {
            return (new Match[size]);
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
     * @return The stationId
     */
    public String getStationId() {
        return stationId;
    }

    /**
     * @param stationId The stationId
     */
    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    /**
     * @return The icsId
     */
    public String getIcsId() {
        return icsId;
    }

    /**
     * @param icsId The icsId
     */
    public void setIcsId(String icsId) {
        this.icsId = icsId;
    }

    /**
     * @return The topMostParentId
     */
    public String getTopMostParentId() {
        return topMostParentId;
    }

    /**
     * @param topMostParentId The topMostParentId
     */
    public void setTopMostParentId(String topMostParentId) {
        this.topMostParentId = topMostParentId;
    }

    /**
     * @return The modes
     */
    public List<String> getModes() {
        return modes;
    }

    /**
     * @param modes The modes
     */
    public void setModes(List<String> modes) {
        this.modes = modes;
    }

    /**
     * @return The status
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * @param status The status
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The lat
     */
    public Double getLat() {
        return lat;
    }

    /**
     * @param lat The lat
     */
    public void setLat(Double lat) {
        this.lat = lat;
    }

    /**
     * @return The lon
     */
    public Double getLon() {
        return lon;
    }

    /**
     * @param lon The lon
     */
    public void setLon(Double lon) {
        this.lon = lon;
    }

    /**
     * @return The stopLetter
     */
    public String getStopLetter() {
        return stopLetter;
    }

    /**
     * @param stopLetter The stopLetter
     */
    public void setStopLetter(String stopLetter) {
        this.stopLetter = stopLetter;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append($type).append(stationId).append(icsId).append(topMostParentId).append(modes).append(status).append(id).append(name).append(lat).append(lon).append(stopLetter).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Match) == false) {
            return false;
        }
        Match rhs = ((Match) other);
        return new EqualsBuilder().append($type, rhs.$type).append(stationId, rhs.stationId).append(icsId, rhs.icsId).append(topMostParentId, rhs.topMostParentId).append(modes, rhs.modes).append(status, rhs.status).append(id, rhs.id).append(name, rhs.name).append(lat, rhs.lat).append(lon, rhs.lon).append(stopLetter, rhs.stopLetter).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue($type);
        dest.writeValue(stationId);
        dest.writeValue(icsId);
        dest.writeValue(topMostParentId);
        dest.writeList(modes);
        dest.writeValue(status);
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(lat);
        dest.writeValue(lon);
        dest.writeValue(stopLetter);
    }

    public int describeContents() {
        return 0;
    }

}
