package com.aksh.menu;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Menu {

	@Id
	private String dishName;
	private int categoryId;
	private String dishType;
	private int dishPrice;
	
	public Menu()
	{
	}
	
	public Menu(String dishName,int categoryId,String dishType,int dishPrice)
	{
		super();
		this.dishName=dishName;
		this.categoryId=categoryId;
		this.dishType=dishType;
		this.dishPrice=dishPrice;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getDishType() {
		return dishType;
	}
	public void setDishType(String dishType) {
		this.dishType = dishType;
	}
	public int getDishPrice() {
		return dishPrice;
	}
	public void setDishPrice(int dishPrice) {
		this.dishPrice = dishPrice;
	}
	
}

