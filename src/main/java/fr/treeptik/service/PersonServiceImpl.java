package fr.treeptik.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.model.Person;
import fr.treeptik.repository.PersonRepository;

@Service
public class PersonServiceImpl {

	@Autowired
	private PersonRepository personrep;

	public void setDAO(PersonRepository dao) {
		this.personrep = dao;
	}
	
	// get one
	@Transactional
	public Person getPerson(Long id) {
		return personrep.findOne(id);
	}
	
	// get one with animal
	@Transactional
	public Person getPersonwithanimal(Long id) {
		return personrep.getidwithAnimal(id);
	}

	// save
	@Transactional
	public void addPerson(Person pers) {
		personrep.save(pers);
	}
	
	// update
	@Transactional
	public void updatePerson(Person pers) {
		personrep.save(pers);
	}
	
	// delete
	@Transactional
	public void deletePerson(Long id) {
		 personrep.delete(id );
	}
	
	// get all
	@Transactional
	public List<Person> FindAll() {
		return personrep.findAll();
	}
	
	// get all with animal
	@Transactional
	public List<Person> findAllwithAnimal() {
		return personrep.findAllwithAnimal();
	}
	
	
//	public void testset(String name, Long id) {
//	    personnerep.metAJourName(name, id);
//	}
	
	
	// find by name
//	public List<Person> FindByName(String name) {
//	   return personnerep.findByNameLike( name);
//	}
	
}
