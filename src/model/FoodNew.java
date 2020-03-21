package model;

public class FoodNew {
	
	
	public String item ;
	public int year;
	public String period;
	public double value ;
	
	
	
	public FoodNew(String item, int year, String period, double value) {
		super();
		this.item = item;
		this.year = year;
		this.period = period;
		this.value = value;
	}
	
	
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}


}
