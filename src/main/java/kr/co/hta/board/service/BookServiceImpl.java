package kr.co.hta.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.hta.board.dao.BookDao;
import kr.co.hta.board.vo.Book;
import kr.co.hta.board.vo.Criteria;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookDao bookDao;
	
	@Override
	public List<Book> searchBooks(Criteria c) {
		return bookDao.searchBooks(c);
	}
}
