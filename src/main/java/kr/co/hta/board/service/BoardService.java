package kr.co.hta.board.service;

import java.util.List;

import kr.co.hta.board.vo.Board;

public interface BoardService {

	List<Board> getAllBoards();
	Board getBoardDetail(int boardNo);
	void addNewBoard(Board board);
	void deleteBoard(int boardNo, String userId);
}
