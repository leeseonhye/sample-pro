package kr.co.hta.board.web.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.hta.board.service.BookService;
import kr.co.hta.board.vo.Book;
import kr.co.hta.board.vo.Criteria;

@Controller
@RequestMapping("/ajax")
public class AjaxController {
		
		@Autowired
		private BookService bookService;
	
		@RequestMapping("/search.do")
		public @ResponseBody Map<String, Object> search(Criteria c){
			Map<String, Object> map = new HashMap<>();
			List<Book> books = bookService.searchBooks(c);
			//조회결과가 없으면 success에 false값 넣기
			if(books.isEmpty()) {
				map.put("success", false);
				//조회결과가 있으면 success에 true 값 넣고 items로 결과값 담기
			} else {
				map.put("success", true);
				map.put("items", books);
			}			
			return map;
		}
}
