package fr.treeptik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.treeptik.model.Animal;
import fr.treeptik.model.Person;
import fr.treeptik.service.PersonServiceImpl;

@Controller
public class PersonController {
	
	@Autowired
	PersonServiceImpl personservice;
	
	@RequestMapping(value="/helloperson")
	public void hello(){
		System.out.println("hello from person");
	}
	

	// remplir le tableau Person
	@RequestMapping(value = "/getAllPersons", method = RequestMethod.GET, headers = "Accept=application/json")  
	public String getCountries(Model model)
	{   
		model.addAttribute("person", new Person());  
		model.addAttribute("listOfPersons", personservice.findAllwithAnimal() );  
		return "personDetails";
	}  
	
	// add
	@Secured(value="USER")
	@RequestMapping( value="/addPerson",  method = RequestMethod.POST, headers = "Accept=application/json")
	public String addPerson( @ModelAttribute("person") Person person)
	{
		personservice.addPerson(person);
		return "redirect:/getAllPersons";  
	}
	
	
	// delete
	@Secured(value="USER")
	@RequestMapping(value = "/deletePerson/{id}", method = RequestMethod.GET, headers = "Accept=application/json")  
	public String deletePerson(@PathVariable("id") Long id) {  
		personservice.deletePerson(id);
		return "redirect:/getAllPersons";
	}
	
	// update
	@Secured(value="USER")
	@RequestMapping(value = "/updatePerson/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updatePerson(@PathVariable("id") Long id,Model model) {
		model.addAttribute("person", this.personservice.getPerson(id) );
        model.addAttribute("listOfPersons", this.personservice.findAllwithAnimal() );
        return "personDetails";
	}
	
	// remplir le tableau Animal
	@RequestMapping(value = "/showAnimals/{id}", method = RequestMethod.GET, headers = "Accept=application/json")  
	public String getAnimals(Model model, @PathVariable("id") Long id)
	{  
		model.addAttribute("animal", new Animal());  
		model.addAttribute("listOfAnimals", personservice.getPersonwithanimal(id).getLanim() );  
		
		model.addAttribute("person", new Person());  
		model.addAttribute("listOfPersons", personservice.findAllwithAnimal() );
		
		return "personDetails";
	}
	

}
