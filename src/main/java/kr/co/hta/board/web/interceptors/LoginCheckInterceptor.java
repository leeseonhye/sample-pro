package kr.co.hta.board.web.interceptors;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
//모든 게시판에 로그인 여부를 확인하여 게시판 못들어가게 하는 기능 설정
public class LoginCheckInterceptor implements HandlerInterceptor {

	private Set<String> urls;
	public void setUrls(Set<String> urls) {
		this.urls = urls;
	}
	//컨트롤러가 실행되기 전에 실행되는 핸들러(boolean 값 반환 => false일 때 컨트롤러들이 ㅣ실행되지 않음)
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//requestURI에 urls(app-context.xml에서 설정한 허용된 url이 있으면 true, 없으면 접근불가 false) 확인
		String requestURI = request.getRequestURI();
		if(urls.contains(requestURI)) {
			return true;
		}
		//session에 로그인 정보가 있으면 접속할 수 있게 반환값 true
		HttpSession session = request.getSession();
		if(session.getAttribute("LOGIN_USER") != null) {
			return true;
		}
		response.sendRedirect("/user/login.do?err=deny");
		return false;
	}
	//컨트롤러가 실행된 후 실행되는 핸들러
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {	}
	//항상 실행되는 핸들러 (잘 사용안함)
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {	}

}
