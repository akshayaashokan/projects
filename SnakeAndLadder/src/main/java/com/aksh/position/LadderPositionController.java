package com.aksh.position;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aksh.bean.Position;

@RestController
public class LadderPositionController {

	@Autowired
	private LadderPositionService ladderpositionService;
		
	@RequestMapping(method=RequestMethod.POST,value="/ladderpositions")
	public void addPosition(@RequestBody List<Position> position)
	{
		ladderpositionService.addPosition(position);
	}
	
	
}
