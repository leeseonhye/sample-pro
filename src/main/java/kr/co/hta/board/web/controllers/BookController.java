package kr.co.hta.board.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.hta.board.service.BookService;
import kr.co.hta.board.vo.Book;
import kr.co.hta.board.vo.Criteria;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping("/form.do")
	public String form() {
		return "book/form.jsp";
	}
	
	@RequestMapping("/search.do")
	public String search(Criteria search, Model model) {
		List<Book> books = bookService.searchBooks(search);
		model.addAttribute("books", books);
		return "book/result.jsp";
	}
}
