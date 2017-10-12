
package com.aksh.position;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aksh.bean.Position;

@Service
public class SnakePositionService {

	@Autowired
	private SnakePositionRepository snakepositionRepository;

	

	public void addPosition(List<Position> position) {
		position.forEach(pos -> {
			SnakePosition snakePosition = new SnakePosition();
			snakePosition.setStartingPoint(pos.getStartingPosition());
			snakePosition.setEndingPoint(pos.getEndingPosition());
			snakepositionRepository.save(snakePosition);
		});

	}

	
}
