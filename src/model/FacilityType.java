package model;

public class FacilityType {

	private String facilityType;
	private String description;
	
	public FacilityType() {
		facilityType = description = "";
	}
	
	public String getFacilityType() {
		return facilityType;
	}
	public void setFacilityType(String facilityType) {
		this.facilityType = facilityType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
