package com.aksh;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class WelcomeWorldController {
	@RequestMapping("/welcome")
	public ModelAndView helloWorld()
	{
		String message = "WELCOME!!";  
		return new ModelAndView("welcomepage", "message", message);  
		
	}
}
