
package myapp.tae.ac.uk.makelondoneasy.model.lineStatus;

import java.util.ArrayList;
import java.util.List;
//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("org.jsonschema2pojo")
public class TFLLineStatus {

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
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The modeName
     */
    public String getModeName() {
        return modeName;
    }

    /**
     * 
     * @param modeName
     *     The modeName
     */
    public void setModeName(String modeName) {
        this.modeName = modeName;
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
     *     The modified
     */
    public String getModified() {
        return modified;
    }

    /**
     * 
     * @param modified
     *     The modified
     */
    public void setModified(String modified) {
        this.modified = modified;
    }

    /**
     * 
     * @return
     *     The lineStatuses
     */
    public List<LineStatus> getLineStatuses() {
        return lineStatuses;
    }

    /**
     * 
     * @param lineStatuses
     *     The lineStatuses
     */
    public void setLineStatuses(List<LineStatus> lineStatuses) {
        this.lineStatuses = lineStatuses;
    }

    /**
     * 
     * @return
     *     The routeSections
     */
    public List<Object> getRouteSections() {
        return routeSections;
    }

    /**
     * 
     * @param routeSections
     *     The routeSections
     */
    public void setRouteSections(List<Object> routeSections) {
        this.routeSections = routeSections;
    }

    /**
     * 
     * @return
     *     The serviceTypes
     */
    public List<ServiceType> getServiceTypes() {
        return serviceTypes;
    }

    /**
     * 
     * @param serviceTypes
     *     The serviceTypes
     */
    public void setServiceTypes(List<ServiceType> serviceTypes) {
        this.serviceTypes = serviceTypes;
    }

}
