package com.springStudy1.control;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springStudy1.DTO.School;
import com.springStudy1.DTO.User;
import com.springStudy1.service.SchoolService;
import com.springStudy1.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainControl {

	@Autowired
	private SchoolService schoolService;
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping ("/test")  // localhost/test 이 주소의 경우에 작동,
	public String testPage() {  // 작동했을때 실행시킬 내용은 메서드로 표현
		System.out.println("adsads");
		return "hello.html";
	}

	@GetMapping("/signIn")
	public String login() {
		return "signIn";
	}
	
	@PostMapping("/signIn")
	public String login(@RequestParam("id") String id, @RequestParam("pw") String pw,
			HttpSession session) {
		//  매개변수를 통해 session 객체 가져오기 
		boolean isSuccess = userService.loginChk(id, pw);
		if( isSuccess )
			session.setAttribute("user", id);
		
		return "index";
	}
	
	@GetMapping("/signUp")
	public String join() {
		return "signUp";
	}
	@PostMapping("/signUp")
	public String joinSave(@ModelAttribute User user) {
		
		System.out.println(user.getUserLike());
		
		userService.save(user);
		
		
		return "index"; // 회원가입 저장하고 첫페이지 돌려 보내기
	}
	
	// 정보수정 화면
	@GetMapping("/userUpdate")
	public ModelAndView memberUpdate(HttpSession session) {
		ModelAndView mav = new ModelAndView("memberModify");
		
		// 현재 로그인한 회원의 정보를 가져와서 페이지에 출력하기
		
		String id = (String)session.getAttribute("user"); // 로그인한 아이디
		User info = userService.userDetail(id);
		mav.addObject("info", info);  // addObject 회원정보 모델앤뷰에 저장해야 뷰에 출력
		
		return mav;
	}
	
	@PostMapping ("/userUpdate")
	public String userUpdate(@RequestParam Map<String, String> param) {
		// imput 태그의 name이 key, input 태그에 작성한 내용이 value
		// map에 저장된다.
		
		System.out.println(param.get("id"));
		
		userService.update(param);
		
		return "index";
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "index";
	}
	
	
	@GetMapping("/")
	public String homePage() {
		return "index";
	}
	
	@GetMapping("/list")
	public ModelAndView listPage(@RequestParam String type) {
		System.out.println(type);
		ModelAndView mav = new ModelAndView("list");
		//mav.setViewName("");
		
		// 클라이언트가 요청한 유치원, 초등학교, 중학교, 고등학교 에 대해 조회 하기 위해
		// service클래스 객체 에 넘겨주고  필요한 데이터를 받아서  뷰페이지와 함께 클라이언트에게전달
		
		List<School> list = schoolService.typeSelect(type);
		mav.addObject("list",list); // ModelAndView에 저장
		
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