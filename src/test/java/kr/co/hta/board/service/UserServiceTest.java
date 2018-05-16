package kr.co.hta.board.service;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import kr.co.hta.board.exception.SimpleBoardException;
import kr.co.hta.board.vo.User;

@RunWith(SpringJUnit4ClassRunner.class) // 단위테스트 실행 시 도움을 주는 헬퍼클래스
@ContextConfiguration(locations="classpath:/META-INF/spring/test-root-context.xml") //스프링컨테이너 생성
@Transactional //테스트 후 insert, update 실행했던 테스트들을 rollback한다
public class UserServiceTest {
	@Autowired
	UserService userService;
	
	@Test
	public void testConfig() {
		assertThat(userService, notNullValue()); //null이 아닌지 확인
	}
	@Test(expected=SimpleBoardException.class) //SimpleBoardException 예외발생하는지 test
	public void testDuplicateUserAdd() {
		User user = new User();
		user.setId("hong");
		user.setPwd("zxcv1234");
		user.setName("홍길동");
		
		userService.addNewUser(user);
	}
	
	@Test
	public void testAddNewUser() {
		User user = new User();
		user.setId("moon");
		user.setPwd("zxcv1234");
		user.setName("문재인");
		
		userService.addNewUser(user);
		
		User saveUser = userService.getUserDetail(user.getId());
		assertThat(saveUser, notNullValue());
	}
}
