package com.bookSystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookSystem.DTO.MemberDto;
import com.bookSystem.Repository.MemberRepository;

@Service
public class MemberService {
	
	@Autowired
	private MemberRepository memberRepository;

	public boolean signIn(MemberDto memberDto) {
		// 로그인이 성공하면 true, 실패하면 false 반환

		String email = memberRepository.login(memberDto);
		
		System.out.println(email);  // 아이디 또는 비밀번호 틀리면 null
		if(email==null)
			return false;
		return true;
	}

}
