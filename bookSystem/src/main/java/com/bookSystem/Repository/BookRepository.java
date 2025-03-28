package com.bookSystem.Repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bookSystem.DTO.BookSearchDto;
import com.bookSystem.Entity.Book;
import com.bookSystem.Entity.BookUse;
import com.bookSystem.Entity.MyBasket;


@Mapper
public interface BookRepository {
	// 책등록메서드
	public int save(Book book);
	
	// 책 검색
	public List<Book> findByAll(BookSearchDto bookSearchDto);
	
	// 책 장바구니에 넣기 - 대여 하고 싶은 도서 찜!!!!
	// xml 에서 파라미터 자바 컬렉션(map,List)이런 것들이면 안적어도 된다. 그대신 키넣기
	// 맵 key: member_id -> mid, book_id -> bid
	public int basketSave(Map<String, Integer> my);
	
	
	// 대출 메뉴 클릭시 장바구니 테이블에 있는 도서목록 가져오기
	public List<MyBasket> selectBasket(int memberId);
	
	// 대출 목록에 책 정보를 출력해야 하므로 mybasket 테이블에 있는
	// book_id 를 통해 책 정보 조회하기, 하나씩 가져올거야!!!
	public Book findById(int bookId);
	
	public int deleteBasket(int id);
	
	// 장바구니 목록에 대여 클릭시 book_user에 저장되게 하기
	public int loanInsert(Map<String, Integer> info);

	//반납 관련
	public List<BookUse> findByMyLoan(int memberId);
	
	public int returnEx(int id);
	
//	public BookUse findByMyLoan(int memberId);
	

}
