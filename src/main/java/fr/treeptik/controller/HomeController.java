package fr.treeptik.controller;

import java.util.Collection;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {

	@RequestMapping(value={"/", "/home"}, method=RequestMethod.GET)
	protected ModelAndView homePage() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "SpringWEB - Home");
		model.addObject("message", "This is the welcome page!");
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); //get logged in username
		Collection<? extends GrantedAuthority> authorities =  auth.getAuthorities();
		model.addObject("name", name);
		model.addObject("autori", authorities );
		model.setViewName("home");
		return model;
	}
	
	// page admin
	@Secured(value="ADMIN")
	@RequestMapping(value = "/admin", method = RequestMethod.GET, headers = "Accept=application/json")  
	public ModelAndView adminPage()
	{    
		ModelAndView model = new ModelAndView();
		model.addObject("message", "This is the welcome page!");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); 
		Collection<? extends GrantedAuthority> authorities =  auth.getAuthorities();
		model.addObject("name", name);
		model.addObject("autori", authorities );
		model.setViewName("admin");
		return model;
	}  
	
	
}
