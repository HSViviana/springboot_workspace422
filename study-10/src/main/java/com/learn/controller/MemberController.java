//package com.learn.controller;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/members")
//public class MemberController {
//
//	@GetMapping // 주소와 연결
//	// JSON이라고 가정, <key는 무조건 String, 다음은 뭐가 들어갈지 몰라 Object>, getAllMembers는 여러명이라
//	// List로 묶음
//	public List<Map<String, Object>> getAllMembers() {
//		// 반환값인 List<Map<String, Object>>가 result, 현재 List는 interface, new
//		// ArrayLIst<>()로 빈 리스트 만들기
//		List<Map<String, Object>> result = new ArrayList<>();
//		// HashMap<>(): key, value이지만 입력 순서 없는 것
//		Map<String, Object> elem1 = new HashMap<>();
//		elem1.put("name", "member1");
//		elem1.put("email", "member1@test.com");
//
//		Map<String, Object> elem2 = new HashMap<>();
//		elem2.put("name", "member2");
//		elem2.put("email", "member2@test.com");
//
//		result.add(elem1);
//		result.add(elem2);
//
//		return result;
//	}
//
//	@PostMapping
//	public Map<String, Object> createMember() { // a form-data형
//		Map<String, Object> result = new HashMap<>(); // b
//		result.put("name", "createMember"); // d
//		result.put("email", "create@test.com"); // e
//		return result; // c
//	}
//
//	@GetMapping("/{id}")
//	// a: 반환값은 JSON, @PathVariable: "/{id}"
//	public Map<String, Object> getMemberById(@PathVariable(name = "id") String id) {
//		Map<String, Object> result = new HashMap<>(); // b
//		result.put("name", id); // d
//		result.put("email", "memId@test.com"); // e
//		return result; // c
//	}
//
//	@PostMapping("/modify/{id}")
//	public Map<String, Object> updateMember(@PathVariable String id) {
//		Map<String, Object> result = new HashMap<>(); // b
//		result.put("name", id); // d
//		result.put("email", "memUpdate@test.com"); // e
//		return result; // c
//	}
//
//	@GetMapping("/delete/{id}")
//	public Map<String, Object> deleteMember(@PathVariable String id) {
//		Map<String, Object> result = new HashMap<>(); // b
//		result.put("name", id); // d
//		result.put("member_status", "retire"); // e
//		return result; // c
//
//	}
//}

package com.learn.controller;

import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;
//import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.entity.Member;
import com.learn.service.MemberService;

@RestController
@RequestMapping("/members")
public class MemberController {
	@Autowired
	private MemberService memberService;

	@GetMapping // 주소와 연결
	// JSON이라고 가정, <key는 무조건 String, 다음은 뭐가 들어갈지 몰라 Object>, getAllMembers는 여러명이라
	// List로 묶음S
	public List<Member> getAllMembers() {
		// 반환값인 List<Map<String, Object>>가 result, 현재 List는 interface, new
		// ArrayLIst<>()로 빈 리스트 만들기
		List<Member> result = new ArrayList<>();
//		// HashMap<>(): key, value이지만 입력 순서 없는 것
//		Map<String, Object> elem1 = new HashMap<>();
//		elem1.put("name", "member1");
//		elem1.put("email", "member1@test.com");
//
//		Map<String, Object> elem2 = new HashMap<>();
//		elem2.put("name", "member2");
//		elem2.put("email", "member2@test.com");
//
//		result.add(elem1);
//		result.add(elem2);

		result = memberService.getAllMembers();

		return result;
	}

	@PostMapping
	public Member createMember(@RequestBody Member member) { // a
		Member result = null; // b
//		result.put("name", "createMember"); // d
//		result.put("email", "create@test.com"); // e
		result = memberService.createMember(member);
		return result; // c
	}

	@GetMapping("/{id}")
	// a: 반환값은 JSON, @PathVariable: "/{id}"
//	public Map<String, Object> getMemberById(@PathVariable(name = "id") String id) {
//		Map<String, Object> result = new HashMap<>(); // b
//		result.put("name", id); // d
//		result.put("email", "memId@test.com"); // e
//		return result; // c
//	}

	public Member getMemberById(@PathVariable(name = "id") String id) {
		Member result = null; // b
//		result.put("name", id); // d
//		result.put("email", "memId@test.com"); // e
		result = memberService.getMemberById(id); // c
		return result;
	}

//	@PostMapping("/modify/{id}")
//	public Map<String, Object> updateMember(@PathVariable String id) {
//		Map<String, Object> result = new HashMap<>(); // b
//		result.put("name", id); // d
//		result.put("email", "memUpdate@test.com"); // e
//		return result; // c
//	}

	@PostMapping("/modify/{id}")
	// 결과는 수정된 Member로, @RequestBody: JSON
	public Member updateMember(@PathVariable String id, @RequestBody Member member) {
		Member result = null; // b
//		result.put("name", id); // d
//		result.put("email", "memUpdate@test.com"); // e
		result = memberService.updateMember(id, member);
		return result; // c
	}

	@GetMapping("/delete/{id}")
	public Member deleteMember(@PathVariable String id) {
		Member result = null; // b
//		result.put("name", id); // d
//		result.put("member_status", "retire"); // e
		result = memberService.deleteMember(id);
		return result; // c

	}
}