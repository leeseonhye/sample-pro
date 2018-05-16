package kr.co.hta.board.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import kr.co.hta.board.vo.Board;

@Repository
public class BoardDaoIbatisImpl implements BoardDao {
	@Autowired
	private SqlMapClientTemplate t;
	
	@Override
	public List<Board> getBoards() {
		return t.queryForList("getBoards");
	}

	@Override
	public void addBoard(Board board) {
		t.insert("addBoard", board);	
	}

	@Override
	public Board getBoardByNo(int boardNo) {
		return (Board) t.queryForObject("getBoardByNo", boardNo);
	}

	@Override
	public void deleteBoardByNo(int boardNo) {
		t.delete("deleteBoardByNo", boardNo);
		
	}

	
}
