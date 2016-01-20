
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

//@Generated("org.jsonschema2pojo")
public class TFLLineStatus implements Parcelable {

    @SerializedName("$type")
    @Expose
    private String $type;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("modeName")
    @Expose
    private String modeName;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("modified")
    @Expose
    private String modified;
    @SerializedName("lineStatuses")
    @Expose
    private List<LineStatus> lineStatuses = new ArrayList<LineStatus>();
    @SerializedName("routeSections")
    @Expose
    private List<Object> routeSections = new ArrayList<Object>();
    @SerializedName("serviceTypes")
    @Expose
    private List<ServiceType> serviceTypes = new ArrayList<ServiceType>();
    public final static Parcelable.Creator<TFLLineStatus> CREATOR = new Creator<TFLLineStatus>() {


        public TFLLineStatus createFromParcel(Parcel in) {
            TFLLineStatus instance = new TFLLineStatus();
            instance.$type = ((String) in.readValue((String.class.getClassLoader())));
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.modeName = ((String) in.readValue((String.class.getClassLoader())));
            instance.created = ((String) in.readValue((String.class.getClassLoader())));
            instance.modified = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.lineStatuses, (myapp.tae.ac.uk.makelondoneasy.model.lineStatus.LineStatus.class.getClassLoader()));
            in.readList(instance.routeSections, (java.lang.Object.class.getClassLoader()));
            in.readList(instance.serviceTypes, (myapp.tae.ac.uk.makelondoneasy.model.lineStatus.ServiceType.class.getClassLoader()));
            return instance;
        }

        public TFLLineStatus[] newArray(int size) {
            return (new TFLLineStatus[size]);
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
    public String getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(String id) {
        this.id = id;
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
     * @return The modeName
     */
    public String getModeName() {
        return modeName;
    }

    /**
     * @param modeName The modeName
     */
    public void setModeName(String modeName) {
        this.modeName = modeName;
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
     * @return The modified
     */
    public String getModified() {
        return modified;
    }

    /**
     * @param modified The modified
     */
    public void setModified(String modified) {
        this.modified = modified;
    }

    /**
     * @return The lineStatuses
     */
    public List<LineStatus> getLineStatuses() {
        return lineStatuses;
    }

    /**
     * @param lineStatuses The lineStatuses
     */
    public void setLineStatuses(List<LineStatus> lineStatuses) {
        this.lineStatuses = lineStatuses;
    }

    /**
     * @return The routeSections
     */
    public List<Object> getRouteSections() {
        return routeSections;
    }

    /**
     * @param routeSections The routeSections
     */
    public void setRouteSections(List<Object> routeSections) {
        this.routeSections = routeSections;
    }

    /**
     * @return The serviceTypes
     */
    public List<ServiceType> getServiceTypes() {
        return serviceTypes;
    }

    /**
     * @param serviceTypes The serviceTypes
     */
    public void setServiceTypes(List<ServiceType> serviceTypes) {
        this.serviceTypes = serviceTypes;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append($type).append(id).append(name).append(modeName).append(created).append(modified).append(lineStatuses).append(routeSections).append(serviceTypes).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TFLLineStatus) == false) {
            return false;
        }
        TFLLineStatus rhs = ((TFLLineStatus) other);
        return new EqualsBuilder().append($type, rhs.$type).append(id, rhs.id).append(name, rhs.name).append(modeName, rhs.modeName).append(created, rhs.created).append(modified, rhs.modified).append(lineStatuses, rhs.lineStatuses).append(routeSections, rhs.routeSections).append(serviceTypes, rhs.serviceTypes).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue($type);
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(modeName);
        dest.writeValue(created);
        dest.writeValue(modified);
        dest.writeList(lineStatuses);
        dest.writeList(routeSections);
        dest.writeList(serviceTypes);
    }

    public int describeContents() {
        return 0;
    }

}
