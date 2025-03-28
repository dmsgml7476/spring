package com.bookSystem.DTO;

import java.time.LocalDate;

import com.bookSystem.Entity.Book;
import com.bookSystem.Entity.BookUse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookLoanDto {
	private int id;
	private String book_title;
	private String book_author;
	private LocalDate loan_date;
	
	public static BookLoanDto of(BookUse bookUse, Book book) {
		BookLoanDto bookLoanDto = new BookLoanDto();
		bookLoanDto.setBook_author( book.getBook_author());
		bookLoanDto.setBook_title( book.getBook_title());
		bookLoanDto.setId( bookUse.getId());
		bookLoanDto.setLoan_date( bookUse.getLoan_date());
		return bookLoanDto;
	}
}
