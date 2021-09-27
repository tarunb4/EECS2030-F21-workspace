package model;

public class Log {
	private String versionNumber;
	private int nof;
	private String [] fixes;
	private String s;
	private final int MAX_CAPACITY = 10;
	
	public Log(String versionNumber) {
		this.versionNumber = versionNumber;
		this.nof = 0;
		this.fixes = new String[MAX_CAPACITY];
	}
	
	public String getVersion() {
		return this.versionNumber;
	}
	
	public int getNumberOfFixes() {
		return this.nof;
	}
	
	public String getFixes() {	
		s = "[";
		
		if(this.nof == 0) {
			s += "]";
		}
		
		else{
			
			for(int i = 0; i < this.nof; i++) {
				s += this.fixes[i];
				s += ", ";
			}
			
			s = s.substring(0, s.length() - 2);
			s += "]";
		}
		
		return s;
		
	}
	
	public String toString() {
		return "Version " + this.versionNumber + " contains " + this.nof + " fixes " + getFixes();
	}
	
	public void addFix(String fix) {
		this.fixes[this.nof] = fix;
		this.nof++;
	}
	
	
	
	
	
}