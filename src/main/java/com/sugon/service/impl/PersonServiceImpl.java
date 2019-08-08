package com.sugon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sugon.dao.first.PersonMapper;
import com.sugon.model.Person;
import com.sugon.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService{

	@Autowired
	PersonMapper personmapper;
	
	@Override
	public List<Person> allSelective(Person person) {
		// TODO Auto-generated method stub
		return personmapper.selectSelective(person);
	}

	@Override
	public List<Person> all() {
		// TODO Auto-generated method stub
		return personmapper.selectAll();
	}


}
