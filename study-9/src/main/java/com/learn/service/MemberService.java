package com.learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.entity.Member;
import com.learn.repository.MemberRepository;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;

	public List<Member> getAllMembers() {
		List<Member> result = null;
		result = memberRepository.findAll();
		return result;

	}

	public Member createMember(Member member) {
		Member result = null;
		result = memberRepository.save(member);
		return result;

	}

	public Member getMemberById(String id) {
		Member result = null;
		result = memberRepository.findById(id).orElse(result);
		return result;

	}

	public Member updateMember(String id, Member memberDetail) {
		Member result = null;
		result = memberRepository.findById(id).map(member -> {
			member.setName(memberDetail.getName());
			member.setEmail(memberDetail.getEmail());
			return memberRepository.save(member);
		}).orElseThrow(() -> new RuntimeException("잘못된 ID입니다."));
		return result;

	}

	public Member deleteMember(String id) {
		Member result = null;
		result = memberRepository.findById(id).map(status -> {
			if ("active".equals(status.getMember_status())) {
				status.setMember_status("retire");
			} else if ("retire".equals(status.getMember_status())) {
				throw new RuntimeException("이미 탈퇴한 회원입니다.");
			}
			return memberRepository.save(status);
		}).orElseThrow(() -> new RuntimeException("Member not found"));

		return result;
	}

}
