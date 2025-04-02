package com.talk.Repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.talk.Entity.BoardEntity;

@Mapper
public interface BoardRepository {

	public int insert (BoardEntity boardEntity);

	public BoardEntity findById (int id);
	
	public int delete(int id);
	
	public int update(BoardEntity boardEntity);
	
	public List<BoardEntity> findByIdBetween (Map<String, Integer> map);
	
	public int findByAllCount();
	
	public List<BoardEntity> findByOrderByWriteDateDesc();
	
	public List<BoardEntity> findByOrderByHitDesc();
	

	
}
