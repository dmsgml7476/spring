package com.talk.DTO;

import com.talk.Entity.MemberEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberSignInDto {
	private String memberId;
	private String password;
	
	public static MemberEntity to(MemberSignInDto memberSignInDto) {
		MemberEntity memberEntity = new MemberEntity();
		memberEntity.setMemberId(memberSignInDto.getMemberId());
		memberEntity.setPassword(memberSignInDto.getPassword());
		
		return memberEntity;
	}
}
