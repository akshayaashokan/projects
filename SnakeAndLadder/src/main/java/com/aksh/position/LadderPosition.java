package com.aksh.position;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="ladder_position")
public class LadderPosition {
	
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
	private int startingPosition;
	
	@Column(name = "ending_position")
	private int endingPosition;



	/**
	 * @return the startingPosition
	 */
	public int getStartingPosition() {
		return startingPosition;
	}

	/**
	 * @param startingPosition the startingPosition to set
	 */
	public void setStartingPosition(int startingPosition) {
		this.startingPosition = startingPosition;
	}

	/**
	 * @return the endingPosition
	 */
	public int getEndingPosition() {
		return endingPosition;
	}

	/**
	 * @param endingPosition the endingPosition to set
	 */
	public void setEndingPosition(int endingPosition) {
		this.endingPosition = endingPosition;
	}
	
	
	

}
