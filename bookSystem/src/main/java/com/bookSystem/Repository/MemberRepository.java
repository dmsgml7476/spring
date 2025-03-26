package com.bookSystem.Repository;

import org.apache.ibatis.annotations.Mapper;

import com.bookSystem.DTO.MemberDto;

@Mapper
public interface MemberRepository {

	public String login(MemberDto memberDto);

}
