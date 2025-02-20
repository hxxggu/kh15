package com.kh.spring09;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring09.dao.ReplyDao;
import com.kh.spring09.dto.ReplyDto;

@SpringBootTest // 제가 만드는게 테스트용 파일이에요 (스프링 환경 연동됨)
public class Test01더미데이터등록 {
//	SpringBoot 에는 main 이 단 하나만 올 수 있음. 해당 파일에는 main 을 만들지 않는다
	
	@Autowired
	private ReplyDao replyDao;
	
	@Test // 이 메서드를 테스트할 때 실행 해주세요 (JUnit 기술 사용)
	public void test() {
		for(int i=1; i<=20; i++) {
			ReplyDto replyDto = ReplyDto.builder()
					.replyNo(replyDao.sequence())
					.replyWriter("testuser1")
					.replyOrigin(13) // 게시글의 해당 번호
					.replyContent("테스트용 댓글" +i)
					.build();
			replyDao.insert(replyDto);
		}
	}
}
