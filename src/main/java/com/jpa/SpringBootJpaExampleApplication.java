package com.jpa;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

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
		/*
		 * // User user = new User(); // user.setName("jenny"); //
		 * user.setCity("Mumbai"); // // User user1 = userRepository.save(user); //
		 * System.out.println(user1); // Create object of User User user1 = new User();
		 * user1.setName("zeenu"); user1.setCity("hyd");
		 * 
		 * User user2 = new User(); user2.setName("yusu"); user2.setCity("ind"); //
		 * Saving Single USer // User res = userRepository.save(user2); // Save Multiple
		 * objects List<User> users = List.of(user1, user2); Iterable<User> res =
		 * userRepository.saveAll(users); res.forEach(user -> {
		 * System.out.println(user); });
		 */
		// UPDATE/EDIT
//		Optional<User> optional = userRepository.findById(3);
//		User user = optional.get();// if no such data present it will give NoSuchElementException
//		user.setName("mishi");
//		User res = userRepository.save(user);
//		System.out.println(res);

		// HOW TO GET DATA
		// findById(id)-return optional Containing ur data
		// Iterable<User> itr = userRepository.findAll();
		/*
		 * itr.forEach(new Consumer<User>() {
		 * 
		 * @Override public void accept(User t) { System.out.println(t); } });
		 */

		// itr.forEach(use ->{ System.out.println(use);});

		// DELETE operation(by id)
		/*
		 * userRepository.deleteById(2); System.out.println("deleted...");
		 */
		// Delete All
		Iterable<User> alIterable = userRepository.findAll();
		alIterable.forEach(use -> {
			System.out.println(use);
		});
		userRepository.deleteAll(alIterable);
	}

}
