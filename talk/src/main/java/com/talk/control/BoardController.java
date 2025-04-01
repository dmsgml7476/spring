package com.talk.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.talk.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;

}
