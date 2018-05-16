package kr.co.hta.board.service;

import kr.co.hta.board.vo.User;

public interface UserService {
	
	void addNewUser(User user);
	User getUserDetail(String userId);
}
