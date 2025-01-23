package com.kh.spring09.aop;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

//@ControllerAdvice
// - AOP 개념이 적용된 새로운 도구
// - 컨트롤러를 대상으로 광범위하게 간섭이 가능
// - 예외 처리, 파라미터 변조 등이 가능


//@ControllerAdvice(annotations = ControllerAdvice.class) //import 시 annotation이 붙어있는걸로 할 것
@ControllerAdvice(basePackages = {"com.kh.spring9.controller"}) //package
public class EmptyStringControllerAdvice {
	
	@InitBinder //컨트롤러 처리 전에 사전 밑작업을 할 수 있는 메서드 
	public void initBinder(WebDataBinder binder) { //비어있으면 무조건 null로 간주하도록 규정
		//binder에 원하는 변조작업을 처리할 수 있는 도구를 등록
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true)/*empty를 null로 간주함을 의미*/); //사용자가 직접 만든 편집기를 등록
	}
}
