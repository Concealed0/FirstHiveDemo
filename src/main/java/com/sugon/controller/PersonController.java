package com.sugon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.sugon.model.Person;
import com.sugon.service.impl.PersonServiceImpl;

@RestController
@RequestMapping(value = "/per")
public class PersonController {

	
	@Autowired
	PersonServiceImpl personservice;
	
	@GetMapping(value="/a",produces="application/json;charset=UTF-8")
	public String ddd() {
		List<Person> all=personservice.all();
		System.out.print("fsfdasdf");
		return JSON.toJSONString(all);
		
	}
	
	@GetMapping(value="/b",produces = "application/json;charset=UTF-8")
	public String ceshi() {
		return JSON.toJSONString("dsadfsa");
	}
}
