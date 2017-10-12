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
public class SnakePositionController {

	@Autowired
	private SnakePositionService snakepositionService;
	
	
	@RequestMapping(method=RequestMethod.POST,value="/snakepositions")
	public void addPosition(@RequestBody List<Position> position)
	{
		snakepositionService.addPosition(position);
	}
	
}
