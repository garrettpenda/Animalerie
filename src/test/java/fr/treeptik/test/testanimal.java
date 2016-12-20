package fr.treeptik.test;

import static org.easymock.EasyMock.*;

import java.util.ArrayList;
import java.util.List;

import org.easymock.IExpectationSetters;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.treeptik.model.Animal;
import fr.treeptik.repository.AnimalRepository;
import fr.treeptik.service.AnimalServiceImpl;

public class testanimal {
	
	private AnimalServiceImpl animalservice ;
	private AnimalRepository mockDAO;
	
	private Animal animal;
	private List<Animal> listAnimals;
	
	
	@Before
	public void setUp() throws Exception {
		mockDAO = createMock(AnimalRepository.class);
		animalservice = new AnimalServiceImpl();
		animalservice.setDAO(mockDAO);
		
		animal = new Animal();
		listAnimals = new ArrayList<>();
	}


	@Test
    public void testget()  {
        Animal testanimal = new Animal("rex","trex","m");
        Assert.assertTrue(  testanimal.getName()=="rex" && testanimal.getType()=="trex" && testanimal.getSex()=="m"  );
    }
	
	// test creation dans la bdd
	@Test
	public void testCreate() {
		animal.setName("Test Animal (mock)");
		expect(mockDAO.save(animal)).andReturn(animal);
		replay(mockDAO);
		animalservice.addAnimal(animal);
		verify(mockDAO);
		
		
	}
	
	// test de findall dans la bdd
	@Test
	public void testFindAll() {
		expect(mockDAO.findAll()).andReturn(listAnimals);
		replay(mockDAO);
		animalservice.FindAll();
		verify(mockDAO);
	}
	
	// test suppression dans la bdd
	@Test
	public void testDelete() {
		animal.setId(1L);
		expect(mockDAO.save(animal)).andReturn(animal);
		mockDAO.delete(animal.getId() );
		replay(mockDAO);
		animalservice.addAnimal(animal);
		animalservice.deleteAnimal(animal.getId());
		verify(mockDAO);
		
	}


	
}
