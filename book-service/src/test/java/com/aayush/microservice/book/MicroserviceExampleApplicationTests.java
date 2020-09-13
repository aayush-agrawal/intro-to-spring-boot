package com.aayush.microservice.book;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.aayush.microservice.book.domain.Person;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@TestMethodOrder(OrderAnnotation.class)
class MicroserviceExampleApplicationTests {

	@Autowired
	private TestRestTemplate template;
	
	@Test
	void contextLoads() {
		
	}
	
	
	@Test
	@Order(1)
	void testAdd() {
		Person person = Person.builder()
					.id(1)
					.firstName("aayush")
					.lastName("agrawal")
					.age(29)
					.build();
		HttpEntity<Person> entity = new HttpEntity<>(person);
		ResponseEntity<Void> response = template.exchange("/persons", HttpMethod.POST, entity, Void.class);
		Assertions.assertEquals(200, response.getStatusCode().value());
	}
	
	@Test
	@Order(2)
	void testFindById() {
		Person person = template.getForObject("/persons/{id}", Person.class, 1);
		Assertions.assertNotNull(person);
		Assertions.assertEquals(1, person.getId());
	}
	
	@Test
	@Order(3)
	void testPut() {
		Person person = Person.builder()
					.id(1)
					.firstName("aayush")
					.lastName("agrawal")
					.age(30)
					.build();
		HttpEntity<Person> entity = new HttpEntity<>(person);
		ResponseEntity<Void> response = template.exchange("/persons", HttpMethod.POST, entity, Void.class);
		Assertions.assertEquals(200, response.getStatusCode().value());
	}
	
	@Test
	@Order(4)
	void testDelete() {
		template.delete("/persons/{id}", 1);
	}
}
