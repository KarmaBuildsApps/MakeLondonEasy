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
public class FromLocationDisambiguation implements Parcelable
{

    @SerializedName("$type")
    @Expose
    private String $type;
    @SerializedName("disambiguationOptions")
    @Expose
    private List<DisambiguationOption_> disambiguationOptions = new ArrayList<DisambiguationOption_>();
    @SerializedName("matchStatus")
    @Expose
    private String matchStatus;
    public final static Parcelable.Creator<FromLocationDisambiguation> CREATOR = new Creator<FromLocationDisambiguation>() {


        public FromLocationDisambiguation createFromParcel(Parcel in) {
            FromLocationDisambiguation instance = new FromLocationDisambiguation();
            instance.$type = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.disambiguationOptions, (DisambiguationOption_.class.getClassLoader()));
            instance.matchStatus = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public FromLocationDisambiguation[] newArray(int size) {
            return (new FromLocationDisambiguation[size]);
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
     *     The disambiguationOptions
     */
    public List<DisambiguationOption_> getDisambiguationOptions() {
        return disambiguationOptions;
    }

    /**
     * 
     * @param disambiguationOptions
     *     The disambiguationOptions
     */
    public void setDisambiguationOptions(List<DisambiguationOption_> disambiguationOptions) {
        this.disambiguationOptions = disambiguationOptions;
    }

    /**
     * 
     * @return
     *     The matchStatus
     */
    public String getMatchStatus() {
        return matchStatus;
    }

    /**
     * 
     * @param matchStatus
     *     The matchStatus
     */
    public void setMatchStatus(String matchStatus) {
        this.matchStatus = matchStatus;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append($type).append(disambiguationOptions).append(matchStatus).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FromLocationDisambiguation) == false) {
            return false;
        }
        FromLocationDisambiguation rhs = ((FromLocationDisambiguation) other);
        return new EqualsBuilder().append($type, rhs.$type).append(disambiguationOptions, rhs.disambiguationOptions).append(matchStatus, rhs.matchStatus).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue($type);
        dest.writeList(disambiguationOptions);
        dest.writeValue(matchStatus);
    }

    public int describeContents() {
        return  0;
    }

}
