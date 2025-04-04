package com.talk.Repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.talk.Entity.CommentEntity;

@Mapper
public interface CommentRepository {
	public int insert (CommentEntity commentEntity);
	public int delete (int id);
	public List<CommentEntity> findByBoardIdOrderIdDesc(int id);
}
