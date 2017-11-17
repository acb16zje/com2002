package model;

public class Address {

    private String houseNo;
    private String street;
    private String district;
    private String city;
    private String postcode;

    /**
     * Constructor for Address
     *
     * @param houseNo The house number
     * @param street The street name
     * @param district The district name
     * @param city The city name
     * @param postcode The postal code
     */
    public Address(String houseNo, String street, String district, String city, String postcode) {
        this.houseNo = houseNo;
        this.street = street;
        this.district = district;
        this.city = city;
        this.postcode = postcode;
    }

    /**
     * Get the house number
     *
     * @return The house number
     */
    public String getHouseNo() {
        return houseNo;
    }

    /**
     * Set the new house number
     *
     * @param houseNo The new house number
     */
    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    /**
     * Get the street name
     *
     * @return The street name
     */
    public String getStreet() {
        return street;
    }

    /**
     * Set the street name
     *
     * @param street The new street name
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Get the district name
     *
     * @return The district name
     */
    public String getDistrict() {
        return district;
    }

    /**
     * Set the new district name
     *
     * @param district The new district name
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * Get the city name
     *
     * @return The city name
     */
    public String getCity() {
        return city;
    }

    /**
     * Set the new city name
     *
     * @param city The new city name
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Get the postcode
     *
     * @return The postcode
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * Set the new postcode
     *
     * @param postcode The new postcode
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}
