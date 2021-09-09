package io.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.api.model.Person;
import io.api.services.PersonService;

@CrossOrigin
@RestController
public class PersonController {

	@Autowired
	PersonService personService;

	@GetMapping("/get")
	public List<Person> GetAllPerson() {
		List<Person> persons = new ArrayList<Person>();
		List<Person> responsePersons = new ArrayList<Person>();
		persons = personService.getAllPersons();
		for (Person person : persons) {
			if (person.isAdmin() == true) {
				responsePersons.add(person);
			}
		}
		return responsePersons;
	}

	@GetMapping("/get/{id}")
	public Person GetPersonByID(@PathVariable("id") int id) {
		List<Person> persons = personService.getAllPersons();
		Person result = null;
		for (Person person : persons) {
			if (person.getId() == id) {
				result = person;
			}
		}
		return result;
	}

	@DeleteMapping("/delete/{id}")
	public String DeletePerson(@PathVariable("id") int id) { 
		String removedPerson = personService.RemovePerson(id);
		return removedPerson;
	}

	@PostMapping("/add/{name}/{city}/{phone}/{hobby}")
	public String AddPerson(@PathVariable("name") String name, @PathVariable("city") String city,
			@PathVariable("phone") String phone, @PathVariable("hobby") String hobby) {
		Person newPerson = new Person(personService.generateUniqueId(), name, city, phone, hobby, true);
		String response = personService.AddPerson(newPerson);
		return response;
	}

	@PostMapping("/update/{ids}/{name}/{city}/{phone}/{hobby}")
	public String UpdatePerson(@PathVariable("ids") int ids, @PathVariable("name") String name,
			@PathVariable("city") String city, @PathVariable("phone") String phone,
			@PathVariable("hobby") String hobby) {
		Person toUpdated = new Person(ids, name, city, phone, hobby, true);
		String response = personService.UpdatePerson(toUpdated);
		return response;
	}


}
