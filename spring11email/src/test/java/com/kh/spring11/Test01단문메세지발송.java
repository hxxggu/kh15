package com.kh.spring11;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.Format;
import java.util.Properties;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootTest
public class Test01단문메세지발송 {

	// 이메일(E-mail)이 무엇인가?
	// - SMTP(Simple Mail Transfer Protocol)에서 주고받는 메세지
	// - 문자(SMS)와 비슷한 통신방식을 가진다
	// - SMTP 서버끼리 메세지를 주고받아야 하기 때문에 SMTP 서버 구축이 필요
	// - 직접 서버를 구축하지 않고 Gmail의 이메일 서비스를 이용
	// - 2단계 인증 및 앱 비밀번호 생성이 필요
	
	// 구현 순서
	// [1] 이메일 전송 도구 생성
	// [2] 이용할 서비스(Gmail) 정보 입력
	// [3] 메세지 생성
	// [4] 메세지 전송
	@Test
	public void test() {
		System.out.println("단문 메세지 발송 테스트 시작");
		
		//[1]
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		
		//[2] 
		sender.setHost("smtp.gmail.com"); //이용할 업체의 별칭 또는 IP(위치 정보)
		sender.setPort(587); //이용할 업체의 서비스 실행 번호
		sender.setUsername("kh15.semi.final"); //이용할 업체의 사용자 계정이름
		sender.setPassword("muxixbwwvcmvmfim"); //이용할 업체의 사용자 계정 비밀번호(구글은 앱 비밀번호)
		
		Properties props = new Properties(); //추가 정보 저장소 생성
		props.setProperty("mail.smtp.auth", "true"); //인증 후 이용 설정
		props.setProperty("mail.smtp.debmg", "true"); //디버깅 허용 설정
		props.setProperty("mail.smtp.starttls.enable", "true"); //TLS 사용 설정
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2"); //TLS 버전 설정
		props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com"); //신뢰할 수 있는 주소로 등록
		sender.setJavaMailProperties(props); //추가 정보 설정
		
		//[3]
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("kh15.semi.final@gmail.com");//수신인(여러개 가능)
		//message.setCc(null);//참조인(여러개 가능)
		//message.setBcc(null);//숨은 참조인(여러개 가능)
		
		// 인증 번호 생성
		Random r = new Random();
		int certNumber = r.nextInt(1000000); // 6자리
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		// symbols.setGroupingSeparator(' ');
		Format f = new DecimalFormat("000000");
		
		message.setSubject("[kh정보교육원] 인증번호 안내"); // 제목
		message.setText("인증 번호는 [ "+ f.format(certNumber) +" ] 입니다"); // 내용
		
		//[4]
		sender.send(message);
		
		System.out.println("단문 메세지 발송 테스트 종료");
	}
	
}