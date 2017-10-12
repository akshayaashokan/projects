package com.aksh.menu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {
	
	@Autowired
	private MenuRepository menuRepository;
	
	public List<Menu> getAllMenu()
	{
		
		List<Menu> menu = new ArrayList<>();
		menuRepository.findAll()
		.forEach(menu::add);
		return menu;
		
	}
	
	
	public Menu getMenu(String dishName)
	{
		return menuRepository.findOne(dishName);
		
	}

	public void addMenu(Menu menu)
	{
		menuRepository.save(menu);
	}
	
	public void updateMenu(String dishName,Menu menu)
	{
		menuRepository.save(menu);
	}
	
	public void deleteMenu(String dishName)
	{
		menuRepository.delete(dishName);
	}
}
