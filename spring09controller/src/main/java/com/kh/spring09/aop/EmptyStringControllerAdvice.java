package com.kh.spring09.aop;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

//@ControllerAdvice
//- AOP 개념이 적용된 새로운 도구
//- 컨트롤러를 대상으로 광범위하게 간섭이 가능
//- 예외 처리, 파라미터 변조 등이 가능

//@ControllerAdvice(annotations = {Controller.class})//Annotation으로 간섭
@ControllerAdvice(basePackages = {"com.kh.spring09.controller"})//package로 간섭
public class EmptyStringControllerAdvice {

	@InitBinder//컨트롤러 처리 전에 사전 밑작업을 할 수 있는 메소드
	public void initBinder(WebDataBinder binder) {
		//binder에 원하는 변조작업을 처리할 수 있는 도구를 등록
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
	
}



