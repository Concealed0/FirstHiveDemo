package com.sugon.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.sugon.model.Person;
import com.sugon.service.impl.PersonServiceImpl;

@Controller
@RequestMapping(value = "/test")
public class HelloTest {

	@Autowired
	PersonServiceImpl personservice;
	
	@ResponseBody
	@RequestMapping(value="/ddd",produces="application/json;charset=UTF-8")
	public String ddd() {
		List<Person> all=personservice.all();
		return JSON.toJSONString(all);
		
	}
	
	@ResponseBody
	@RequestMapping(value="/hello",produces = "application/json;charset=UTF-8")
	public String ceshi() {
		return JSON.toJSONString("dsadfsa");
	}
}
