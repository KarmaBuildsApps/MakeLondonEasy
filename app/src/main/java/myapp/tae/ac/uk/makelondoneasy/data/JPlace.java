package myapp.tae.ac.uk.makelondoneasy.data;

/**
 * JPlace class stores From and To places info and the data in can be used to send query to TFL API
 * Created by Karma on 22/01/16.
 */
public class JPlace {
    private String name;
    private String icsCode;

    public JPlace(String name, String icsCode) {
        this.name = name;
        this.icsCode = icsCode;
    }

    public String getName() {
        return name;
    }

    public String getIcsCode() {
        return icsCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIcsCode(String icsCode) {
        this.icsCode = icsCode;
    }
}
