package com.springStudy1.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainControl {

	@GetMapping ("/test")  // localhost/test 이 주소의 경우에 작동,
	public String testPage() {  // 작동했을때 실행시킬 내용은 메서드로 표현
		System.out.println("adsads");
		return "hello.html";
	}

	@GetMapping("/signIn")
	public String signInPage() {
		return "signIn.html"; //  해결 했어!! 라이브리로드!!!!  그냥 하면 되!!! 이제!!!!!!!!! 고마우면 500원!!
	}
	
	@GetMapping("/")
	public String homePage() {
		return "index.html";
	}
	
	@GetMapping("/list")
	public ModelAndView listPage(@RequestParam String type) {
		System.out.println(type);
		ModelAndView mav = new ModelAndView("list.html");
//		mav.setViewName("");
		
		
		
		
		return mav;
	}
}


// 주소 : http://localhost/signIn
// 뷰 페이지 : signIn.html
//     내용 : 아이디, 비밀번호 입력 가능하게 

/*
	컨트롤 클래스의 역할 지정 = @Controller 를 클래스 위에 넣기
	
	클라이언트의 요청 처리
		GET 방식으로 주소 요청이 들어온다면 @GetMapping
		POST 방식으로 주소 요청이 들어온다면 @PostMapping
		
		@GetMapping("주소")
			@GetMapping("/list")	-> localhost/list 주소 요청 시 동작
			
		주소 요청시 실행 할 코드는 메서드로 표현 한다.
		@PostMapping("/save")
		public String boardSave(){
		
		}
		-> localhost/save 주소가 post 방식으로 요청 되는 경우 boardSave 메서드 실행
	
*/