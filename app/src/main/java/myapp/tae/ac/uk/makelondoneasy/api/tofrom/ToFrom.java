package myapp.tae.ac.uk.makelondoneasy.api.tofrom;

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
public class ToFrom implements Parcelable
{

    @SerializedName("$type")
    @Expose
    private String $type;
    @SerializedName("toLocationDisambiguation")
    @Expose
    private ToLocationDisambiguation toLocationDisambiguation;
    @SerializedName("fromLocationDisambiguation")
    @Expose
    private FromLocationDisambiguation fromLocationDisambiguation;
    @SerializedName("viaLocationDisambiguation")
    @Expose
    private ViaLocationDisambiguation viaLocationDisambiguation;
    @SerializedName("recommendedMaxAgeMinutes")
    @Expose
    private Integer recommendedMaxAgeMinutes;
    @SerializedName("searchCriteria")
    @Expose
    private SearchCriteria searchCriteria;
    @SerializedName("journeyVector")
    @Expose
    private JourneyVector journeyVector;
    public final static Parcelable.Creator<ToFrom> CREATOR = new Creator<ToFrom>() {


        public ToFrom createFromParcel(Parcel in) {
            ToFrom instance = new ToFrom();
            instance.$type = ((String) in.readValue((String.class.getClassLoader())));
            instance.toLocationDisambiguation = ((ToLocationDisambiguation) in.readValue((ToLocationDisambiguation.class.getClassLoader())));
            instance.fromLocationDisambiguation = ((FromLocationDisambiguation) in.readValue((FromLocationDisambiguation.class.getClassLoader())));
            instance.viaLocationDisambiguation = ((ViaLocationDisambiguation) in.readValue((ViaLocationDisambiguation.class.getClassLoader())));
            instance.recommendedMaxAgeMinutes = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.searchCriteria = ((SearchCriteria) in.readValue((SearchCriteria.class.getClassLoader())));
            instance.journeyVector = ((JourneyVector) in.readValue((JourneyVector.class.getClassLoader())));
            return instance;
        }

        public ToFrom[] newArray(int size) {
            return (new ToFrom[size]);
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
     *     The toLocationDisambiguation
     */
    public ToLocationDisambiguation getToLocationDisambiguation() {
        return toLocationDisambiguation;
    }

    /**
     * 
     * @param toLocationDisambiguation
     *     The toLocationDisambiguation
     */
    public void setToLocationDisambiguation(ToLocationDisambiguation toLocationDisambiguation) {
        this.toLocationDisambiguation = toLocationDisambiguation;
    }

    /**
     * 
     * @return
     *     The fromLocationDisambiguation
     */
    public FromLocationDisambiguation getFromLocationDisambiguation() {
        return fromLocationDisambiguation;
    }

    /**
     * 
     * @param fromLocationDisambiguation
     *     The fromLocationDisambiguation
     */
    public void setFromLocationDisambiguation(FromLocationDisambiguation fromLocationDisambiguation) {
        this.fromLocationDisambiguation = fromLocationDisambiguation;
    }

    /**
     * 
     * @return
     *     The viaLocationDisambiguation
     */
    public ViaLocationDisambiguation getViaLocationDisambiguation() {
        return viaLocationDisambiguation;
    }

    /**
     * 
     * @param viaLocationDisambiguation
     *     The viaLocationDisambiguation
     */
    public void setViaLocationDisambiguation(ViaLocationDisambiguation viaLocationDisambiguation) {
        this.viaLocationDisambiguation = viaLocationDisambiguation;
    }

    /**
     * 
     * @return
     *     The recommendedMaxAgeMinutes
     */
    public Integer getRecommendedMaxAgeMinutes() {
        return recommendedMaxAgeMinutes;
    }

    /**
     * 
     * @param recommendedMaxAgeMinutes
     *     The recommendedMaxAgeMinutes
     */
    public void setRecommendedMaxAgeMinutes(Integer recommendedMaxAgeMinutes) {
        this.recommendedMaxAgeMinutes = recommendedMaxAgeMinutes;
    }

    /**
     * 
     * @return
     *     The searchCriteria
     */
    public SearchCriteria getSearchCriteria() {
        return searchCriteria;
    }

    /**
     * 
     * @param searchCriteria
     *     The searchCriteria
     */
    public void setSearchCriteria(SearchCriteria searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    /**
     * 
     * @return
     *     The journeyVector
     */
    public JourneyVector getJourneyVector() {
        return journeyVector;
    }

    /**
     * 
     * @param journeyVector
     *     The journeyVector
     */
    public void setJourneyVector(JourneyVector journeyVector) {
        this.journeyVector = journeyVector;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append($type).append(toLocationDisambiguation).append(fromLocationDisambiguation).append(viaLocationDisambiguation).append(recommendedMaxAgeMinutes).append(searchCriteria).append(journeyVector).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ToFrom) == false) {
            return false;
        }
        ToFrom rhs = ((ToFrom) other);
        return new EqualsBuilder().append($type, rhs.$type).append(toLocationDisambiguation, rhs.toLocationDisambiguation).append(fromLocationDisambiguation, rhs.fromLocationDisambiguation).append(viaLocationDisambiguation, rhs.viaLocationDisambiguation).append(recommendedMaxAgeMinutes, rhs.recommendedMaxAgeMinutes).append(searchCriteria, rhs.searchCriteria).append(journeyVector, rhs.journeyVector).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue($type);
        dest.writeValue(toLocationDisambiguation);
        dest.writeValue(fromLocationDisambiguation);
        dest.writeValue(viaLocationDisambiguation);
        dest.writeValue(recommendedMaxAgeMinutes);
        dest.writeValue(searchCriteria);
        dest.writeValue(journeyVector);
    }

    public int describeContents() {
        return  0;
    }

}
