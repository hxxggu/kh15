package com.kh.spring03.controller;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParameterQuizController {
	
	@RequestMapping("/cinema")
	public String cinema(int adult, int teen) {
		int total = (15000*adult) + (10000*teen);
		return "총 요금은 " + total + "원 입니다";
	}
	
	//(추가)만약에 adult나 teen 하나만 있다면?
	@RequestMapping("/cinema2")
	public String cinema2(
			@RequestParam(required=false, defaultValue="0")int adult,
			@RequestParam(required=false, defaultValue="0")int teen) {
		int total = (adult*15000) + (teen*10000);
		return "총 요금은 "+total+"원 입니다";
	}
	
	@RequestMapping("/coffee")
	public String coffee(
			@RequestParam(required=false, defaultValue="0")int americano,
			@RequestParam(required=false, defaultValue="0")int latte) {
		int total = (americano*2500) + (latte*3000);
		return "총 가격 : " + total + "원";
	}

	@RequestMapping("/score")
	public String score(String name, int kor, int eng, int mat) {
		int total = kor + eng + mat;
		double avg = total / 3d;
		return "이름 : "+name+" 총점 : "+total+"점 평균 : "+avg+"점";
	}
	
	@RequestMapping("/score2")
	public String score2(
			@RequestParam String name,
			@RequestParam int kor,
			@RequestParam int eng,
			@RequestParam int mat) {
		int total = kor+eng+mat;
		float avg = total/3f;
//		return "이름:"+name+", 총점:"+total+", 평균:"+avg;
//		return "이름 : "+name+", <br>총점 : "+total+", <br>평균 : "+avg;
		StringBuffer bf = new StringBuffer();
		bf.append("이름:"+name);
		bf.append("<br>");
		bf.append("총점:"+total);
		bf.append("<br>");
		bf.append("평균:"+avg);
		return bf.toString();
	}
	
	@RequestMapping("/subway")
	public String subway(int birth) {
		int currentYear = 2025;
		int adult=1400, teen=800, child=500;
		if(20<=currentYear-birth && currentYear-birth<=64) return adult+500+"원입니다 (보증금 포함)";
		else if(14<=currentYear-birth && currentYear-birth<=19) return teen+500+"원입니다 (보증금 포함)";
		else if(8<=currentYear-birth && currentYear-birth<=13) return child+500+"원입니다 (보증금 포함)";
		else return 500+"원입니다 (보증금 포함)";
	}
	
	@RequestMapping("/subway2")
	public String subway2(@RequestParam(required=false)String birth) {
		if(birth==null) return "나이:비공개, 요금:1400원";
		
		int birthValue = Integer.parseInt(birth);
		int year = LocalDate.now().getYear();
		int age = year-birthValue+1;
		
		int price;
		if(age<8 || age>=65) price=0;
		else if(age < 14) price=500;
		else if(age < 20) price=800;
		else price=1400;
		
		return "나이:"+age+"세, 요금:"+price+"원";
	}
	
	@RequestMapping("/sum")
	public String sum(int begin, int end) {
		int total = 0;
		for(int i=begin;i<=end;i++) {
			total += i;
		}
		return begin + "+" + end + "=" + total;
	}
	
	@RequestMapping("/sum2")
	public String sum2(
			@RequestParam int begin, @RequestParam int end) {
		int total = 0;
		for(int i=begin; i<=end; i++) total += i;
		return "합계:" + total;
	}
	
	
	@RequestMapping("/pcroom")
	public String pcroom(@RequestParam int start, @RequestParam int end) {
		int hourPrice = 1000;
		int startMin=(start/100)*60 + (start%100);
		int endMin=(end/100)*60 + (end%100);
		int hour = (endMin-startMin)/60, min = (endMin-startMin)%60;
		int totalPrice = (hourPrice*hour);
		if(min < 0) totalPrice += hourPrice;
		
		return "이용시간:"+ hour + "시간 " + min + "분 / " + "요금:" + totalPrice + "원";
	}
	
	@RequestMapping("/pcroom2")
	public String pcroom2(
			@RequestParam String start,
			@RequestParam String end) {
		LocalDate today = LocalDate.now();
		LocalTime startTime = LocalTime.parse(start);
		LocalTime endTime = LocalTime.parse(end);
		
		LocalDateTime start2, end2;
		if(startTime.isBefore(endTime)) {
			//시작 시간이 종료 시간보다 이전이라면
			start2 = LocalDateTime.of(today, startTime);
			end2 = LocalDateTime.of(today, endTime);
		} else { //시작 시간이 종료 시각 이후라면 (일이 바뀌었다면)
			start2 = LocalDateTime.of(today.minusDays(1), startTime);
			end2 = LocalDateTime.of(today, endTime);
		}
		Duration duration = Duration.between(start2, end2);
		
		long min = duration.toMinutes();
		int price = (int)(min*1000/60d);
		
		StringBuffer bf = new StringBuffer();
		bf.append("이용 시간:");
		bf.append(duration.toHoursPart());
		bf.append("시간 ");
		bf.append(duration.toMillisPart());
		bf.append("분");
		bf.append("<br>");
		bf.append("이용 요금:");
		bf.append(price);
		bf.append("원");
		return bf.toString();
	}

}
