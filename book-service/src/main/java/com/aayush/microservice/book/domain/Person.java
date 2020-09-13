package com.aayush.microservice.book.domain;

import com.aayush.microservice.book.domain.Person.Builder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Value;

@Value
@lombok.Builder(toBuilder = true, builderClassName = "Builder")
@JsonDeserialize(builder = Builder.class)
public class Person {
	
	private Integer id;
	private String firstName;
	private String lastName;
	private Integer age;

	@JsonPOJOBuilder(withPrefix = "")
	public static class Builder {
		
	}

}
