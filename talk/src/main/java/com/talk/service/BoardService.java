package com.talk.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.talk.DTO.BoardDetailDto;
import com.talk.DTO.BoardDto;
import com.talk.DTO.BoardListDto;
import com.talk.Entity.BoardEntity;
import com.talk.Repository.BoardRepository;
import com.talk.Repository.CommentRepository;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;
	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private FileService fileService;
	
	@Value("${imgPath}")
	private String imgPath;
	
	//게시글 목록
	public List<BoardListDto> boardList(int pageNum){
		
		return null;
	}
	
	//게시글 갯수
	public int boardCount() {
		return 0;
	}
	
	//게시글 저장
	public void boardSave(BoardDto boardDto, String memberId, MultipartFile multipartFile) {
		BoardEntity boardEntity = BoardDto.to(boardDto);
		boardEntity.setMemberId(memberId);
	}
	// 게시글 삭제
	public void boardDelete(int id) {
		
	}
	//게시글 수정
	public void boardUpdate(BoardDto boardDto) {
		
	}
	//게시글 상세보기
	public BoardDetailDto boardDetail(int id) {
		return null;
	}
	//최근글
	public List<BoardListDto> boardRecent(){
		
		List<BoardEntity> boardEntities = boardRepository.findByOrderByWriteDateDesc();
		
		List<BoardListDto> boardListDtos = new ArrayList<>();
		
		for(BoardEntity board : boardEntities ) {
			BoardListDto dto = BoardListDto.from(board);
			
			boardListDtos.add(dto);
		}
		
		return boardListDtos;
	}
	//인기글
	public List<BoardListDto> boardPopular(){
		List<BoardEntity> boardEntities = boardRepository.findByOrderByHitDesc();
		
		List<BoardListDto> boardListDtos = new ArrayList<>();
		
		for(BoardEntity board : boardEntities ) {
			BoardListDto dto = BoardListDto.from(board);
			
			boardListDtos.add(dto);
		}
		
		return boardListDtos;
		
	}
}