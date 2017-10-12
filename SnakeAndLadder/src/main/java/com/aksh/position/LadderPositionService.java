package com.aksh.position;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aksh.bean.Position;

@Service
public class LadderPositionService {
	@Autowired
	private LadderPositionRepository ladderpositionRepository;
	
	
	
	public void addPosition(List<Position> position) {
		position.forEach(pos -> {
			LadderPosition ladderPosition = new LadderPosition();
			ladderPosition.setStartingPosition(pos.getStartingPosition());
			ladderPosition.setEndingPosition(pos.getEndingPosition());
			ladderpositionRepository.save(ladderPosition);
		});
	}
}
