package com.learn.service;

import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.entity.Member;
import com.learn.repository.MemberRepository;

@Service
public class MemberService {

	// 과거에는 다음과 같이 사용, final로 설정해두고,
//	private final MemberRepository memberRepository;
//	MemberService 생성자를 호출, 매개변수로 MemberRepository
//	MemberService(MemberRepository memberRepo) {
//		this.memberRepository = memberRepo;
//	}

	@Autowired
	// new를 하지 않아도 되는 annotation, 위 방법보다 간결
//	 Class명과 보통 동일하게 변수명을 설정
	private MemberRepository memberRepository;

	private final String DELETE_FLAG = "retire";

	public List<Member> getAllMembers() {
		List<Member> resultTemp = null;
		List<Member> result = new ArrayList<>();
		resultTemp = memberRepository.findAll();

		// OPTION 1) FOR문 사용
		for (int i = 0; i < resultTemp.size(); i++) {
			Member temp = resultTemp.get(i);
			if ("active".equals(temp.getMember_status())) {
				result.add(temp);
			}
		}

		// OPTION 2) stream 사용
//		result = resultTemp.stream().filter(member -> {
//			return "active".equals(member.getMember_status());
//		}).collect(Collectors.toList());

		// OPTION 3) condition 적용
//		result = resultTemp.stream().filter(member -> {
//			boolean cond1 = "active".equals(member.getMember_status());
//			boolean cond2 = false;
//			return cond1 && !cond2;
//		}).collect(Collectors.toList());

		return result;
	}

	public Member createMember(Member member) {
		Member result = null;
		result = memberRepository.save(member);
		return result;
	}

//	public Member getMemberById(String id) {
//		// 반환값: Member
//		Member result = null;
//		return result;
//	}

	public Member getMemberById(String id) {
		// 반환값: Member
		Member result = null;
		Member emptyResult = new Member(); // null 대신에 emptyResult 빈객체 생성
		emptyResult.setName("-"); // -: 일부러 빈값 표시
		emptyResult.setPhone("-");
		emptyResult.setEmail("-");
		result = memberRepository.findById(id).orElse(emptyResult); // 있으면 db에 있는 값, 없으면 -로 표시
		return result;
	}

	public Member updateMember(String id, Member memberDetails) { // a, f: (String id)
		Member result = null; // b
		// d: 앞에서 id값을 받아오기, f: stream으로 되어 있어서 map으로 바로 변경 가능
		result = memberRepository.findById(id).map(member -> { // g
			member.setName(memberDetails.getName()); // h
			member.setPhone(memberDetails.getPhone()); // i // 내가 전달해 준 값으로 바꾸기
			return memberRepository.save(member); // j // map 함수의 return
		}).orElseThrow(() -> new RuntimeException("잘못된 ID입니다.")); // e
		return result; // c
	}

	public Member deleteMember(String id) {
		Member result = null;
		result = memberRepository.findById(id).map(member -> {
			// 6
			member.setMember_status(DELETE_FLAG);
			return memberRepository.save(member);
		}).orElseThrow(() -> new RuntimeException("잘못된 ID입니다."));

		return result;
	}
}
