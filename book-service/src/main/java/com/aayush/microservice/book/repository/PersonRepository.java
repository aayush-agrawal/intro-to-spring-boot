package com.aayush.microservice.book.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.aayush.microservice.book.domain.Person;

@Repository
public class PersonRepository {

	private final List<Person> persons = new ArrayList<>();
	
	public Optional<Person> findById(Integer id) {
		return persons.stream()
					.filter(person -> person.getId().equals(id))
					.findFirst();
	}
	
	public List<Person> findAll() {
		return persons;
	}
	
	public void delete(Integer id) {
		persons.removeIf(person -> person.getId().equals(id));
	}
	
	public void add(Person person) {
		persons.add(person);
	}
	
	public void update(Person person) {
		persons.removeIf(entity -> person.getId().equals(entity.getId()));
		persons.add(person);
	}
}
