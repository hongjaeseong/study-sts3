package com.example.app.domain.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data		// Getter and Setter, toString etc..

public class BoardDto {
	private Long id;
	private String title;
	private String contents;
	private String writer;
	private String regdate;
	private MultipartFile[] files;		// 파일을 받아낼 용도로 사용
}
