package model;

public class AppStore {
	private String Country;
	private int max_NumberofApps;
	private App app;
	private App[] app_array;
	private String [] stableApps;
	private int num_ofStableApps;
	private int count;
	
	public AppStore(String Country, int max_NumberofApps) {
		this.Country = Country;
		this.max_NumberofApps = max_NumberofApps;
		this.app_array = new App[max_NumberofApps];
	}
	
	public String getBranch() {
		return this.Country;
	}
	
	public App getApp(String name) {
		if(this.app_array == null) {
			return null;
		}
		for(int i = 0; i < this.count; i ++) {
			App app_object = this.app_array[i];
			if(app_object.getName().equals(name)) {
				return app_object;
			}
		}
		
		return null;
	}
	
	public String[] getStableApps(int num) {
		if(this.app_array == null) {
			return new String[0];
		}
		
		else {
			this.stableApps = new String[this.count];
			int stable_num = 0;
			for(int i = 0; i < this.count; i++) {
				if(this.app_array[i].getUpdateHistory().length >= num) {
					this.stableApps[i] = this.app_array[i].getName() + String.format(" (%d versions; Current Version: %s)", this.app_array[i].getUpdateHistory().length, 
							this.app_array[i].getUpdateHistory()[this.app_array[i].getUpdateHistory().length - 1].toString());
					stable_num++;
				}
			}
			
			String [] temp = new String[stable_num];
			int stable_num2 = 0;
			for(int i = 0; i < this.stableApps.length; i ++) {
				if(this.stableApps[i] != null) {
					temp[stable_num2] = this.stableApps[i];
					stable_num2 ++;
				}
				
//				if(stable_num == stable_num2) {
//					break;
//				}
			}
			

			return temp;
		}
		
	}
	
	public void addApp(App app) {
		this.app_array[this.count] = app;
		this.count ++;
	}
	
	
}	