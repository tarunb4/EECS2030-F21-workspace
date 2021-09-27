package model;

public class App {
	private String app_name;
	private int nofratings;
	private int rating;
	private int count_ratings_1;
	private int count_ratings_2;
	private int count_ratings_3;
	private int count_ratings_4;
	private int count_ratings_5;
	private double sum_of_ratings;
	private Log[] log_Array;
	private Log log;
	private int nofupdates;
	private String update;
	private final int MAX_NUM_OF_UPDATES = 20;
	
	public App(String app_name, int nofratings) {
		this.app_name = app_name;
		this.nofratings = 0;
		this.sum_of_ratings = 0.0;
		this.nofupdates = 0;
		this.log_Array = new Log[MAX_NUM_OF_UPDATES];
		this.update = "n/a";
	}
	
	public String getName() {
		return this.app_name;
	}
	
	public String getWhatIsNew() {
		if(this.nofupdates == 0){
			return "n/a";
		}
		
		else {
			return this.log.toString(); 
		}
	}
	
	public Log[] getUpdateHistory() {
		Log [] history = new Log[this.nofupdates];
		for(int i = 0; i < this.nofupdates; i ++) {
			history[i] = this.log_Array[i];
		}
		
		return history;
		
	}
	
	public Log getVersionInfo(String versionInfo) {
		
		for(int i = 0; i < this.nofupdates; i++) {
			Log l = this.log_Array[i];
			if(l.getVersion().equals(versionInfo)) {
				return l;
			}
		}
		
		return null;	
		
	}
	
	public String getRatingReport() {
		String s = "";
		
		if(this.nofratings == 0) {
			s += "No ratings submitted so far!";
		}
		
		else {
			
			return String.format("Average of %d ratings: %.1f (Score 5: %d, Score 4: %d, Score 3: %d, Score 2: %d, Score 1: %d)", this.nofratings, (this.sum_of_ratings / this.nofratings), 
					this.count_ratings_5, this.count_ratings_4, this.count_ratings_3, this.count_ratings_2, this.count_ratings_1);
		}
		
		return s;
	}
	
	public String toString() {
		if(this.nofupdates == 0 && this.nofratings == 0) {
			return this.app_name + " (Current Version: " + this.update + "; Average Rating: n/a)"; 
		}
		
		else {
			String formated = String.format("%s (Current Version: %s; Average Rating: %.1f)", this.app_name ,this.log.toString(), (this.sum_of_ratings / this.nofratings));
			return formated;
		}
		
	}
	
	public void releaseUpdate(String update) {
		this.log = new Log(update);
		this.log_Array[this.nofupdates] = this.log;
		this.update = update;
		this.nofupdates ++;
	}
	
	public void submitRating(int rating) {
		this.rating = rating;
		this.sum_of_ratings += rating;
		this.nofratings ++;
		
		if(this.rating == 1) {
			this.count_ratings_1 ++;
		}
		
		else if(this.rating == 2) {
			this.count_ratings_2 ++;
			
		}
		
		else if(this.rating == 3) {
			this.count_ratings_3 ++;
			
		}
		
		else if(this.rating == 4) {
			this.count_ratings_4 ++;
			
		}
		
		else if(this.rating == 5) {
			this.count_ratings_5 ++;
			
		}
	}
	
}
