package com.talk.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.talk.DTO.MemberSignInDto;
import com.talk.DTO.MemberSignUpDto;
import com.talk.service.BoardService;

@Controller
public class MainController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/")
	public String home (Model model) {
		
		// 최근글 5개 가져오기
		model.addAttribute("recentList", boardService.boardRecent());
		// 인기글 5개 가져오기
		model.addAttribute("popularList", boardService.boardPopular());
		
		model.addAttribute("memberSignInDto", new MemberSignInDto());
		model.addAttribute("memberSignUpDto", new MemberSignUpDto());
		
		return "index";
	}
	

}
