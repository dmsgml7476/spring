package com.talk.DTO;

import java.time.LocalDate;

import com.talk.Entity.CommentEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentViewDto {
	
	private int id;
	private String memberId;
	private String content;
	private LocalDate writeDate;
	
	public static CommentViewDto from(CommentEntity commentEntity) {
		CommentViewDto commentViewDto = new CommentViewDto();
		commentViewDto.setId(commentEntity.getId());
		commentViewDto.setMemberId(commentEntity.getMemberId());
		commentViewDto.setContent(commentEntity.getContent());
		commentViewDto.setWriteDate(commentEntity.getWriterDate());
		
		return commentViewDto;
	}
}
