package kr.co.hta.board.web.controllers;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.co.hta.board.annotation.LoginUser;
import kr.co.hta.board.service.BoardService;
import kr.co.hta.board.vo.Board;
import kr.co.hta.board.vo.User;
import kr.co.hta.board.web.form.BoardForm;
import kr.co.hta.board.web.views.DownloadView;

@Controller
@RequestMapping("/board")
public class BoardController {
	//파일 업로드용 
	private String directory = "c:/upload/formfile"; 
	
	@Autowired
	private BoardService boardService;
	@Autowired
	private DownloadView downloadView;
	
	@RequestMapping("/list.do")
	public String list(Model model) {
		List<Board> boards = boardService.getAllBoards();
		model.addAttribute("boards", boards);
		return "board/list.jsp";
	}
	@RequestMapping("/detail.do")
	public String detail(@RequestParam("no") int boardNo, Model model) {
		model.addAttribute("board", boardService.getBoardDetail(boardNo));
		
		return "board/detail.jsp";
	}
	
	@RequestMapping("/del.do")
	public String delete(@RequestParam("no") int boardNo, @LoginUser User user) { //req에서 param에서 no를 찾아서 boardNo변수에 넣는 명령	

		boardService.deleteBoard(boardNo, user.getId()); //글번호와 로그인한 사람의 Id 서비스로 전달
		return "redirect:/board/list.do"; //jsp로 연결되는게 아니라 매핑이되야함 .do
	}
	
	@RequestMapping("/form.do")
	public String form() {
		return "board/form.jsp";
	}
	//게시글 등록
	@RequestMapping("/add.do")
	public String add(BoardForm boardForm, @LoginUser User user) throws Exception{

		Board board = new Board();
		board.setTitle(boardForm.getTitle());
		board.setNick(user.getId());
		board.setContents(boardForm.getContents());
		
		//파일 업로드
		MultipartFile upfile = boardForm.getUpfile();
		if(!upfile.isEmpty()) {
			String filename = upfile.getOriginalFilename();
			board.setFilename(filename);
			
			FileCopyUtils.copy(upfile.getBytes(), new File(directory, filename));
		}
		boardService.addNewBoard(board);
		
		return "redirect:/board/list.do";
	}
	@RequestMapping("/down.do")
	public ModelAndView download(@RequestParam("no") int boardNo) {
		ModelAndView mav = new ModelAndView();
		//디렉토리 이름과, 파일이름이 들어있는 모델을 반환하여 mav에 저장
		//다운로드뷰의 lender 메소드를 실행
		Board board = boardService.getBoardDetail(boardNo);
		mav.addObject("directory", directory);
		mav.addObject("filename", board.getFilename());
		mav.setView(downloadView);
		return mav;
	}
}
