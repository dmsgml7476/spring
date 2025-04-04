package com.talk.DTO;

import java.time.LocalDate;
import java.util.List;

import com.talk.Entity.BoardEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDetailDto {
	private int id;
	private String title;
	private String memberId;
	private String content;
	private String fileName;
	private int hit;
	private LocalDate writeDate ;
	private List<CommentViewDto> commentList;
	
	public static BoardDetailDto of(BoardEntity boardEntity, List<CommentViewDto> commentList) {
		BoardDetailDto boardDetailDto = new BoardDetailDto();
		boardDetailDto.setId(boardEntity.getId());
		boardDetailDto.setTitle(boardEntity.getTitle());
		boardDetailDto.setMemberId(boardEntity.getMemberId());
		boardDetailDto.setContent(boardEntity.getContent());
		boardDetailDto.setFileName(boardEntity.getFileName());
		boardDetailDto.setHit(boardEntity.getHit());
		boardDetailDto.setCommentList(commentList);
		
		return boardDetailDto;
	}
}
