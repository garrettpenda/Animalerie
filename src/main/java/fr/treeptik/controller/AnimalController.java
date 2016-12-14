package fr.treeptik.controller;

import java.util.ArrayList;
import java.util.List;

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
import fr.treeptik.service.AnimalServiceImpl;
import fr.treeptik.service.PersonServiceImpl;

@Controller
public class AnimalController {
	
	@Autowired
	AnimalServiceImpl animalservice;
	
	@Autowired
	PersonServiceImpl personservice;
	
	
	@RequestMapping(value="/helloanimal")
	public void hello(){
		System.out.println("hello from animal");
	}
	
	// remplir le tableau au chargement de la page
	@RequestMapping(value = "/getAllAnimals", method = RequestMethod.GET, headers = "Accept=application/json")  
	public String getCountries(Model model)
	{  
		List<Animal> listOfAnimals = animalservice.FindAll();  
		model.addAttribute("animal", new Animal());  
		model.addAttribute("listOfAnimals", listOfAnimals);  
		return "animalDetails";  
	} 
	
	// add
	@Secured(value="USER")
	@RequestMapping( value="/addAnimal",  method = RequestMethod.POST, headers = "Accept=application/json")
	public String addPerson( @ModelAttribute("animal") Animal animal)
	{
		animalservice.addAnimal(animal);
		return "redirect:/getAllAnimals";  
	}
	
	// delete
	@Secured(value="USER")
	@RequestMapping(value = "/deleteAnimal/{id}", method = RequestMethod.GET, headers = "Accept=application/json")  
	public String deleteAnimal(@PathVariable("id") Long id) {  
		animalservice.deleteAnimal(id);
		return "redirect:/getAllAnimals";
	}   
	
	// update
	@Secured(value="USER")
	@RequestMapping(value = "/updateAnimal/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateAnimal(@PathVariable("id") Long id,Model model) {
		model.addAttribute("animal", this.animalservice.getAnimal(id) );
        model.addAttribute("listOfAnimals", this.animalservice.findAllwithPerson() );
        return "animalDetails";
	}
	
	// remplir le tableau Animal
	@RequestMapping(value = "/showPerson/{id}", method = RequestMethod.GET, headers = "Accept=application/json")  
	public String getAnimals(Model model, @PathVariable("id") Long id)
	{  
		model.addAttribute("person", new Person());
		List<Person> test = new ArrayList<Person>() ;
		test.add( personservice.getPerson(id)) ;
		model.addAttribute("listOfPerson", test );  
		
		model.addAttribute("animal", new Animal());  
		model.addAttribute("listOfAnimals",animalservice.findAllwithPerson() );
		
		return "animalDetails";
	}
	
	

}
