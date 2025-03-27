package com.bookSystem.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookSearchDto {
	private String keyword;  //검색어
	private String option;  // 검색 옵션 (제목)
	
	

}
