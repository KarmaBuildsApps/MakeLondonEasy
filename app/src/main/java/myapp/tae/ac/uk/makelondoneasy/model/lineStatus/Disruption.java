
package myapp.tae.ac.uk.makelondoneasy.model.lineStatus;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


//@Generated("org.jsonschema2pojo")
public class Disruption {

    @SerializedName("$type")
    @Expose
    private String $type;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("categoryDescription")
    @Expose
    private String categoryDescription;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("affectedRoutes")
    @Expose
    private List<Object> affectedRoutes = new ArrayList<Object>();
    @SerializedName("affectedStops")
    @Expose
    private List<Object> affectedStops = new ArrayList<Object>();
    @SerializedName("isWholeLine")
    @Expose
    private Boolean isWholeLine;
    @SerializedName("closureText")
    @Expose
    private String closureText;

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
     * @return The category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category The category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return The categoryDescription
     */
    public String getCategoryDescription() {
        return categoryDescription;
    }

    /**
     * @param categoryDescription The categoryDescription
     */
    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    /**
     * @return The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return The affectedRoutes
     */
    public List<Object> getAffectedRoutes() {
        return affectedRoutes;
    }

    /**
     * @param affectedRoutes The affectedRoutes
     */
    public void setAffectedRoutes(List<Object> affectedRoutes) {
        this.affectedRoutes = affectedRoutes;
    }

    /**
     * @return The affectedStops
     */
    public List<Object> getAffectedStops() {
        return affectedStops;
    }

    /**
     * @param affectedStops The affectedStops
     */
    public void setAffectedStops(List<Object> affectedStops) {
        this.affectedStops = affectedStops;
    }

    /**
     * @return The isWholeLine
     */
    public Boolean getIsWholeLine() {
        return isWholeLine;
    }

    /**
     * @param isWholeLine The isWholeLine
     */
    public void setIsWholeLine(Boolean isWholeLine) {
        this.isWholeLine = isWholeLine;
    }

    /**
     * @return The closureText
     */
    public String getClosureText() {
        return closureText;
    }

    /**
     * @param closureText The closureText
     */
    public void setClosureText(String closureText) {
        this.closureText = closureText;
    }

}
