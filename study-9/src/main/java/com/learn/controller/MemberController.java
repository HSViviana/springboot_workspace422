//package com.learn.controller;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/members")
//public class MemberController {
//
//	@GetMapping
//	public String getAllMembers() {
//		String result = "getAllMembers() 호출 : ";
//		return result;
//
//	}
//
//	@PostMapping
//	public String createMember(@RequestBody String name) {
//		String result = "createMember() 호출 : " + name;
//		return result;
//
//	}
//
//	@GetMapping("/{id}")
//	public String getMemberById(@PathVariable String id) {
//		String result = "getMemberById() 호출 : " + id;
//		return result;
//
//	}
//
//	@PostMapping("/modify/{id}")
//	public String updateMember(@PathVariable String id) {
//		String result = "updateMember() 호출 : " + id;
//		return result;
//
//	}
//
//	@GetMapping("/delete/{id}")
//	public String deleteMember(@PathVariable String id) {
//		String result = "deleteMember() 호출 : " + id;
//		return result;
//	}
//}

package com.learn.controller;

import java.util.List;

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

	@GetMapping
	public List<Member> getAllMembers() {
		List<Member> result = null;
		result = memberService.getAllMembers();
		return result;

	}

	@PostMapping
	public Member createMember(@RequestBody Member member) {
//		String result = "createMember() 호출 : " + name;
		Member result = null;
		result = memberService.createMember(member);
		return result;

	}

	@GetMapping("/{id}")
	public Member getMemberById(@PathVariable String id) {
//		String result = "getMemberById() 호출 : " + id;
		Member result = null;
		result = memberService.getMemberById(id);
		return result;

	}

	@PostMapping("/modify/{id}")
	public Member updateMember(@PathVariable String id, @RequestBody Member member) {
//		String result = "updateMember() 호출 : " + id;
		Member result = null;
		result = memberService.updateMember(id, member);
		return result;

	}

	@GetMapping("/delete/{id}")
	public Member deleteMember(@PathVariable String id) {
//		String result = "deleteMember() 호출 : " + id;
		Member result = null;
		result = memberService.deleteMember(id);
		return result;
	}
}
