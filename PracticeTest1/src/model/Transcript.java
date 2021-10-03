package model;

public class Transcript {
	private String username;
	private Registration [] report_array;
	private Registration registration;
	private int count = 0;
	
	public Transcript(String username) {
		this.username = username;
		this.report_array = new Registration[this.count];
	}
	
	public Registration[] getReport() {
		if(this.count == 0) {
			return new Registration[0];
		}
		
		for(int i = 0; i < this.count; i ++) {
			this.report_array[i] = this.registration;
		}
		
		return this.report_array;
	}
	
	public void addRegistration(Registration new_registration) {
		this.report_array[this.count] = new_registration;
		this.count++;
	}
	
	public void addRegistration(String course_name, int credits) {
		Registration r = new Registration(course_name, credits);
		this.report_array[this.count] = r;
		this.count++;
	}
	
	
	
}
