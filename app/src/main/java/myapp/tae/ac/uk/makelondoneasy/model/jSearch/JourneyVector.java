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
public class JourneyVector implements Parcelable
{

    @SerializedName("$type")
    @Expose
    private String $type;
    @SerializedName("from")
    @Expose
    private String from;
    @SerializedName("to")
    @Expose
    private String to;
    @SerializedName("via")
    @Expose
    private String via;
    @SerializedName("uri")
    @Expose
    private String uri;
    public final static Parcelable.Creator<JourneyVector> CREATOR = new Creator<JourneyVector>() {


        public JourneyVector createFromParcel(Parcel in) {
            JourneyVector instance = new JourneyVector();
            instance.$type = ((String) in.readValue((String.class.getClassLoader())));
            instance.from = ((String) in.readValue((String.class.getClassLoader())));
            instance.to = ((String) in.readValue((String.class.getClassLoader())));
            instance.via = ((String) in.readValue((String.class.getClassLoader())));
            instance.uri = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public JourneyVector[] newArray(int size) {
            return (new JourneyVector[size]);
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
     *     The from
     */
    public String getFrom() {
        return from;
    }

    /**
     * 
     * @param from
     *     The from
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * 
     * @return
     *     The to
     */
    public String getTo() {
        return to;
    }

    /**
     * 
     * @param to
     *     The to
     */
    public void setTo(String to) {
        this.to = to;
    }

    /**
     * 
     * @return
     *     The via
     */
    public String getVia() {
        return via;
    }

    /**
     * 
     * @param via
     *     The via
     */
    public void setVia(String via) {
        this.via = via;
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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append($type).append(from).append(to).append(via).append(uri).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof JourneyVector) == false) {
            return false;
        }
        JourneyVector rhs = ((JourneyVector) other);
        return new EqualsBuilder().append($type, rhs.$type).append(from, rhs.from).append(to, rhs.to).append(via, rhs.via).append(uri, rhs.uri).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue($type);
        dest.writeValue(from);
        dest.writeValue(to);
        dest.writeValue(via);
        dest.writeValue(uri);
    }

    public int describeContents() {
        return  0;
    }

}
