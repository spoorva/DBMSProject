package model;

public class Item {
	
	public String item; 
	public String item_name;
	public String display_level;
	public String selectable;
	public String sort_sequence;
	
	
	public Item(String item, String item_name) {
		this.item = item;
		this.item_name = item_name;
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


	public String getDisplay_level() {
		return display_level;
	}


	public void setDisplay_level(String display_level) {
		this.display_level = display_level;
	}


	public String getSelectable() {
		return selectable;
	}


	public void setSelectable(String selectable) {
		this.selectable = selectable;
	}


	public String getSort_sequence() {
		return sort_sequence;
	}


	public void setSort_sequence(String sort_sequence) {
		this.sort_sequence = sort_sequence;
	}
	
	
	
	
	

}
