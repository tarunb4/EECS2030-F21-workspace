package model;

public class Vaccine {
	public String codeName;
	public String vaccineType;
	public String brand;
	
	public Vaccine(String codeName, String vaccineType, String brand) {
		this.codeName = codeName;
		this.vaccineType = vaccineType;
		this.brand = brand;
	}
	
	public String toString() {
		if(this.brand.equals("Moderna") || this.brand.equals("Pfizer/BioNTech") || this.brand.equals("Janssen") || this.brand.equals("Oxford/AstraZeneca")) {
			return "Recognized vaccine: " + this.codeName + " (" + this.vaccineType + "; " + this.brand + ")";
		}
		
		else {
			return "Unrecognized vaccine: " + this.codeName + " (" + this.vaccineType + "; " + this.brand + ")";
		}
		
	}
}
