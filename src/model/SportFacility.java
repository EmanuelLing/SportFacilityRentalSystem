package model;

public class SportFacility {

	private String facilityId;
	private String facilityName;
	private String location;
	private String capacity;
	private Double rentalCost;
	private FacilityType facilityType;
	
	public SportFacility() {
		facilityId = location = capacity = "";
		rentalCost = 0.0;
		facilityType = new FacilityType();
	}
	
	public String getFacilityId() {
		return facilityId;
	}
	
	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	public Double getRentalCost() {
		return rentalCost;
	}
	public void setRentalCost(Double rentalCost) {
		this.rentalCost = rentalCost;
	}
	public FacilityType getFacilityType() {
		return facilityType;
	}
	public void setFacilityType(FacilityType facilityType) {
		this.facilityType = facilityType;
	}
	
	
}
