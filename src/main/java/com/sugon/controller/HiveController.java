package com.sugon.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

@RestController
@RequestMapping(value="/hive")
public class HiveController {

	
	@Autowired
	@Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;
	
	@ResponseBody
	@RequestMapping("/a")
	 public String list() {
    	System.out.println("-----执行hive-----------");
        String sql = "select * from employee";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        System.out.println(JSON.toJSONString(list));
        return JSON.toJSONString(list);
    }

}
