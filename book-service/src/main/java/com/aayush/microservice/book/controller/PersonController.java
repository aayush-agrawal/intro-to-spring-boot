package com.aayush.microservice.book.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aayush.microservice.book.domain.Person;
import com.aayush.microservice.book.repository.PersonRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/persons")
public class PersonController {

	private final PersonRepository personRepository;
	
	@GetMapping(value = "/{id}")
	public Optional<Person> findById(@PathVariable int id) {
		return personRepository.findById(id);
	}
	
	@GetMapping
	public List<Person> findAll() {
		return personRepository.findAll();
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable int id) {
		personRepository.delete(id);
	}
	
	
	@PostMapping
	public void add(@RequestBody Person person) {
		personRepository.add(person);
	}
	
	@PutMapping
	public void update(@RequestBody Person person) {
		personRepository.update(person);
	}
}
