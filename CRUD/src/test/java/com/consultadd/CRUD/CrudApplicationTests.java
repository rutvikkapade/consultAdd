package com.consultadd.CRUD;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class CrudApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void printStuff(){
		BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
		System.out.println(passwordEncoder.encode("root"));
	}
}
