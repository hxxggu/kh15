package com.kh.spring08.controller;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring08.dao.AttachmentDao;
import com.kh.spring08.dto.AttachmentDto;
import com.kh.spring08.error.TargetNotfoundException;
import com.kh.spring08.service.AttachmentService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/filedownload")
public class FileDownloadController {
	
	@Autowired
	private AttachmentDao attachmentDao;
	@Autowired
	private AttachmentService attachmentService;

	//목록 매핑
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("list", attachmentDao.selectList());
		return "/WEB-INF/views/filedownload/list.jsp";
	}
	
	//파일 다운로드 처리
	// -/download1에서는 자바 웹(JAVA EE)에서 제공하는 방법 사용
	// -/download2에서는 스프링(Spring)에서 제공하는 방법 사용
	
	@RequestMapping("/download1")
	public void download1(
			@RequestParam int attachmentNo,
			HttpServletResponse response) throws IOException {
		//[1] 유효한 파일 번호인지 확인
		AttachmentDto attachmentDto = attachmentDao.selectOne(attachmentNo);
		if(attachmentDto == null) {
			throw new TargetNotfoundException("존재하지 않는 파일번호");
		}
	
		//[2] 실제 파일이 존재하는지 확인
		File dir = new File("D:/upload");
		File target = new File(dir, String.valueOf(attachmentNo));
		if(target.isFile() == false) {
			throw new TargetNotfoundException("파일이 존재하지 않습니다");
		}
		
		//[3] 실제 파일을 불러온다
		byte[] data = FileUtils.readFileToByteArray(target);
		
		//[4] 사용자에게 파일을 전송 (헤더+바디)
//		response.setHeader("이름", "값");
		response.setHeader("Content-Encoding", "UTF-8"); //
		response.setHeader("Content-Type", attachmentDto.getAttachmentType()); //내가 보내는 파일의 유형을 알 경우
//		response.setHeader("Content-Type", "application/octet-stream"); //내가 보내는 파일의 유형을 모르는 경우
		response.setHeader("Content-Length", String.valueOf(attachmentDto.getAttachmentSize()));
		//유형을 변경해주어야 사용이 가능
		response.setHeader("Content-Disposition", "attachment; filename=\""+attachmentDto.getAttachmentName()+"\"");
		//파일의 이름
		
		response.getOutputStream().write(data); 
		//*가장 원시적인 형태의 다운로드*
	}
	
	//ResponseEntity는 사용자에게 내보낼 정보가 포장된 개체를 의미
	//: 그대로 사용자에게 전송하라
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

}
