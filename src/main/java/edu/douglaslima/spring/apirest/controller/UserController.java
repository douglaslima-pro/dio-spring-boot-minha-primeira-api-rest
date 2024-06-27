package edu.douglaslima.spring.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.douglaslima.spring.apirest.model.User;
import edu.douglaslima.spring.apirest.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository repository;

	@PostMapping("/add")
	public void addUser(@RequestBody User user) {
		this.repository.save(new User(user.getLogin(), user.getPassword()));
	}
	
	@GetMapping("/get")
	public List<User> getUsers() {
		return this.repository.findAll();
	}
	
	@GetMapping("/get/{id}")
	public User getUser(@PathVariable Long id) {
		return this.repository.findById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		this.repository.deleteById(id);
	}
	
	@PutMapping("/update")
	public void updateUser(@RequestBody User user) {
		this.repository.update(user);
	}
	
}
