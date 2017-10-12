package com.aksh.RestaurantXML;

public class ResMenu {
	private String dish_name;
	private int category_id;
	private String type;
	private int price;
	private ResDish dish;
	
	public String getDish_name() {
		return dish_name;
	}

	public void setDish_name(String dish_name) {
		this.dish_name = dish_name;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public ResDish getDish() {
		return dish;
	}

	public void setDish(ResDish dish) {
		this.dish = dish;
	}
	public ResMenu() {}

	public ResMenu(String dish_name,int category_id,String type,int price) {
		this.dish_name=dish_name;
		this.category_id=category_id;
		this.type=type;
		this.price=price;
		
	}

}
