package com.bookSystem.Entity;

import com.bookSystem.DTO.BookWriteDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
	private int bookId;
	private String bookTitle;
	private String bookAuthor;
	private String bookPublishing;
	private int bookYear;
	
	public static Book of(BookWriteDto bookWriteDto) {
		Book book = new Book();
		book.setBookAuthor(bookWriteDto.getBookAuthor());
		book.setBookPublishing(bookWriteDto.getBookPublishing());
		book.setBookTitle(bookWriteDto.getBookTitle());
		book.setBookYear(bookWriteDto.getBookYear());
		
		return book;
	}

	
}
