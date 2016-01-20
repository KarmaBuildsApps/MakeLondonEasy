package myapp.tae.ac.uk.makelondoneasy.model.tofromJourney;

import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
public class DeparturePoint implements Parcelable
{

    @SerializedName("$type")
    @Expose
    private String $type;
    @SerializedName("naptanId")
    @Expose
    private String naptanId;
    @SerializedName("platformName")
    @Expose
    private String platformName;
    @SerializedName("icsCode")
    @Expose
    private String icsCode;
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
    public final static Parcelable.Creator<DeparturePoint> CREATOR = new Creator<DeparturePoint>() {


        public DeparturePoint createFromParcel(Parcel in) {
            DeparturePoint instance = new DeparturePoint();
            instance.$type = ((String) in.readValue((String.class.getClassLoader())));
            instance.naptanId = ((String) in.readValue((String.class.getClassLoader())));
            instance.platformName = ((String) in.readValue((String.class.getClassLoader())));
            instance.icsCode = ((String) in.readValue((String.class.getClassLoader())));
            instance.commonName = ((String) in.readValue((String.class.getClassLoader())));
            instance.placeType = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.additionalProperties, (java.lang.Object.class.getClassLoader()));
            instance.lat = ((Double) in.readValue((Double.class.getClassLoader())));
            instance.lon = ((Double) in.readValue((Double.class.getClassLoader())));
            return instance;
        }

        public DeparturePoint[] newArray(int size) {
            return (new DeparturePoint[size]);
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
     *     The naptanId
     */
    public String getNaptanId() {
        return naptanId;
    }

    /**
     * 
     * @param naptanId
     *     The naptanId
     */
    public void setNaptanId(String naptanId) {
        this.naptanId = naptanId;
    }

    /**
     * 
     * @return
     *     The platformName
     */
    public String getPlatformName() {
        return platformName;
    }

    /**
     * 
     * @param platformName
     *     The platformName
     */
    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    /**
     * 
     * @return
     *     The icsCode
     */
    public String getIcsCode() {
        return icsCode;
    }

    /**
     * 
     * @param icsCode
     *     The icsCode
     */
    public void setIcsCode(String icsCode) {
        this.icsCode = icsCode;
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
        return new HashCodeBuilder().append($type).append(naptanId).append(platformName).append(icsCode).append(commonName).append(placeType).append(additionalProperties).append(lat).append(lon).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DeparturePoint) == false) {
            return false;
        }
        DeparturePoint rhs = ((DeparturePoint) other);
        return new EqualsBuilder().append($type, rhs.$type).append(naptanId, rhs.naptanId).append(platformName, rhs.platformName).append(icsCode, rhs.icsCode).append(commonName, rhs.commonName).append(placeType, rhs.placeType).append(additionalProperties, rhs.additionalProperties).append(lat, rhs.lat).append(lon, rhs.lon).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue($type);
        dest.writeValue(naptanId);
        dest.writeValue(platformName);
        dest.writeValue(icsCode);
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
