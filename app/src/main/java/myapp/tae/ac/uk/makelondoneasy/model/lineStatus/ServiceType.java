
package myapp.tae.ac.uk.makelondoneasy.model.lineStatus;

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
public class ServiceType implements Parcelable {

    @SerializedName("$type")
    @Expose
    private String $type;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("uri")
    @Expose
    private String uri;
    public final static Parcelable.Creator<ServiceType> CREATOR = new Creator<ServiceType>() {


        public ServiceType createFromParcel(Parcel in) {
            ServiceType instance = new ServiceType();
            instance.$type = ((String) in.readValue((String.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.uri = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public ServiceType[] newArray(int size) {
            return (new ServiceType[size]);
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
     * @return The uri
     */
    public String getUri() {
        return uri;
    }

    /**
     * @param uri The uri
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
        return new HashCodeBuilder().append($type).append(name).append(uri).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ServiceType) == false) {
            return false;
        }
        ServiceType rhs = ((ServiceType) other);
        return new EqualsBuilder().append($type, rhs.$type).append(name, rhs.name).append(uri, rhs.uri).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue($type);
        dest.writeValue(name);
        dest.writeValue(uri);
    }

    public int describeContents() {
        return 0;
    }

}
