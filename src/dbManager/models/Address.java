package dbManager.models;

public class Address {

	private String houseNumber;
	private String street;
	private String district;
	private String city;
	private String postCode;
	
	public Address(String houseNumber, String street, String district, String city, String postCode) {
		super();
		this.houseNumber = houseNumber;
		this.street = street;
		this.district = district;
		this.city = city;
		this.postCode = postCode;
	}
	
	public String getHouseNumber() {
		return houseNumber;
	}
	
	public String getStreet() {
		return street;
	}
	
	public String getDistrict() {
		return district;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getPostCode() {
		return postCode;
	}

	@Override
	public String toString() {
		return "Address [houseNumber=" + houseNumber + ", street=" + street + ", district=" + district + ", city="
				+ city + ", postCode=" + postCode + "]";
	}
	
	
	
}
