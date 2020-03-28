package model;

public class Food {
	
	
	public String item ;
	public String year;
	public String period;
	public String value ;
	
	
	
	public Food(String item, String year, String period, String value) {
		
		this.item = item;
		this.year = year;
		this.period = period;
		this.value = value;
	}
	
	
	public Food(String id, String val) {
		// TODO Auto-generated constructor stub
		item = id;
		value = val;
	}


	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}


}
