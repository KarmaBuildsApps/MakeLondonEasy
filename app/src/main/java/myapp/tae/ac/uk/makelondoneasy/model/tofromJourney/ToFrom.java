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

public class ToFrom implements Parcelable
{

    @SerializedName("$type")
    @Expose
    private String $type;
    @SerializedName("journeys")
    @Expose
    private List<Journey> journeys = new ArrayList<Journey>();
    @SerializedName("lines")
    @Expose
    private List<Line> lines = new ArrayList<Line>();
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
            in.readList(instance.journeys, (Journey.class.getClassLoader()));
            in.readList(instance.lines, (Line.class.getClassLoader()));
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
     *     The journeys
     */
    public List<Journey> getJourneys() {
        return journeys;
    }

    /**
     * 
     * @param journeys
     *     The journeys
     */
    public void setJourneys(List<Journey> journeys) {
        this.journeys = journeys;
    }

    /**
     * 
     * @return
     *     The lines
     */
    public List<Line> getLines() {
        return lines;
    }

    /**
     * 
     * @param lines
     *     The lines
     */
    public void setLines(List<Line> lines) {
        this.lines = lines;
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
        return new HashCodeBuilder().append($type).append(journeys).append(lines).append(recommendedMaxAgeMinutes).append(searchCriteria).append(journeyVector).toHashCode();
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
        return new EqualsBuilder().append($type, rhs.$type).append(journeys, rhs.journeys).append(lines, rhs.lines).append(recommendedMaxAgeMinutes, rhs.recommendedMaxAgeMinutes).append(searchCriteria, rhs.searchCriteria).append(journeyVector, rhs.journeyVector).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue($type);
        dest.writeList(journeys);
        dest.writeList(lines);
        dest.writeValue(recommendedMaxAgeMinutes);
        dest.writeValue(searchCriteria);
        dest.writeValue(journeyVector);
    }

    public int describeContents() {
        return  0;
    }

}
