package com.sugon.service;

import java.util.List;

import com.sugon.model.Person;

public interface PersonService {

	List<Person> allSelective(Person person);
	
	List<Person> all();
}
