package com.sugon.redis;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisDemo {

	@Autowired
	RedisTemplate<String, String> redistemplate;

	@Test
	public void test01() {
		ValueOperations<String, String> operations = redistemplate.opsForValue();
		// 存入key-value
		operations.set("hello", "1211", 600, TimeUnit.SECONDS);
		operations.set("age", "12", 600, TimeUnit.SECONDS);
		// 根据key取出Value
		Object age = operations.get("age");
		System.out.println("age:" + age);
		// 追加
		operations.append("age", "30");
		// 获得并修改
		operations.getAndSet("age", "40");
		Object age1 = operations.get("age");
		System.out.println("修改后：" + age1);
	}

	@Test
	public void test02() {
		ValueOperations<String, String> operations = redistemplate.opsForValue();
		String a = operations.get("log");
		System.out.println(a);
	}

}
