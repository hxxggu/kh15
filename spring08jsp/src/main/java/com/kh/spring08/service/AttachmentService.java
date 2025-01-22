package com.kh.spring08.service;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring08.dao.AttachmentDao;
import com.kh.spring08.dto.AttachmentDto;
import com.kh.spring08.error.TargetNotfoundException;

@Service
public class AttachmentService {
	
	@Autowired
	private AttachmentDao attachmentDao;
	
	//파일 저장 메서드
	public int save(MultipartFile attach) throws IllegalStateException, IOException {
		if(attach.isEmpty()) return -1; //절대 나올 수 없는 수인 -1로 설정
		//저장 위치 생성
		File dir = new File("D:/upload");
		dir.mkdirs(); //저장
		//물리 파일 저장
		int attachmentNo = attachmentDao.sequence(); //시퀀스번호 추출 
		File target = new File(dir, String.valueOf(attachmentNo)); //파일명으로 실행
		attach.transferTo(target); //저장
		//파일 정보 저장
		AttachmentDto attachmentDto = new AttachmentDto();
		attachmentDto.setAttachmentNo(attachmentNo);
		attachmentDto.setAttachmentName(attach.getOriginalFilename());
		attachmentDto.setAttachmentType(attach.getContentType());
		attachmentDto.setAttachmentSize(attach.getSize());
		attachmentDao.insert(attachmentDto);
		//파일 번호 반환
		return attachmentNo;
	}
	
	//파일 불러오기 (+유효성 검사)
	public byte[] load(int attachmentNo) throws IOException {
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
		
		return data;
	}
}
