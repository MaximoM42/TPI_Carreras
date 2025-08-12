package Clases;

public class Track {
    private String name;
    private String description;
    private String postalCode;
    
    public Track(){}
    
    public Track(String newN, String newD, String newP){
        this.name = newN;
        this.description = newD;
        this.postalCode = newP;
    }
// GET & SET
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    
}
