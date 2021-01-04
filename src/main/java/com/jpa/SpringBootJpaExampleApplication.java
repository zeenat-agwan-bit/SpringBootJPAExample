package com.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.dao.UserRepository;
import com.jpa.entities.User;

@SpringBootApplication
public class SpringBootJpaExampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootJpaExampleApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);

		User user = new User();
		user.setName("jenny");
		user.setCity("Mumbai");

		User user1 = userRepository.save(user);
		System.out.println(user1);
	}

}
