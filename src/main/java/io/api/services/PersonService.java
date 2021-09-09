package io.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import io.api.model.Person;

@Service
public class PersonService {

	ArrayList<Person> persons = new ArrayList<Person>();

	public PersonService() {
		
		persons.add(new Person(generateUniqueId(), "Bharath", "vellore", "9349834983", "gaming", true));
		persons.add(new Person(generateUniqueId(), "Deepak", "vellore", "9534534623", "gaming", true));
		persons.add(new Person(generateUniqueId(), "Balaji", "Chennai", "9342523423", "chatting", true));
		persons.add(new Person(generateUniqueId(), "Krishna", "Chennai", "9353423534", "internet surfing", true));
		persons.add(new Person(generateUniqueId(), "Nanda", "Bangalore", "9352342352", "ride", true));
		persons.add(new Person(generateUniqueId(), "Arivu", "Thiruvannamalai", "9423523423", "chatting", true));
		
	}

	public List<Person> getAllPersons() {
		return persons;
	}

	public String RemovePerson(int id) {
		for (Person person : persons) {
			if (person.getId() == id) {
				person.setAdmin(false);
				return "Deleted Successfully";
			}
		}
		return "Error ";
	}

	public String AddPerson(Person newPerson) {
		try {
			persons.add(newPerson);
			return "Added";
		} catch (Exception e) {
			return "Not Added";
		}
	}
	
	public String UpdatePerson(Person toUpdatePerson) {
		try {
			int toUpdateId = toUpdatePerson.getId();
			for (Person person : persons) {
				if(person.getId() == toUpdateId) {
					person.setName(toUpdatePerson.getName());
					person.setCity(toUpdatePerson.getCity());
					person.setPhoneNo(toUpdatePerson.getPhoneNo());
					person.setHobby(toUpdatePerson.getHobby());
				}
			}
			return "Updated";
		} catch (Exception e) {
			return "Not Updated";
		}
	}
	
	   public  int generateUniqueId() {      
	        UUID idOne = UUID.randomUUID();
	        String str=""+idOne;        
	        int uid=str.hashCode();
	        String filterStr=""+uid;
	        str=filterStr.replaceAll("-", "");
	        return Integer.parseInt(str.substring(0, 6));
	    }

}
