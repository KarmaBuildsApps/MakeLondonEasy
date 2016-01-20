package myapp.tae.ac.uk.makelondoneasy.model.tofromJourney;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class Instruction implements Parcelable
{

    @SerializedName("$type")
    @Expose
    private String $type;
    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("detailed")
    @Expose
    private String detailed;
    @SerializedName("steps")
    @Expose
    private List<Object> steps = new ArrayList<Object>();
    public final static Parcelable.Creator<Instruction> CREATOR = new Creator<Instruction>() {


        public Instruction createFromParcel(Parcel in) {
            Instruction instance = new Instruction();
            instance.$type = ((String) in.readValue((String.class.getClassLoader())));
            instance.summary = ((String) in.readValue((String.class.getClassLoader())));
            instance.detailed = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.steps, (java.lang.Object.class.getClassLoader()));
            return instance;
        }

        public Instruction[] newArray(int size) {
            return (new Instruction[size]);
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
     *     The summary
     */
    public String getSummary() {
        return summary;
    }

    /**
     * 
     * @param summary
     *     The summary
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * 
     * @return
     *     The detailed
     */
    public String getDetailed() {
        return detailed;
    }

    /**
     * 
     * @param detailed
     *     The detailed
     */
    public void setDetailed(String detailed) {
        this.detailed = detailed;
    }

    /**
     * 
     * @return
     *     The steps
     */
    public List<Object> getSteps() {
        return steps;
    }

    /**
     * 
     * @param steps
     *     The steps
     */
    public void setSteps(List<Object> steps) {
        this.steps = steps;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append($type).append(summary).append(detailed).append(steps).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Instruction) == false) {
            return false;
        }
        Instruction rhs = ((Instruction) other);
        return new EqualsBuilder().append($type, rhs.$type).append(summary, rhs.summary).append(detailed, rhs.detailed).append(steps, rhs.steps).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue($type);
        dest.writeValue(summary);
        dest.writeValue(detailed);
        dest.writeList(steps);
    }

    public int describeContents() {
        return  0;
    }

}
