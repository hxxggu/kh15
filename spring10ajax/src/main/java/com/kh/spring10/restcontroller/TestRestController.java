package com.kh.spring10.restcontroller;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin // 비동기 통신 제한 해제, 아무나 접근하는 것을 막음
@CrossOrigin(origins = {"http://127.0.0.1:5500"}) // 선택적 해제 : 내가 지정한 주소만 접근을 허용함 (좀더 보안에 좋음)
@RestController
@RequestMapping("/test")
public class TestRestController {
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello Spring Boot";
	}
	
	@GetMapping("/dice")
	public int dice() {
		Random r = new Random();
		return r.nextInt(6)+1;
	}
	
	@GetMapping("/subway")
	public int subway(@RequestParam int birth) {
		int age = LocalDate.now().getYear()-birth+1;
		
		if(20<=age && age<=64) return 1400;
		else if(14<=age && age<=19) return 1000;
		else if(8<=age && age<=13) return 800;
		else return 500;
	}
}
