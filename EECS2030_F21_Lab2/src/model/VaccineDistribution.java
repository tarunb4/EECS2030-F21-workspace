package model;

public class VaccineDistribution {
	private Vaccine vaccine;
	private int doses;
	
	public VaccineDistribution(Vaccine vaccine, int doses) {
		this.vaccine = vaccine;
		this.doses = doses;
	}
	
	public String toString() {
		return this.doses + " doses of " + this.vaccine.codeName + " by " + this.vaccine.brand;
	}
}
