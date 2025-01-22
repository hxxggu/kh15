package com.kh.spring08.dto;

import java.text.DecimalFormat;
import java.text.Format;

import lombok.Data;

//첨부파일 DTO
@Data
public class AttachmentDto {
	private int attachmentNo; //시퀀스 번호
	private String attachmentName; //업로드한 파일명
	private String attachmentType; //업로드한 파일유형
	private long attachmentSize; //업로드한 파일크기
	
	public String getAttachmentSizeString() {
		Format fmt = new DecimalFormat("#,##0.00");
		if(attachmentSize >= 1024L*1024L*1024L) { //GB 단위로 표현해야 한다면
//			return attachmentSize / (1024L*1024L*1024L) + "GB"; //소수점 나오지 않음
			return fmt.format((double)attachmentSize / (1024L*1024L*1024L)) + "GB"; //소수점 나오게 하기 위한 캐스팅
		} else if(attachmentSize >= 1024L*1024L) { //MB 단위로 표현해야 한다면
			return fmt.format((double)attachmentSize / (1024L*1024L)) + "MB";
		} else if(attachmentSize >= 1024L) { //KB 단위로 표현해야 한다면
			return fmt.format((double)attachmentSize / 1024L) + "KB";
		} else return fmt.format(attachmentSize) + "Byte";
	}
}
