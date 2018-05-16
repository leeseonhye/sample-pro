package kr.co.hta.board.service;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import kr.co.hta.board.web.controllers.BoardController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:/META-INF/spring/test-root-context.xml","classpath:/META-INF/spring/test-app-context.xml"})
@Transactional
public class BoardControllerTest {

	@Autowired
	BoardController boardController;
	
	MockMvc mockMvc = null; //테스트용 브라우저만들기(spring mvc를 흉내내는 객체-컨트롤러를 실행할 수 있게)
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(boardController).build();
	}
	
	@Test
	public void testBoardController() {
		assertThat(boardController, notNullValue());
	}
	
	@Test
	public void testList() throws Exception{
		//list.do 흉내
		mockMvc.perform(get("/board/list.do")) //board/list.do실행
				.andDo(print()) //한번 실행해 보기
				.andExpect(status().isOk()) //응답이 200인지 확인
				.andExpect(view().name("board/list.jsp")) //뷰 name이 board/list.jsp인지 확인
				.andExpect(model().attributeExists("boards")); //boards가 얻어지는지 확인
	}
	
	@Test
	public void testDetail() throws Exception{
		mockMvc.perform(get("/board/detail.do").param("no", "122"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(view().name("board/detail.jsp"))
				.andExpect(model().attributeExists("board"))
				.andExpect(model().attribute("board", notNullValue()));				
	}
}









