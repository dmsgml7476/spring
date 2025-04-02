package com.talk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talk.DTO.CommentDto;
import com.talk.Repository.CommentRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;
	
	public void commentSave(CommentDto commentDto) {
	
	}
	
	public void commentDelete (int id) {
		
	}
	
}
