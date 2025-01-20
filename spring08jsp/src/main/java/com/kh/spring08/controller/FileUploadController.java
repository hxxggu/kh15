package com.kh.spring08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fileupload")
public class FileUploadController {
	
	@RequestMapping("/test1")
	public String test1() {
		return "/WEB-INF/views/fileupload.jsp";
	}
}
