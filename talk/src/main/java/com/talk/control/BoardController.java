package com.talk.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.talk.DTO.BoardDetailDto;
import com.talk.DTO.BoardDto;
import com.talk.DTO.BoardListDto;
import com.talk.DTO.CommentDto;
import com.talk.DTO.MemberSignInDto;
import com.talk.service.BoardService;
import com.talk.service.CommentService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/board")
public class BoardController {

    private final CommentService commentService;
	@Autowired
	private BoardService boardService;


    BoardController(CommentService commentService) {
        this.commentService = commentService;
    }
	
	// 목록
	@GetMapping("/index")
	public String boardIndex (@RequestParam("page") int pageNum, HttpSession session, Model model) {
		

		
		// 한페이지에 보여줄 게시글 가져오기
		List<BoardListDto> boardListDtos= boardService.boardList(pageNum);
		
		model.addAttribute("boardListDtos", boardListDtos);
		
		// 페이징 위해 필요한 전체 게시글 갯수 가져오기
		int totalCount = boardService.boardCount();
//		model.addAttribute("totalCount", totalCount);
		
		int totalPage= totalCount % 10==0 ? totalCount/10 : totalCount/10+1;
		int start = pageNum>5 ? pageNum-5 : 1;
		int end = start+9 > totalPage ? totalPage : start+9;
		
		model.addAttribute("page", pageNum);
		model.addAttribute("start", start);
		model.addAttribute("end", end);
		
		
		return "board/boardList";
	}
	
	//글 페이지
	@GetMapping("/write")
	public String boardWrite (HttpSession session, Model model) {
		model.addAttribute("boardDto", new BoardDto());
		
		return "board/boardWrite";
	}
	
	//저장
	@PostMapping("/writeSave")
	public String boardWrite (BoardDto boardDto, @RequestParam("imgFile") MultipartFile multipartFile, HttpSession session, Model model) {
		String memberId=(String)session.getAttribute("user");
		boardService.boardSave(boardDto, memberId, multipartFile);
		
		return "redirect:/board/index?page=1";
	}
	
	//삭제
	@GetMapping("/delete")
	public String boardDelete (@RequestParam("id") int id) {
		
		return null;
	}
	
	
	//수정
	@GetMapping("/update")
	public String boardUpdate (BoardDto boardDto, HttpSession session, Model model) {
		return null;
	}
	
	//수정 페이지	
	@GetMapping("/updatePage")
	public String boardUpdate (@RequestParam("id") int id, Model model) {
		
		BoardDetailDto boardDto = boardService.boardDetail(id);
		model.addAttribute("boardDto", boardDto);
		return "board/boardWrite";
	}
	

	
	
	
	//상세
	@GetMapping("/detail")
	public String boardDetail(@RequestParam("id") int id, HttpSession session, Model model) {
		BoardDetailDto boardDetailDto = boardService.boardDetail(id);
		model.addAttribute("boardDetailDto", boardDetailDto);
		CommentDto commentDto = new CommentDto();
		commentDto.setBoardId(id);
		model.addAttribute("commentDto" , commentDto);
		
		return "board/boardDetail";
	}
	
	
	//댓글 저장
	@PostMapping("/commentSave")
	public String commentSave (CommentDto commentDto, HttpSession session, Model model) {
		
		// 현재 로그인한 회원 아이디 필요 - 세션에서 가져오기 - 로기인하면 user라는 이름으로 저장했다.
		String memberId = (String)session.getAttribute("user");
		commentService.commentSave(commentDto, memberId);

		return "redirect:/board/detail?id=" + commentDto.getBoardId();
	}
	
	//댓글 삭제
	@PostMapping("/commentDelete")
	public String commentDel (@RequestParam("id") int id, String boardId,HttpSession session) {
		commentService.commentDelete(id);
		System.out.println("삭제 잡히는 지 확인");
		return "redirect:/board/detail?id=" + boardId;
	}
	
}
