package com.bookSystem.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bookSystem.Service.BookService;

@Controller
public class AdminController {
	
	@Autowired
	private BookService bookService;

}
