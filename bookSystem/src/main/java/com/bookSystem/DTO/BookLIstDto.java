package com.bookSystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookLIstDto {
	private int bookId; // 검색결과 출력하고 대출 선택을 위해 
	private String bookTitle;
	private String bookAuthor;
	private String bookPublishing;
}
