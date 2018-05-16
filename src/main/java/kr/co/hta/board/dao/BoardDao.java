package kr.co.hta.board.dao;

import java.util.List;

import kr.co.hta.board.vo.Board;

public interface BoardDao {
	
	List<Board> getBoards();
	void addBoard(Board board);
	Board getBoardByNo(int boardNo);
	void deleteBoardByNo(int boardNo);
}
