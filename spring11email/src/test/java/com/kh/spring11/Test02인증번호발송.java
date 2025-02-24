package com.kh.spring11;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.Format;
import java.util.Properties;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.kh.spring11.configuration.EmailProperties;

@SpringBootTest
public class Test02인증번호발송 {
	
	@Autowired
	private EmailProperties emailProperties;
	
	@Test
	public void test() {
		System.out.println("단문 메세지 발송 테스트 시작");
		
		//[1]
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		
		//[2] 
		sender.setHost("smtp.gmail.com"); // 이용할 업체의 별칭 또는 IP(위치 정보)
		sender.setPort(587); // 이용할 업체의 서비스 실행 번호
		sender.setUsername(emailProperties.getUsername()); // 이용할 업체의 사용자 계정이름
		sender.setPassword(emailProperties.getPassword()); // 이용할 업체의 사용자 계정 비밀번호(구글은 앱 비밀번호)
		
		Properties props = new Properties(); // 추가 정보 저장소 생성
		props.setProperty("mail.smtp.auth", "true"); // 인증 후 이용 설정
		props.setProperty("mail.smtp.debmg", "true"); // 디버깅 허용 설정
		props.setProperty("mail.smtp.starttls.enable", "true"); // TLS 사용 설정
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2"); // TLS 버전 설정
		props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com"); // 신뢰할 수 있는 주소로 등록
		sender.setJavaMailProperties(props); // 추가 정보 설정
		
		//[3]
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("kh15.semi.final@gmail.com"); // 수신인(여러개 가능)
		//message.setCc(null); // 참조인(여러개 가능)
		//message.setBcc(null); // 숨은 참조인(여러개 가능)
		
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