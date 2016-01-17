package myapp.tae.ac.uk.makelondoneasy.api.tofrom;

import java.util.ArrayList;
import java.util.List;
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
public class Place_ implements Parcelable
{

    @SerializedName("$type")
    @Expose
    private String $type;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("commonName")
    @Expose
    private String commonName;
    @SerializedName("placeType")
    @Expose
    private String placeType;
    @SerializedName("additionalProperties")
    @Expose
    private List<Object> additionalProperties = new ArrayList<Object>();
    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("lon")
    @Expose
    private Double lon;
    public final static Parcelable.Creator<Place_> CREATOR = new Creator<Place_>() {


        public Place_ createFromParcel(Parcel in) {
            Place_ instance = new Place_();
            instance.$type = ((String) in.readValue((String.class.getClassLoader())));
            instance.url = ((String) in.readValue((String.class.getClassLoader())));
            instance.commonName = ((String) in.readValue((String.class.getClassLoader())));
            instance.placeType = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.additionalProperties, (java.lang.Object.class.getClassLoader()));
            instance.lat = ((Double) in.readValue((Double.class.getClassLoader())));
            instance.lon = ((Double) in.readValue((Double.class.getClassLoader())));
            return instance;
        }

        public Place_[] newArray(int size) {
            return (new Place_[size]);
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
     *     The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 
     * @return
     *     The commonName
     */
    public String getCommonName() {
        return commonName;
    }

    /**
     * 
     * @param commonName
     *     The commonName
     */
    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    /**
     * 
     * @return
     *     The placeType
     */
    public String getPlaceType() {
        return placeType;
    }

    /**
     * 
     * @param placeType
     *     The placeType
     */
    public void setPlaceType(String placeType) {
        this.placeType = placeType;
    }

    /**
     * 
     * @return
     *     The additionalProperties
     */
    public List<Object> getAdditionalProperties() {
        return additionalProperties;
    }

    /**
     * 
     * @param additionalProperties
     *     The additionalProperties
     */
    public void setAdditionalProperties(List<Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    /**
     * 
     * @return
     *     The lat
     */
    public Double getLat() {
        return lat;
    }

    /**
     * 
     * @param lat
     *     The lat
     */
    public void setLat(Double lat) {
        this.lat = lat;
    }

    /**
     * 
     * @return
     *     The lon
     */
    public Double getLon() {
        return lon;
    }

    /**
     * 
     * @param lon
     *     The lon
     */
    public void setLon(Double lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append($type).append(url).append(commonName).append(placeType).append(additionalProperties).append(lat).append(lon).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Place_) == false) {
            return false;
        }
        Place_ rhs = ((Place_) other);
        return new EqualsBuilder().append($type, rhs.$type).append(url, rhs.url).append(commonName, rhs.commonName).append(placeType, rhs.placeType).append(additionalProperties, rhs.additionalProperties).append(lat, rhs.lat).append(lon, rhs.lon).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue($type);
        dest.writeValue(url);
        dest.writeValue(commonName);
        dest.writeValue(placeType);
        dest.writeList(additionalProperties);
        dest.writeValue(lat);
        dest.writeValue(lon);
    }

    public int describeContents() {
        return  0;
    }

}
