package com.aksh.Restaurant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;

@Entity
@Table(name="Restaurant")
public class Restaurant {
	@Id
	@Column(name="dish_name")
	private String dish_name;
	@Column(name="category_id")
	private int category_id;
	@Column(name="type")
	private String type;
	@Column(name="price")
	private int price;
	@ManyToOne
	@JoinColumn(name="cat_id", nullable=false)
	private Dish ds;
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
	public Dish getDs() {
		return ds;
	}
	public void setDs(Dish ds) {
		this.ds = ds;
	}
	

}
