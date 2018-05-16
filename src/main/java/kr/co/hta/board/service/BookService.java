package kr.co.hta.board.service;

import java.util.List;

import kr.co.hta.board.vo.Book;
import kr.co.hta.board.vo.Criteria;

public interface BookService {

	List<Book> searchBooks(Criteria c);
}
