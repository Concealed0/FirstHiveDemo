package com.sugon.dao.first;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sugon.model.Person;

@Mapper
public interface PersonMapper {
    int insert(Person record);

    int insertSelective(Person record);
    
    List<Person> selectSelective(Person record);
    
    List<Person> selectAll();
}