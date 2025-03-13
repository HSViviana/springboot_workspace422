package com.learn.controller;

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

import com.learn.entity.User;
import com.learn.service.UserService;


// gkgkgkgkg




// 1
@RestController
@RequestMapping("/users")
public class UserController {
	// 13
	@Autowired
	// 12
	private UserService userService; // new를 대신

	// 3
	@PostMapping

	// 2
	public User createUser(@RequestBody User user) { // a // b: @RequestBody String name, g: String name을 User user로, h:
														// String을 User로
														// 변경
		User result = null; // b
//		result = "createUser() 호출 : " + name; // d, e: d 주석처리
		result = userService.saveUser(user); // f
		return result; // c: 반환
	}

	// 5
	@GetMapping
	// 4
	public List<User> getAllUsers() { // a, // f: String을 List<User>로
		List<User> result = null; // b
//		result = "getAllUsers() 호출 : "; // d, // g: d 주석처리
		result = userService.getAllUsers(); // h
		return result; // c
	}

	// 7
	@GetMapping("/{id}")
	// 6
	public User getUserById(@PathVariable Long id) { // a
		User result = null; // b
//		result = "getUserById() 호출 : " + id; // d
		result = userService.getUserById(id);
		return result; // c
	}

	// 9
	@PutMapping("/{id}")

	// 8
	public User updateUser(@PathVariable Long id, @RequestBody User user) { // a, g: @RequestBody User user 추가
		User result = null; // b
//		result = "updateUser() 호출 : " + id; // d, e: d 주석처리
		result = userService.updateUser(id, user); // f
		return result; // c
	}

	// 11
	@DeleteMapping("/{id}")

	// 10
	public String deleteUser(@PathVariable Long id) { // a
		String result = null; // b
//		result = "deleteUser() 호출 : " + id; // d, e: d 주석처리
		result = "delete User : " + id;
		try {
			userService.deleteUser(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		result = "delete User : " + id;
//		result = "delete  User : " + id;
		return result; // c
	}

}