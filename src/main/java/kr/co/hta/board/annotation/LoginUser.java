package kr.co.hta.board.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


//@Target(ElementType.TYPE) //클래스나 인터페이스
//@Target(ElementType.CONSTRUCTOR) //생성자에
//@Target(ElementType.FIELD) //변수에
//@Target(ElementType.METHOD) //메소드에
@Target(ElementType.PARAMETER) // (필수어노테이션)매개변수 어노테이션이 붙을 위치
@Retention(RetentionPolicy.RUNTIME) //(필수 어노테이션) 어느시점에 해석되게 할지 지정 runtime=>(프로그램이 실행될 때)
@Documented // (선택 어노테이션) 자바 주석 다는것과 연관된 어노테이션
public @interface LoginUser {

}
