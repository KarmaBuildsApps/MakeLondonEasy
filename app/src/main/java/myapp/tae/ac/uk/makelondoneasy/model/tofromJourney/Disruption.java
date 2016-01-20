package myapp.tae.ac.uk.makelondoneasy.model.tofromJourney;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
public class Disruption implements Parcelable
{

    @SerializedName("$type")
    @Expose
    private String $type;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("categoryDescription")
    @Expose
    private String categoryDescription;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("additionalInfo")
    @Expose
    private String additionalInfo;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("lastUpdate")
    @Expose
    private String lastUpdate;
    public final static Parcelable.Creator<Disruption> CREATOR = new Creator<Disruption>() {


        public Disruption createFromParcel(Parcel in) {
            Disruption instance = new Disruption();
            instance.$type = ((String) in.readValue((String.class.getClassLoader())));
            instance.category = ((String) in.readValue((String.class.getClassLoader())));
            instance.type = ((String) in.readValue((String.class.getClassLoader())));
            instance.categoryDescription = ((String) in.readValue((String.class.getClassLoader())));
            instance.description = ((String) in.readValue((String.class.getClassLoader())));
            instance.additionalInfo = ((String) in.readValue((String.class.getClassLoader())));
            instance.created = ((String) in.readValue((String.class.getClassLoader())));
            instance.lastUpdate = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Disruption[] newArray(int size) {
            return (new Disruption[size]);
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
     *     The category
     */
    public String getCategory() {
        return category;
    }

    /**
     * 
     * @param category
     *     The category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The categoryDescription
     */
    public String getCategoryDescription() {
        return categoryDescription;
    }

    /**
     * 
     * @param categoryDescription
     *     The categoryDescription
     */
    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    /**
     * 
     * @return
     *     The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The additionalInfo
     */
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    /**
     * 
     * @param additionalInfo
     *     The additionalInfo
     */
    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    /**
     * 
     * @return
     *     The created
     */
    public String getCreated() {
        return created;
    }

    /**
     * 
     * @param created
     *     The created
     */
    public void setCreated(String created) {
        this.created = created;
    }

    /**
     * 
     * @return
     *     The lastUpdate
     */
    public String getLastUpdate() {
        return lastUpdate;
    }

    /**
     * 
     * @param lastUpdate
     *     The lastUpdate
     */
    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append($type).append(category).append(type).append(categoryDescription).append(description).append(additionalInfo).append(created).append(lastUpdate).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Disruption) == false) {
            return false;
        }
        Disruption rhs = ((Disruption) other);
        return new EqualsBuilder().append($type, rhs.$type).append(category, rhs.category).append(type, rhs.type).append(categoryDescription, rhs.categoryDescription).append(description, rhs.description).append(additionalInfo, rhs.additionalInfo).append(created, rhs.created).append(lastUpdate, rhs.lastUpdate).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue($type);
        dest.writeValue(category);
        dest.writeValue(type);
        dest.writeValue(categoryDescription);
        dest.writeValue(description);
        dest.writeValue(additionalInfo);
        dest.writeValue(created);
        dest.writeValue(lastUpdate);
    }

    public int describeContents() {
        return  0;
    }

}
