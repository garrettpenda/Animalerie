package fr.treeptik.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.treeptik.model.Person;


public interface PersonRepository extends JpaRepository<Person, Long>
{
	
	// get one with animal
	@Query("SELECT DISTINCT p from Person p LEFT JOIN FETCH p.lanim a WHERE p.id=:id")
	public Person getidwithAnimal( @Param("id") Long id);
	
	// get all with animals
	@Query("SELECT DISTINCT p from Person p LEFT JOIN FETCH p.lanim a ORDER BY p.id")
	public List<Person> findAllwithAnimal();
    
}
