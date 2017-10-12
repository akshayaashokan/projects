package com.aksh.ladder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.aksh.position.LadderPosition;

@Entity
public class Ladder {
	
	@Id
	private int id;
	
	@OneToOne
	private LadderPosition position;
	
	public Ladder()
	{
		
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LadderPosition getPosition() {
		return position;
	}

	public void setPosition(LadderPosition position) {
		this.position = position;
	}

	

}
