package com.talk.Repository;

import org.apache.ibatis.annotations.Mapper;

import com.talk.Entity.MemberEntity;

@Mapper
public interface MemberRepository {
	public int insert (MemberEntity memberEntity);
	
	public boolean findByMemberIdAndPassword (MemberEntity memberEntity);

}
