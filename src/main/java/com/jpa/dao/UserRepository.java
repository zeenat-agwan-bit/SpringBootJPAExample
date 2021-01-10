package com.jpa.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jpa.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	// Custom Finder Methods | Derived Query Methods(Spring Data Query Creation)
	public List<User> findByName(String city);

	public List<User> findByNameAndCity(String name, String city);

	public List<User> findByNameStartingWith(String prefix);

	public List<User> findByNameEndingWith(String suffix);

	public List<User> findByNameContaining(String words);

	public List<User> findByNameLike(String likePattern);

	/*
	 * public List<User> findByAgeLessThan(int age);
	 * 
	 * public List<User> findByAgeGreaterThan(int age);
	 * 
	 * public List<User> findByAgeGreaterThanEqual(int age);
	 * 
	 * public List<User> findByAgeIn(Collection<Integer> ages);
	 * 
	 * public List<User> findByNameOrderBy(String name);
	 */

//EXECUTING JPQL(its like HQL) AND NATIVE QUERIES (SQL)
	@Query("select u From User u") // where u is an alias
	public List<User> getAllUser();

	@Query("select u FROM User u WHERE u.name= :n") // parameterized Query
	public List<User> getUserByName(@Param("n") String name);

	@Query("select u FROM User u WHERE u.name= :n and city= :c") // parameterized Query
	public List<User> getUserByNameAndCity(@Param("n") String name, @Param("c") String city);

	// NATIVE QUERY
	@Query(value = "select * from user", nativeQuery = true)
	public List<User> getUsers();
}
