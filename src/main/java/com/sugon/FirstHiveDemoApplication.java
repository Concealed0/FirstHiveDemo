package com.sugon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//定义到dao接口·
@MapperScan(basePackages = "com.sugon.dao.*.*")
public class FirstHiveDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstHiveDemoApplication.class, args);
	}

}
