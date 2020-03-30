package model;

public class FoodEtl {
	
	String item;
	String item_name;
	String year;
	String period;
	String value;
	
	
	public FoodEtl(String item, String item_name, String year, String period, String value) {
		
		this.item = item;
		this.item_name = item_name;
		this.year = year;
		this.period = period;
		this.value = value;
	}
	
	public FoodEtl(String id, String name, String y, String per) {
		
		item = id;
		item_name = name;
		year = y;
		period = per;
		// TODO Auto-generated constructor stub
	}

	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
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
