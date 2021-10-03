package model;

public class Registration {
	private String course_name;
	private int credits;
	private int marks;
	
	public Registration(String course_name, int credits, int marks) {
		this.course_name = course_name;
		this.credits = credits;
		this.marks = marks;
	}
	
	public Registration(String course_name, int credits) {
		this.course_name = course_name;
		this.credits = credits;
	}
	
	public String getCourseName() {
		return this.course_name;
	}
	
	public int getNumberOfCredits() {
		return this.credits;
	}
	
	public int getMarks() {
		return this.marks;
	}
	
	public String getLetterGrade() {
		String s = "";
		
		if(this.marks >= 90) {
			s += "A+";
		}
		
		else if (this.marks >= 80 && this.marks < 90) {
			s += "A";
		}
		
		else if(this.marks >= 70 && this.marks < 80) {
			s += "B";
		}
		
		else if(this.marks >= 60 && this.marks < 70) {
			s += "C";
		}
		
		else if(this.marks >= 50 && this.marks < 60) {
			s += "D";
		}
		
		else if(this.marks < 50) {
			s += "F";
		}
		
		return s;
	}
	
	public int getWeightedGradePoint() {
		int weighted_grade = 0;
		
		if(getLetterGrade().equals("A+")) {
			weighted_grade = 9 * this.credits;
		}
		
		else if(getLetterGrade().equals("A")) {
			weighted_grade = 8* this.credits;
		}
		
		else if(getLetterGrade().equals("B")) {
			weighted_grade = 7 * this.credits;
		}
		
		else if(getLetterGrade().equals("C")) {
			weighted_grade = 6 * this.credits;
		}
		
		else if(getLetterGrade().equals("D")) {
			weighted_grade = 5 * this.credits;
		}
		
		else if(getLetterGrade().equals("F")) {
			weighted_grade = 0 * this.credits;
		}
		
		return weighted_grade;
		
	}
	
	public void setMarks(int mark) {
		this.marks = mark;
	}
	
	
	
}
