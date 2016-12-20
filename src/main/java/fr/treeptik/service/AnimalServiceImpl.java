package fr.treeptik.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.model.Animal;
import fr.treeptik.repository.AnimalRepository;

@Service
public class AnimalServiceImpl {
	
	@Autowired
	private AnimalRepository animalrep;
	
	public void setDAO(AnimalRepository dao) {
		this.animalrep = dao;
	}
	
	// get one
	@Transactional
	public Animal getAnimal(Long id) {
		return animalrep.findOne(id);
	}
	
	// get one with person
	@Transactional
	public Animal getidwithPerson(Long id) {
		return animalrep.getidwithPerson(id);
	}

	// save
	@Transactional
	public void addAnimal(Animal animal) {
		animalrep.save(animal);
	}
	
	// update
	@Transactional
	public void updateAnimal(Animal animal) {
		animalrep.save(animal);
	}
	
	// delete
	@Transactional
	public void deleteAnimal(Long id) {
		animalrep.delete(id);
	}
	
	// get all
	public List<Animal> FindAll() {
		return animalrep.findAll();
	}
	
	// get all with animal
	@Transactional
	public List<Animal> findAllwithPerson() {
		return animalrep.findAllwithPerson();
	}

}
