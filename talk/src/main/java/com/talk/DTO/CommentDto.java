package com.talk.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {

	private int boardId;
	private String content;
	private String memberId;

}
