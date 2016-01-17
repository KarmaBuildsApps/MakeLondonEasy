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
public class ViaLocationDisambiguation implements Parcelable
{

    @SerializedName("$type")
    @Expose
    private String $type;
    @SerializedName("matchStatus")
    @Expose
    private String matchStatus;
    public final static Parcelable.Creator<ViaLocationDisambiguation> CREATOR = new Creator<ViaLocationDisambiguation>() {


        public ViaLocationDisambiguation createFromParcel(Parcel in) {
            ViaLocationDisambiguation instance = new ViaLocationDisambiguation();
            instance.$type = ((String) in.readValue((String.class.getClassLoader())));
            instance.matchStatus = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public ViaLocationDisambiguation[] newArray(int size) {
            return (new ViaLocationDisambiguation[size]);
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
        return new HashCodeBuilder().append($type).append(matchStatus).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ViaLocationDisambiguation) == false) {
            return false;
        }
        ViaLocationDisambiguation rhs = ((ViaLocationDisambiguation) other);
        return new EqualsBuilder().append($type, rhs.$type).append(matchStatus, rhs.matchStatus).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue($type);
        dest.writeValue(matchStatus);
    }

    public int describeContents() {
        return  0;
    }

}
