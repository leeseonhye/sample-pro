package kr.co.hta.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.hta.board.dao.UserDao;
import kr.co.hta.board.exception.SimpleBoardException;
import kr.co.hta.board.vo.User;

@Repository
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public void addNewUser(User user) {
		List<User> users = userDao.searchUsers(user.getId());
		if(!users.isEmpty()) {
			throw new SimpleBoardException("입력한 아이디가 이미 사용중입니다.");
		}
		userDao.addUser(user);
	}
	@Override
	public User getUserDetail(String userId) {
		return userDao.getUserById(userId);
	}
}
