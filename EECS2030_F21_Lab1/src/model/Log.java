package model;

public class Log {
	String versionNumber;
	int nof;
	String [] fixes;
	String s;
	
	public Log(String versionNumber) {
		this.versionNumber = versionNumber;
		this.nof = nof;
		this.fixes = fixes;
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
			
			for(int i = 0; i < this.nof; i ++) {
				s += this.fixes[i];
				s += ", ";
				this.nof ++;
			}
			
			s += "]";
		}
		
		return s;
		
	}
	
	public String toString() {
		return "Version " + this.versionNumber + " contains " + this.nof + " fixes " + s;
	}
	
	public void addFix(String fix) {
		this.fixes[this.nof] = fix;
		this.nof ++;
	}
	
	
	
	
	
}