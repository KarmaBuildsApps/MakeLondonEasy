
package myapp.tae.ac.uk.makelondoneasy.model.lineStatus;

//import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("org.jsonschema2pojo")
public class ValidityPeriod {

    @SerializedName("$type")
    @Expose
    private String $type;
    @SerializedName("fromDate")
    @Expose
    private String fromDate;
    @SerializedName("toDate")
    @Expose
    private String toDate;
    @SerializedName("isNow")
    @Expose
    private Boolean isNow;

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
     * @return The fromDate
     */
    public String getFromDate() {
        return fromDate;
    }

    /**
     * @param fromDate The fromDate
     */
    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    /**
     * @return The toDate
     */
    public String getToDate() {
        return toDate;
    }

    /**
     * @param toDate The toDate
     */
    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    /**
     * @return The isNow
     */
    public Boolean getIsNow() {
        return isNow;
    }

    /**
     * @param isNow The isNow
     */
    public void setIsNow(Boolean isNow) {
        this.isNow = isNow;
    }

}
