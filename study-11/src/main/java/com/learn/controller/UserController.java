package com.learn.controller;

//import java.util.HashMap;
import java.util.List;
//import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.service.UserService;
import com.learn.vo.UserVO;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	// 함수 선언 후 반환값
	public List<UserVO> getAllUsers() {
		List<UserVO> result = null;
//		Map<String, Object> elem1 = new HashMap<>();
//		elem1.put("name", name);
//		Map<String, Object> elem2 = new HashMap<>();
//		elem2.put("age", age);
//		result = new ArrayList<>();
//		result.add(elem1);
//		result.add(elem2);

		result = userService.getAllUsers();
		return result;
	}

	@PostMapping
	public String createUser(@RequestBody UserVO userVO) {
		String result = null;
//		Map<String, Object> elem = new HashMap<>();
//		elem.put("name", userName);
//		result = elem;
		int cnt = userService.createUser(userVO);
		result = "Result : " + cnt;
		return result;
	}

	@GetMapping("/{id}")
	public UserVO getUserById(@PathVariable Long id) {
		UserVO result = null;
//		Map<String, Object> elem = new HashMap<>();
//		elem.put("id", id);
//		result = elem;
		result = userService.getUserById(id);
		return result;

	}

	@PostMapping("/{id}")
	public String updateUser(@PathVariable Long id, @RequestBody UserVO userVO) {
		String result = null;
//		Map<String, Object> elem = new HashMap<>();
//		elem.put("id", id);
//		elem.put("name", name);
//		result = elem;
		int cnt = userService.updateUser(id, userVO);
		result = "Update : " + cnt;
		return result;
	}

	@PostMapping("/delete")
	public String deleteUser(@RequestBody UserVO userVO) {
		String result = null;
//		Map<String, Object> elem = new HashMap<>();
//		elem.put("id", id);
//		result = elem;
		int cnt = userService.deleteUser(userVO.getId());
		result = "Delete : " + cnt + " (" + userVO.getId()+ ")";
		return result;
	}

}