package com.kh.spring12.restcontroller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring12.dao.AttachmentDao;
import com.kh.spring12.dto.AttachmentDto;
import com.kh.spring12.service.AttachmentService;
//@CrossOrigin//<img src=""> 로 부르기 때문
@RestController
@RequestMapping("/api/attachment")
public class AttachmentRestController {
	
	@Autowired
	private AttachmentDao attachmentDao;
	@Autowired
	private AttachmentService attachmentService;
	
	@GetMapping("/{attachmentNo}")
	public ResponseEntity<ByteArrayResource> download( // 파일에 있는 응답 개체를 반환하겠음을 의미
								@RequestParam int attachmentNo) throws IOException {
		byte[] data = attachmentService.load(attachmentNo);
		// 애매한 원시형 (참조형은 참조형이지만, 클래스가 아님 > 객체지향에서는 지양하는 포인트) : 커스터마이징 불가능
		AttachmentDto attachmentDto = attachmentDao.selectOne(attachmentNo);
		
		//포장(Wrap)
		ByteArrayResource resource = new ByteArrayResource(data);
		
		//반환
		return ResponseEntity.ok() // 파일을 다운로드 하기 위해서는 헤더 필요 (파일에 대한 정보 기재)
							.header(HttpHeaders.CONTENT_ENCODING, "UTF-8")
							.header(HttpHeaders.CONTENT_TYPE, attachmentDto.getAttachmentType())//알 때
							//.contentType(MediaType.APPLICATION_OCTET_STREAM)//모를 때
							.contentLength(attachmentDto.getAttachmentSize())
							.header(HttpHeaders.CONTENT_DISPOSITION, 
								ContentDisposition.attachment()
									.filename(attachmentDto.getAttachmentName(), 
													StandardCharsets.UTF_8)
								.build().toString()
							)
						.body(resource);
	}
	
}