package com.bookSystem.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookSystem.DTO.BookLIstDto;
import com.bookSystem.DTO.BookSearchDto;
import com.bookSystem.DTO.BookWriteDto;
import com.bookSystem.Entity.Book;
import com.bookSystem.Repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	
	public void bookSave(BookWriteDto bookWriteDto) {
		Book book = Book.of(bookWriteDto);
		bookRepository.save(book);
	}
	
	public List<BookLIstDto> bookSearch(BookSearchDto bookSerchDto) {
		List<BookLIstDto> bookLIstDtos = new ArrayList<>();
		
		List<Book> books = bookRepository.findByAll(bookSerchDto);
		
		for (Book book : books) {
			BookLIstDto bookLIstDto = new BookLIstDto(
					book.getBookId(), book.getBookTitle(), book.getBookAuthor(), book.getBookPublishing()
					);
			bookLIstDtos.add(bookLIstDto);
		
		}
		
		return bookLIstDtos;
	}
}
