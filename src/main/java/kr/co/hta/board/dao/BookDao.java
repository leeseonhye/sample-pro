package kr.co.hta.board.dao;

import java.util.List;

import kr.co.hta.board.vo.Book;
import kr.co.hta.board.vo.Criteria;

public interface BookDao {

	List<Book> searchBooks(Criteria c);
}
