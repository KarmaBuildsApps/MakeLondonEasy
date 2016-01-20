
package myapp.tae.ac.uk.makelondoneasy.model.lineStatus;

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

public class LineStatus implements Parcelable {

    @SerializedName("$type")
    @Expose
    private String $type;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("statusSeverity")
    @Expose
    private Integer statusSeverity;
    @SerializedName("statusSeverityDescription")
    @Expose
    private String statusSeverityDescription;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("validityPeriods")
    @Expose
    private List<Object> validityPeriods = new ArrayList<Object>();
    public final static Parcelable.Creator<LineStatus> CREATOR = new Creator<LineStatus>() {


        public LineStatus createFromParcel(Parcel in) {
            LineStatus instance = new LineStatus();
            instance.$type = ((String) in.readValue((String.class.getClassLoader())));
            instance.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.statusSeverity = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.statusSeverityDescription = ((String) in.readValue((String.class.getClassLoader())));
            instance.created = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.validityPeriods, (java.lang.Object.class.getClassLoader()));
            return instance;
        }

        public LineStatus[] newArray(int size) {
            return (new LineStatus[size]);
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
     * @return The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return The statusSeverity
     */
    public Integer getStatusSeverity() {
        return statusSeverity;
    }

    /**
     * @param statusSeverity The statusSeverity
     */
    public void setStatusSeverity(Integer statusSeverity) {
        this.statusSeverity = statusSeverity;
    }

    /**
     * @return The statusSeverityDescription
     */
    public String getStatusSeverityDescription() {
        return statusSeverityDescription;
    }

    /**
     * @param statusSeverityDescription The statusSeverityDescription
     */
    public void setStatusSeverityDescription(String statusSeverityDescription) {
        this.statusSeverityDescription = statusSeverityDescription;
    }

    /**
     * @return The created
     */
    public String getCreated() {
        return created;
    }

    /**
     * @param created The created
     */
    public void setCreated(String created) {
        this.created = created;
    }

    /**
     * @return The validityPeriods
     */
    public List<Object> getValidityPeriods() {
        return validityPeriods;
    }

    /**
     * @param validityPeriods The validityPeriods
     */
    public void setValidityPeriods(List<Object> validityPeriods) {
        this.validityPeriods = validityPeriods;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append($type).append(id).append(statusSeverity).append(statusSeverityDescription).append(created).append(validityPeriods).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LineStatus) == false) {
            return false;
        }
        LineStatus rhs = ((LineStatus) other);
        return new EqualsBuilder().append($type, rhs.$type).append(id, rhs.id).append(statusSeverity, rhs.statusSeverity).append(statusSeverityDescription, rhs.statusSeverityDescription).append(created, rhs.created).append(validityPeriods, rhs.validityPeriods).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue($type);
        dest.writeValue(id);
        dest.writeValue(statusSeverity);
        dest.writeValue(statusSeverityDescription);
        dest.writeValue(created);
        dest.writeList(validityPeriods);
    }

    public int describeContents() {
        return 0;
    }

}
