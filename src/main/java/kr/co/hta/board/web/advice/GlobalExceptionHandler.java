package kr.co.hta.board.web.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import kr.co.hta.board.exception.SimpleBoardException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	//컨트롤러 실행 도중에 SimpleBoardException이 발생했다면 아래 메소드 실행
	@ExceptionHandler(SimpleBoardException.class)
	public String handleException (SimpleBoardException ex){
		return "error/500.jsp";
	}
	//simple예외발생 외에 예외들을 받는 메소드 실행
	@ExceptionHandler(Exception.class)
	public String handleException (Exception ex){
		return "error/500.jsp";
	}
}
