package com.aksh.menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {

	@Autowired
	private MenuService menuService;
	
	@RequestMapping("/menu")
	public List<Menu> getAllMenu()
	{
		return menuService.getAllMenu();
	}
	
	public Menu getMenu()
	{
		return menuService.getMenu(dishName);
	}
}
