package fr.treeptik.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.treeptik.model.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
	
	// get one with person
	@Query("SELECT a from Animal a LEFT JOIN FETCH a.person p WHERE a.id=:id")
	public Animal getidwithPerson( @Param("id") Long id);
	
	// get all with persons
	@Query("SELECT DISTINCT a from Animal a LEFT JOIN FETCH a.person p ORDER BY a.id")
	public List<Animal> findAllwithPerson();

}
