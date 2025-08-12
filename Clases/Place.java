package Clases;

public class Place {
    private String postalCode;
    private String city;
    private String stateProvince;
    private String country;
    
    public Place(){}
    
    public Place(String newP, String newCI, String newS, String newCO){
        this.postalCode = newP;
        this.city = newCI;
        this.stateProvince = newS;
        this.country = newCO;
    }

// GET & SET
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }   
}
