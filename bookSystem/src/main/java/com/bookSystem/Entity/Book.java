package com.bookSystem.Entity;

import com.bookSystem.DTO.BookWriteDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
	private int book_id;
	private String book_title;
	private String book_author;
	private String book_publishing;
	private int book_year;
	
	public static Book of(BookWriteDto bookWriteDto) {
		Book book = new Book();
		book.setBook_author(bookWriteDto.getBookAuthor());
		book.setBook_publishing(bookWriteDto.getBookPublishing());
		book.setBook_title(bookWriteDto.getBookTitle());
		book.setBook_year(bookWriteDto.getBookYear());
		
		return book;
	}

	
}
