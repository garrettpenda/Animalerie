package fr.treeptik.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Person")
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String name;
	
	private String lastname;
	
	private String country;
	
	// avec lazy, on ne récupere pas les données des autres tables via les requetes automatiques pour éviter les effets de bords.
	// il faut donc definir une requete spécifique pour récuperer les animaux
	@OneToMany(cascade={CascadeType.REMOVE,CascadeType.PERSIST}, mappedBy="person") 
	private List<Animal> lanim = new ArrayList<Animal>();
	
	// mettre un set plutot qu'une list en cas de manytomany
	// bien definir le equals si c'est le cas

	// cascade définit les relations lors des modifications
	// cascade a eviter en manytomany ou en manytoone
	
	// constructeurs
	
	public Person(){};
	
	public Person( String name,String lastname, String country){
		this.name = name;
		this.country = country;
		this.lastname = lastname;
	}
	
	// getter et setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public List<Animal> getLanim() {
		return lanim;
	}

	public void setLanim(List<Animal> lanim) {
		this.lanim = lanim;
	}
	
	public void addAnimal( Animal animal) {
		 lanim.add(animal);
	}
	
	// equals et hashcode


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lanim == null) ? 0 : lanim.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lanim == null) {
			if (other.lanim != null)
				return false;
		} else if (!lanim.equals(other.lanim))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
	// to string
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", lastname=" + lastname + ", country=" + country + ", lanim="
				+ lanim + "]";
	}
	
}
