package com.aksh.position;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="snake_position")
public class SnakePosition {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	@Column(name = "starting_position")
	private int startingPoint;

	@Column(name = "ending_position")
	private int endingPoint;

	public int getStartingPoint() {
		return startingPoint;
	}

	public void setStartingPoint(int startingPoint) {
		this.startingPoint = startingPoint;
	}

	public int getEndingPoint() {
		return endingPoint;
	}

	public void setEndingPoint(int endingPoint) {
		this.endingPoint = endingPoint;
	}

}
