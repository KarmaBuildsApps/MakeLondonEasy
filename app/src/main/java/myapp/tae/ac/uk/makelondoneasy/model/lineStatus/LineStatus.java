
package myapp.tae.ac.uk.makelondoneasy.model.lineStatus;

import java.util.ArrayList;
import java.util.List;
//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("org.jsonschema2pojo")
public class LineStatus {

    @SerializedName("$type")
    @Expose
    private String $type;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("lineId")
    @Expose
    private String lineId;
    @SerializedName("statusSeverity")
    @Expose
    private Integer statusSeverity;
    @SerializedName("statusSeverityDescription")
    @Expose
    private String statusSeverityDescription;
    @SerializedName("reason")
    @Expose
    private String reason;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("validityPeriods")
    @Expose
    private List<ValidityPeriod> validityPeriods = new ArrayList<ValidityPeriod>();
    @SerializedName("disruption")
    @Expose
    private Disruption disruption;

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
     *     The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The lineId
     */
    public String getLineId() {
        return lineId;
    }

    /**
     * 
     * @param lineId
     *     The lineId
     */
    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    /**
     * 
     * @return
     *     The statusSeverity
     */
    public Integer getStatusSeverity() {
        return statusSeverity;
    }

    /**
     * 
     * @param statusSeverity
     *     The statusSeverity
     */
    public void setStatusSeverity(Integer statusSeverity) {
        this.statusSeverity = statusSeverity;
    }

    /**
     * 
     * @return
     *     The statusSeverityDescription
     */
    public String getStatusSeverityDescription() {
        return statusSeverityDescription;
    }

    /**
     * 
     * @param statusSeverityDescription
     *     The statusSeverityDescription
     */
    public void setStatusSeverityDescription(String statusSeverityDescription) {
        this.statusSeverityDescription = statusSeverityDescription;
    }

    /**
     * 
     * @return
     *     The reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * 
     * @param reason
     *     The reason
     */
    public void setReason(String reason) {
        this.reason = reason;
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
     *     The validityPeriods
     */
    public List<ValidityPeriod> getValidityPeriods() {
        return validityPeriods;
    }

    /**
     * 
     * @param validityPeriods
     *     The validityPeriods
     */
    public void setValidityPeriods(List<ValidityPeriod> validityPeriods) {
        this.validityPeriods = validityPeriods;
    }

    /**
     * 
     * @return
     *     The disruption
     */
    public Disruption getDisruption() {
        return disruption;
    }

    /**
     * 
     * @param disruption
     *     The disruption
     */
    public void setDisruption(Disruption disruption) {
        this.disruption = disruption;
    }

}
