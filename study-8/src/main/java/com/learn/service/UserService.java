package com.learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.entity.User;
import com.learn.repository.UserRepository;

// 1
@Service

public class UserService {

	// 2
	// c
	@Autowired
	private UserRepository userRepository; // a-2
//	private final UserRepository userRepository; // a

//	public UserService(UserRepository userRepository) { // b: "사장님이 뽑은 알바생을 알바생 자리에 넣음", // d: @Autowired 때문에 b는 필요 없어짐. 주석처리 후 "사장님한테 알려야함" UserRepository.java 참고 @Repository, a:final 삭제
//		this.userRepository = userRepository;
//	}

	// CRUD
	// 3
	public User saveUser(User user) { // a: User 객체 전달
		User result = null; // b
		result = userRepository.save(user); // d
		return result; // c
	}

	public List<User> getAllUsers() { // a
		List<User> result = null; // b
		result = userRepository.findAll(); // d: List의 User를 반환
		return result; // c
	}

//	public User getUserById(Long id) { // a
//		Optional<User> result = null; // b
//		return result; // c
//	}

	public User getUserById(Long id) { // a
		User result = null;
		result = userRepository.findById(id).orElse(result); // d: Long값으로 반환
		return result; // c
	}

//	public User updateUser(Long id, User userDetail) { // a, e: user를 userDatail로 변경 // Long id 매개변수 추가
//		User result = null; // b
//		result = userRepository.findById(id).map(user -> { // d: Optional when null 무시하라고, map 적용 가능
//			user.setName(userDetail.getName());
//			user.setEmail(userDetail.getEmail());
//			// 바뀌어진 값으로 반환
//			return userRepository.save(user);
//		}).orElseThrow(() -> new RuntimeException("잘못된 ID")); // 원수가 있지 않다면(ID가 틀려서 없다면)
//		return result; // c
//	}

	public User updateUser(Long id, User userDetail) { // a, e: user를 userDatail로 변경 // Long id 매개변수 추가
		User result = null; // b
//		result = userRepository.findById(id).map(user -> { // d: Optional when null 무시하라고, map 적용 가능
//			user.setName(userDetail.getName());
//			user.setEmail(userDetail.getEmail());
//			// 바뀌어진 값으로 반환
//			return userRepository.save(user);
//		}).orElseThrow(() -> new RuntimeException("잘못된 ID")); // 원수가 있지 않다면(ID가 틀려서 없다면)
		result = userRepository.findById(id).map(user -> {
			user.setName(userDetail.getName());
			user.setEmail(userDetail.getEmail());
			return userRepository.save(user); // 그 값을 user.Repository에서 save 함수를 불러 지금 셋팅된 user를 저장
		}).orElseThrow(() -> new RuntimeException("잘못된 ID")); // null이 생겼을 때만 even 함수 호출 RunTimeException을 내보냄
		return result; // c
	}

	public void deleteUser(Long id) { // a
		userRepository.deleteById(id); // b

	}

//	public boolean deleteUser(Long id) {
//		boolean result = false;
//		userRepository.deleteById(id);
//		result = true;
//		return result;
//	}

//	public boolean deleteUser(Long id) {
//		boolean result = false;
//		try {
//			userRepository.deleteById(id);
//			result = true;
//		} catch (Exception e) {
//			result = false;
//		}
//		return result;
//	}

}
