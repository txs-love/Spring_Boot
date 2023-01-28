package com.example.springboot;

import com.example.springboot.demo.Dog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes=Application.class)
class ApplicationTests {
	@Autowired
	    private Dog dog;
	@Test
	void contextLoads() {
    //		 System.out.println(dog);
	}
}
