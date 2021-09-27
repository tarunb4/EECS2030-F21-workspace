package model;

public class Account {
	private String name;
	private String status = "";
	private AppStore appstore;
	private int num_of_downloads;
	private final int MAX_NUM_OF_DOWNLOADS = 50;
	private App[] app_array = new App[MAX_NUM_OF_DOWNLOADS];
	private String[] namesOfDownloadedApps;
	
	public Account(String name, AppStore appstore) {
		this.name = name;
		this.appstore = appstore;
		this.num_of_downloads = 0;
		
		this.status = "An account linked to the " + this.appstore.getBranch() + " store is created for " + this.name + ".";
	}
	
	public String[] getNamesOfDownloadedApps() {
		this.namesOfDownloadedApps = new String[this.num_of_downloads];
				
		if(this.num_of_downloads == 0) {
			return new String[0];
		}
		
		for(int i = 0; i < this.num_of_downloads; i++) {
			this.namesOfDownloadedApps[i] = this.app_array[i].getName();
		}
		
		return this.namesOfDownloadedApps;
	}
	
	public App[] getObjectsOfDownloadedApps() {
		App [] objectsOfDownloadedApps = new App[this.num_of_downloads];
				
		if(this.num_of_downloads == 0) {
			return new App[0];
		}
		
		for(int i = 0; i < this.num_of_downloads; i++) {
			objectsOfDownloadedApps[i] = this.app_array[i];
		}
		
		return objectsOfDownloadedApps;
	}
	
	public void download(String app_name) {
		boolean found = false;
		if(this.appstore.getApp(app_name) != null) {
			for(int i = 0; i < this.num_of_downloads; i++) {
				if(this.app_array[i] == this.appstore.getApp(app_name)) {
					found = true;
					this.status = "Error: "  + app_name + " has already been downloaded for " + this.name + ".";
					break;
				}
			}
			
			if(!found) {
				this.app_array[this.num_of_downloads] = this.appstore.getApp(app_name);
				this.num_of_downloads ++;
				this.status = app_name + " is successfully downloaded for " + this.name + ".";
			}
			
		}
	}
	
	public void uninstall(String app_name) {
		boolean check = false;
		
		this.status = "Error: " + app_name + " has not been downloaded for " + this.name + ".";
				
		if(this.appstore.getApp(app_name) != null) {
			for(int i = 0; i < this.num_of_downloads; i++) {
				if(this.app_array[i].getName().equals(app_name)) {
					check = true;
				}
				
				if(check) {
					this.app_array[i] = this.app_array[i+1];
				}
			}
			
			if(check) {
				this.num_of_downloads --;
				this.status = app_name + " is successfully uninstalled for " + this.name + ".";
			}
		}
		
		
	}
	
	public void submitRating(String app_name, int rating) {
		
		this.status = "Error: " + app_name + " is not a downloaded app for " + this.name + ".";
		
		if(this.appstore.getApp(app_name) != null) {
			for(int i = 0; i < this.num_of_downloads; i ++) {
				if(this.app_array[i].getName().equals(app_name)) {
					this.appstore.getApp(app_name).submitRating(rating);
					this.status = "Rating score " + rating + " of " + this.name + " is successfully submitted for " + app_name + ".";
				}
			}
		
		}
		
	}
	
	public void switchStore(AppStore new_appstore) {
		this.appstore = new_appstore;
		this.status = "Account for " + this.name + " is now linked to the " + this.appstore.getBranch() + " store.";
	}
	
	public String toString() {
		return this.status;
	}
}
