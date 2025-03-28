package com.bookSystem.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookSystem.DTO.BookBasketDto;
import com.bookSystem.DTO.BookLIstDto;
import com.bookSystem.DTO.BookLoanDto;
import com.bookSystem.DTO.BookSearchDto;
import com.bookSystem.DTO.MemberDto;
import com.bookSystem.Service.BookService;
import com.bookSystem.Service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BookService bookservice;
	
	
	@GetMapping("/")
	public String home(Model model) {
		MemberDto memberDto = new MemberDto(); // 멤버 객체를 만들어 보내두었기때문에
		model.addAttribute("memberDto", memberDto);
		
		return "index";
	}
	
	@PostMapping("/signIn")
	public String login(MemberDto memberDto, HttpSession session, Model model) { // 굳이 다른 방법을 쓸 필요 없이 받아올수 있다.
		System.out.println(memberDto.getEmail());
		
			//로그인 처리를 진행하려면 service 의 메서드를 호출한다.
			//member와 관련된것은 MemberService 에서 처리한다.
			//컨트롤 쪽에서는 로그인 처리과정이 어떻게 진행되고 하는지는 전혀 몰라도 된다.
			//그냥 service 쪽 메서드를 호출하면 된다.
		boolean isSuccess = memberService.signIn(memberDto);
		
		if (isSuccess) {
			session.setAttribute("user", memberDto.getEmail());
			return "redirect:/";  // forword 말고 간단하게 하는 방식?
		}
		// 로그인 실패시 index.html 다시 돌아가기
		model.addAttribute("fail", 1);
		return "index";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/";
	}
	
	// 도서 검색부분
	
	
	@GetMapping("/bookSearch")
	public String search(Model model) {  // 도서 검색 페이지 요청
		
		model.addAttribute("bookSearchDto", new BookSearchDto());
		
		return "book/search";
	}
	
	@GetMapping("/bookSearch/result")
	public String searchResult(BookSearchDto bookSearchDto, Model model) {
		List<BookLIstDto> bookLIstDtos = bookservice.bookSearch(bookSearchDto);
		model.addAttribute("bookLIstDtos", bookLIstDtos);
		
		return "book/search";
	}
	
	
	// 도서 검색부분 끝
	
	
	// 도서 제목 클릭하여 바구니에 넣기 요청 처리
	
	@GetMapping("/basket")
	public String basket(@RequestParam int bookId, HttpSession session) {
		
		String email = (String)session.getAttribute("user");
		bookservice.myBasketSave(bookId, email);
		
		return "redirect:/bookSearch";
	}
	
	// 대출 페이지 요청 처리
	
	@GetMapping("/loans")
	public String loansPage(Model model, HttpSession session) {
		String email = (String)session.getAttribute("user");
		List<BookBasketDto> basketList = bookservice.myBasketList(email);
		
		model.addAttribute("basketList", basketList);
		
		return "book/loan";
	}
	

	@GetMapping("/loanSave")
	public String loanSave(@RequestParam("id") int id, 
			@RequestParam("bookId") int bookId, HttpSession session,Model model) {
		String email = (String)session.getAttribute("user");
		boolean hasLoan =bookservice.loanSave(id,bookId, email);
		if(hasLoan) {
			List<BookBasketDto> basketList = bookservice.myBasketList( email );
			
			model.addAttribute("basketList", basketList );
			model.addAttribute("fail",1);	
			return "book/loan";
		}
		return "redirect:/loans";
	}
	
	@GetMapping("/return")
	public String returnPage(Model model , HttpSession session) {
		String email = (String)session.getAttribute("user");
//		
		List<BookLoanDto> list = bookservice.myLoanList( email );
//		
		model.addAttribute("loanList",list);
		return "book/bookReturn";
	}
	

	
	
	@GetMapping("/returnExecute")
	public String returnExe(@RequestParam int id) {
		
		bookservice.returnEx(id);
		
		return "redirect:/return";
	}
	
	
	
	
	
	
	//변수 받아오는 세가지 방법
	// 1. request param
	// 2. modelAttribute 
	// 3. Map 
	
//	@GetMapping("/test")
//	public String main(Model model) { // ModelAndView 는 메서드안에 new를 사용해 객체 생성
//		// Model의 경우 입력매개 변수에서 변수 선언.
//		model.addAttribute("name", "곽찬양");
//		model.addAttribute("age", 30);
//		model.addAttribute("tel", "010-2343-9874");
//		model.addAttribute("address", "남아프리카 공화국");
//		
//		MemberDto memberDto= new MemberDto();
//		memberDto.setAge(29);
//		memberDto.setId("rim");
//		memberDto.setName("김은나");
//		memberDto.setTel("010-8888-0000");
//		
//		model.addAttribute("user", memberDto);
//		
//		List<String> animal = new ArrayList<>();
//		animal.add("개"); animal.add("호랑이");
//		animal.add("뱀"); animal.add("닭");
//		animal.add("토끼"); animal.add("소");
//		
//		model.addAttribute("animal", animal);
//		
//		
//		// 페이지 따로 모델(데이터)따로라 리턴이 필요없음.
//		return "test";
//	}
//	
//	@GetMapping("/test2")
//	public String test() {
//		return "test2";
//	}
	

}


/*
	스프링의 동작은 기본적으로 mvc 패턴이다.
	m : 모델 (데이터를 다루기 위한 클래스)
	v : 뷰 (화면페이지-html)
	c : 컨트롤
	
	요청 -> 컨트롤 -> 로직(서비스) -> DAO(레포지토리) -> 서비스 -> 컨트롤 -> client 
	
*/