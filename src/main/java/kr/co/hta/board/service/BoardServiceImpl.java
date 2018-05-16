package kr.co.hta.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.hta.board.dao.BoardDao;
import kr.co.hta.board.dao.UserDao;
import kr.co.hta.board.exception.SimpleBoardException;
import kr.co.hta.board.vo.Board;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao boardDao;
	@Autowired
	private UserDao userDao;
	
	@Override
	public List<Board> getAllBoards() {
		return boardDao.getBoards();
	}
	@Override
	public Board getBoardDetail(int boardNo) {
		return boardDao.getBoardByNo(boardNo);
	}
	@Override
	public void addNewBoard(Board board) {
		boardDao.addBoard(board);
		//새로운 게시글을 작성할 때마다 작성한 사람의 닉으로 사용자 포인트를 적립해주는 기능이
		//필요할 수도 있기 때문에 userDao가 boardService에 같이 사용될 수 있다.
		//User user = userDao.getUserById(board.getNick());
		//user.setPoint(user.getPoint() + 5);
		//userDao.updateUser(user);	
	}
	@Override
	public void deleteBoard(int boardNo, String userId) {
		//작성자와 로그인 정보가 다를 때 exception발생 오류메시지 출력
		//게시글의 정보를 꺼내와서 거기 닉네임과 전달된 userId가 같으면 dao실행
		Board board = boardDao.getBoardByNo(boardNo);
		if(!board.getNick().equals(userId)) {
			throw new SimpleBoardException("본인이 작성한 글만 삭제할 수 있습니다.");
		}
		boardDao.deleteBoardByNo(boardNo);
	}
}
