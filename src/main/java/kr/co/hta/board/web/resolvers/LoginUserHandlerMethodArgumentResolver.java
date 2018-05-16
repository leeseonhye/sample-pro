package kr.co.hta.board.web.resolvers;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import kr.co.hta.board.annotation.LoginUser;

//핸들러 메소드의 매개변수를 해석하는 클래스
public class LoginUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver{

	//매개변수리졸브를 적용할 수 있는 대상인지 검사하는 역할을 수행한다.
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.hasParameterAnnotation(LoginUser.class);
	}
	
	//위 supportsParameter 메소드가 true일 때만 아래 메소드가 실행됨
	//resolveArgument() 메소드가 반환하는 객체가 그 매개변수로 전달된다.
	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		
		//세션에서 로그인 유저를 꺼냄 (유저객체가 나오기 때문에 User 타입의 변수 user로 전달받음	
		return webRequest.getAttribute("LOGIN_USER", NativeWebRequest.SCOPE_SESSION); 
	}

}
