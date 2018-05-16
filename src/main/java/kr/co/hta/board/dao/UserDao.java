package kr.co.hta.board.dao;

import java.util.List;

import kr.co.hta.board.vo.User;

public interface UserDao {
	void addUser(User user);
	User getUserById(String userId);
	List<User> searchUsers(String userId);
}
