package edu.douglaslima.spring.apirest.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.beans.factory.annotation.Autowired;

import edu.douglaslima.spring.apirest.model.User;
import edu.douglaslima.spring.apirest.repository.UserRepository;

import java.util.List;

@RestController
public class UserController {

	@Autowired
	private UserRepository repository;
	
	private static Long SEQUENCE = 0L;
	
	@GetMapping("/users")
	public List<User> getUsers() {
		this.repository.save(new User("User " + ++SEQUENCE, "123123"));
		return this.repository.findAll();
	}
	
	@GetMapping("/users/getUser/{id}")
	public User getUser(@PathVariable("id") Long id) {
		return this.repository.findById(id);
	}
	
	@GetMapping("/users/delete/{id}")
	public void delete(@PathVariable("id") Long id) {
		this.repository.deleteById(id);
	}
	
}
