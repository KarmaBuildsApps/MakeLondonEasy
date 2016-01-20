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
public class DisambiguationOption implements Parcelable
{

    @SerializedName("$type")
    @Expose
    private String $type;
    @SerializedName("parameterValue")
    @Expose
    private String parameterValue;
    @SerializedName("uri")
    @Expose
    private String uri;
    @SerializedName("place")
    @Expose
    private Place place;
    @SerializedName("matchQuality")
    @Expose
    private Integer matchQuality;
    public final static Parcelable.Creator<DisambiguationOption> CREATOR = new Creator<DisambiguationOption>() {


        public DisambiguationOption createFromParcel(Parcel in) {
            DisambiguationOption instance = new DisambiguationOption();
            instance.$type = ((String) in.readValue((String.class.getClassLoader())));
            instance.parameterValue = ((String) in.readValue((String.class.getClassLoader())));
            instance.uri = ((String) in.readValue((String.class.getClassLoader())));
            instance.place = ((Place) in.readValue((Place.class.getClassLoader())));
            instance.matchQuality = ((Integer) in.readValue((Integer.class.getClassLoader())));
            return instance;
        }

        public DisambiguationOption[] newArray(int size) {
            return (new DisambiguationOption[size]);
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
     *     The parameterValue
     */
    public String getParameterValue() {
        return parameterValue;
    }

    /**
     * 
     * @param parameterValue
     *     The parameterValue
     */
    public void setParameterValue(String parameterValue) {
        this.parameterValue = parameterValue;
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

    /**
     * 
     * @return
     *     The place
     */
    public Place getPlace() {
        return place;
    }

    /**
     * 
     * @param place
     *     The place
     */
    public void setPlace(Place place) {
        this.place = place;
    }

    /**
     * 
     * @return
     *     The matchQuality
     */
    public Integer getMatchQuality() {
        return matchQuality;
    }

    /**
     * 
     * @param matchQuality
     *     The matchQuality
     */
    public void setMatchQuality(Integer matchQuality) {
        this.matchQuality = matchQuality;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append($type).append(parameterValue).append(uri).append(place).append(matchQuality).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DisambiguationOption) == false) {
            return false;
        }
        DisambiguationOption rhs = ((DisambiguationOption) other);
        return new EqualsBuilder().append($type, rhs.$type).append(parameterValue, rhs.parameterValue).append(uri, rhs.uri).append(place, rhs.place).append(matchQuality, rhs.matchQuality).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue($type);
        dest.writeValue(parameterValue);
        dest.writeValue(uri);
        dest.writeValue(place);
        dest.writeValue(matchQuality);
    }

    public int describeContents() {
        return  0;
    }

}
