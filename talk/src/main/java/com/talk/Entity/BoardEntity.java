package com.talk.Entity;

import java.time.LocalDate;

import com.talk.DTO.BoardDetailDto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardEntity {
	private int id;
	private String title;
	private String memberId;
	private String content;
	private String fileName;
	private int hit;
	private LocalDate writeDate;

}
