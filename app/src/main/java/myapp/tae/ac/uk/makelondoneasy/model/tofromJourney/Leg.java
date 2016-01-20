package myapp.tae.ac.uk.makelondoneasy.model.tofromJourney;


import android.graphics.PorterDuff;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class Leg implements Parcelable
{

    @SerializedName("$type")
    @Expose
    private String $type;
    @SerializedName("duration")
    @Expose
    private Integer duration;
    @SerializedName("instruction")
    @Expose
    private Instruction instruction;
    @SerializedName("obstacles")
    @Expose
    private List<Object> obstacles = new ArrayList<Object>();
    @SerializedName("departureTime")
    @Expose
    private String departureTime;
    @SerializedName("arrivalTime")
    @Expose
    private String arrivalTime;
    @SerializedName("departurePoint")
    @Expose
    private DeparturePoint departurePoint;
    @SerializedName("arrivalPoint")
    @Expose
    private ArrivalPoint arrivalPoint;
    @SerializedName("path")
    @Expose
    private Path path;
    @SerializedName("routeOptions")
    @Expose
    private List<RouteOption> routeOptions = new ArrayList<RouteOption>();
    @SerializedName("mode")
    @Expose
    private Mode mode;
    @SerializedName("disruptions")
    @Expose
    private List<Disruption> disruptions = new ArrayList<Disruption>();
    @SerializedName("plannedWorks")
    @Expose
    private List<Object> plannedWorks = new ArrayList<Object>();
    @SerializedName("isDisrupted")
    @Expose
    private Boolean isDisrupted;
    @SerializedName("hasFixedLocations")
    @Expose
    private Boolean hasFixedLocations;
    public final static Parcelable.Creator<Leg> CREATOR = new Creator<Leg>() {


        public Leg createFromParcel(Parcel in) {
            Leg instance = new Leg();
            instance.$type = ((String) in.readValue((String.class.getClassLoader())));
            instance.duration = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.instruction = ((Instruction) in.readValue((Instruction.class.getClassLoader())));
            in.readList(instance.obstacles, (java.lang.Object.class.getClassLoader()));
            instance.departureTime = ((String) in.readValue((String.class.getClassLoader())));
            instance.arrivalTime = ((String) in.readValue((String.class.getClassLoader())));
            instance.departurePoint = ((DeparturePoint) in.readValue((DeparturePoint.class.getClassLoader())));
            instance.arrivalPoint = ((ArrivalPoint) in.readValue((ArrivalPoint.class.getClassLoader())));
            instance.path = ((Path) in.readValue((Path.class.getClassLoader())));
            in.readList(instance.routeOptions, (RouteOption.class.getClassLoader()));
            instance.mode = ((Mode) in.readValue((Mode.class.getClassLoader())));
            in.readList(instance.disruptions, (Disruption.class.getClassLoader()));
            in.readList(instance.plannedWorks, (java.lang.Object.class.getClassLoader()));
            instance.isDisrupted = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.hasFixedLocations = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            return instance;
        }

        public Leg[] newArray(int size) {
            return (new Leg[size]);
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
     *     The duration
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * 
     * @param duration
     *     The duration
     */
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    /**
     * 
     * @return
     *     The instruction
     */
    public Instruction getInstruction() {
        return instruction;
    }

    /**
     * 
     * @param instruction
     *     The instruction
     */
    public void setInstruction(Instruction instruction) {
        this.instruction = instruction;
    }

    /**
     * 
     * @return
     *     The obstacles
     */
    public List<Object> getObstacles() {
        return obstacles;
    }

    /**
     * 
     * @param obstacles
     *     The obstacles
     */
    public void setObstacles(List<Object> obstacles) {
        this.obstacles = obstacles;
    }

    /**
     * 
     * @return
     *     The departureTime
     */
    public String getDepartureTime() {
        return departureTime;
    }

    /**
     * 
     * @param departureTime
     *     The departureTime
     */
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    /**
     * 
     * @return
     *     The arrivalTime
     */
    public String getArrivalTime() {
        return arrivalTime;
    }

    /**
     * 
     * @param arrivalTime
     *     The arrivalTime
     */
    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    /**
     * 
     * @return
     *     The departurePoint
     */
    public DeparturePoint getDeparturePoint() {
        return departurePoint;
    }

    /**
     * 
     * @param departurePoint
     *     The departurePoint
     */
    public void setDeparturePoint(DeparturePoint departurePoint) {
        this.departurePoint = departurePoint;
    }

    /**
     * 
     * @return
     *     The arrivalPoint
     */
    public ArrivalPoint getArrivalPoint() {
        return arrivalPoint;
    }

    /**
     * 
     * @param arrivalPoint
     *     The arrivalPoint
     */
    public void setArrivalPoint(ArrivalPoint arrivalPoint) {
        this.arrivalPoint = arrivalPoint;
    }

    /**
     * 
     * @return
     *     The path
     */
    public Path getPath() {
        return path;
    }

    /**
     * 
     * @param path
     *     The path
     */
    public void setPath(Path path) {
        this.path = path;
    }

    /**
     * 
     * @return
     *     The routeOptions
     */
    public List<RouteOption> getRouteOptions() {
        return routeOptions;
    }

    /**
     * 
     * @param routeOptions
     *     The routeOptions
     */
    public void setRouteOptions(List<RouteOption> routeOptions) {
        this.routeOptions = routeOptions;
    }

    /**
     * 
     * @return
     *     The mode
     */
    public Mode getMode() {
        return mode;
    }

    /**
     * 
     * @param mode
     *     The mode
     */
    public void setMode(Mode mode) {
        this.mode = mode;
    }

    /**
     * 
     * @return
     *     The disruptions
     */
    public List<Disruption> getDisruptions() {
        return disruptions;
    }

    /**
     * 
     * @param disruptions
     *     The disruptions
     */
    public void setDisruptions(List<Disruption> disruptions) {
        this.disruptions = disruptions;
    }

    /**
     * 
     * @return
     *     The plannedWorks
     */
    public List<Object> getPlannedWorks() {
        return plannedWorks;
    }

    /**
     * 
     * @param plannedWorks
     *     The plannedWorks
     */
    public void setPlannedWorks(List<Object> plannedWorks) {
        this.plannedWorks = plannedWorks;
    }

    /**
     * 
     * @return
     *     The isDisrupted
     */
    public Boolean getIsDisrupted() {
        return isDisrupted;
    }

    /**
     * 
     * @param isDisrupted
     *     The isDisrupted
     */
    public void setIsDisrupted(Boolean isDisrupted) {
        this.isDisrupted = isDisrupted;
    }

    /**
     * 
     * @return
     *     The hasFixedLocations
     */
    public Boolean getHasFixedLocations() {
        return hasFixedLocations;
    }

    /**
     * 
     * @param hasFixedLocations
     *     The hasFixedLocations
     */
    public void setHasFixedLocations(Boolean hasFixedLocations) {
        this.hasFixedLocations = hasFixedLocations;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append($type).append(duration).append(instruction).append(obstacles).append(departureTime).append(arrivalTime).append(departurePoint).append(arrivalPoint).append(path).append(routeOptions).append(mode).append(disruptions).append(plannedWorks).append(isDisrupted).append(hasFixedLocations).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Leg) == false) {
            return false;
        }
        Leg rhs = ((Leg) other);
        return new EqualsBuilder().append($type, rhs.$type).append(duration, rhs.duration).append(instruction, rhs.instruction).append(obstacles, rhs.obstacles).append(departureTime, rhs.departureTime).append(arrivalTime, rhs.arrivalTime).append(departurePoint, rhs.departurePoint).append(arrivalPoint, rhs.arrivalPoint).append(path, rhs.path).append(routeOptions, rhs.routeOptions).append(mode, rhs.mode).append(disruptions, rhs.disruptions).append(plannedWorks, rhs.plannedWorks).append(isDisrupted, rhs.isDisrupted).append(hasFixedLocations, rhs.hasFixedLocations).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue($type);
        dest.writeValue(duration);
        dest.writeValue(instruction);
        dest.writeList(obstacles);
        dest.writeValue(departureTime);
        dest.writeValue(arrivalTime);
        dest.writeValue(departurePoint);
        dest.writeValue(arrivalPoint);
        dest.writeValue(path);
        dest.writeList(routeOptions);
        dest.writeValue(mode);
        dest.writeList(disruptions);
        dest.writeList(plannedWorks);
        dest.writeValue(isDisrupted);
        dest.writeValue(hasFixedLocations);
    }

    public int describeContents() {
        return  0;
    }

}
