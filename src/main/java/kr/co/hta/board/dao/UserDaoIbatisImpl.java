package kr.co.hta.board.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import kr.co.hta.board.vo.User;
@Repository
public class UserDaoIbatisImpl implements UserDao {
	@Autowired
	private SqlMapClientTemplate t;
	
	@Override
	public void addUser(User user) {
		t.insert("addUser", user);
	}

	@Override
	public User getUserById(String userId) {
		return (User) t.queryForObject("getUserById", userId);
	}

	@Override
	public List<User> searchUsers(String userId) {
		return t.queryForList("searchUsers", userId);
	}

}
