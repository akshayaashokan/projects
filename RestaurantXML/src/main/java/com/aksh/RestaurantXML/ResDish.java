package com.aksh.RestaurantXML;

import java.util.Set;

public class ResDish {
	private int catId;
	private String catName;
	private Set<ResMenu> menu;
	public ResDish()
	{}
		
	public ResDish(String catName)
	{
		this.catName=catName;
	}
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	
	
	
	
	public Set<ResMenu> getMenu() {
		return menu;
	}
	public void setMenu(Set<ResMenu> menu) {
		this.menu = menu;
	}
	
}
