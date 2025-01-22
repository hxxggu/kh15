package com.kh.spring09.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring09.dao.AttachmentDao;
import com.kh.spring09.dto.AttachmentDto;
import com.kh.spring09.service.AttachmentService;

public class FileDownloadController {
	@Autowired
	private AttachmentDao attachmentDao;
	@Autowired
	private AttachmentService attachmentService;
	
	@RequestMapping("/download2")
	public ResponseEntity<ByteArrayResource> download2(
			@RequestParam int attachmentNo) throws IOException {
		byte[] data = attachmentService.load(attachmentNo);
		AttachmentDto attachmentDto = attachmentDao.selectOne(attachmentNo);
		
		//포장(wrap)
		ByteArrayResource resource = new ByteArrayResource(data);
		
		//변수를 만들지 않고 처리할 수 있는 방법
		//반환
		return ResponseEntity.ok() //담아서 넘겨주는 느낌
					.header(HttpHeaders.CONTENT_ENCODING, "UTF-8") //characterSet
					.header(HttpHeaders.CONTENT_TYPE, attachmentDto.getAttachmentType()) //파일의 타입을 알 때
//					.contentType(MediaType.APPLICATION_OCTET_STREAM) //파일의 타입을 모를 때
					.contentLength(attachmentDto.getAttachmentSize())
					//내 자료형을 그대로 넣을 수 있도록
					.header(HttpHeaders.CONTENT_DISPOSITION,
						ContentDisposition.attachment()
						.filename(attachmentDto.getAttachmentName(),
								StandardCharsets.UTF_8) //utf-8로 받지 않으면 아스키 코드로 받아들임
						.build().toString()
					)
				.body(resource);
		//LocalDate.now() 와 같은 느낌 / 문장을 읽듯이 코딩
		
	}
	
	@RequestMapping("/download")
	public ResponseEntity<ByteArrayResource> download(
			@RequestParam int attachmentNo) throws IOException {
		byte[] data = attachmentService.load(attachmentNo);
		AttachmentDto attachmentDto = attachmentDao.selectOne(attachmentNo);
	
		ByteArrayResource resource = new ByteArrayResource(data);
		
		return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_ENCODING, "UTF-8")
					.header(HttpHeaders.CONTENT_TYPE, attachmentDto.getAttachmentType())
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
