package com.talk.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.talk.DTO.BoardDto;
import com.talk.DTO.CommentDto;
import com.talk.service.BoardService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/index")
	public String boardIndex (@RequestParam("page") int pageNum, Model model) {
		
		return null;
	}
	
	//
	@GetMapping("/write")
	public String boardWrite (HttpSession session, Model model) {
		return null;
	}
	
	@GetMapping("/writeSave")
	public String boardWrite (BoardDto boardDto, HttpSession session, Model model) {
		
		return null;
	}
	
	@GetMapping("/delete")
	public String boardDelete (@RequestParam("id") int id) {
		
		return null;
	}
	
	@GetMapping("/update")
	public String boardUpdate (BoardDto boardDto, HttpSession session) {
		return null;
	}
	
	@GetMapping("/detail")
	public String boardDetail(@RequestParam("id") int id, Model model) {
		return null;
	}
	
	@GetMapping("/updatePage")
	public String boardUpdate (BoardDto boardDto, HttpSession session, Model model) {
		return null;
	}
	

	@GetMapping("/commentSave")
	public String commentSave (CommentDto commentDto, HttpSession session) {
		return null;
	}
	
	@GetMapping("/commentDelete")
	public String commentDel (@RequestParam("id") int id, HttpSession session) {
		return null;
	}
	
}
