package com.example.app.controller.exception;

import java.io.FileNotFoundException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

// 예외처리 전역 설정
// 예외처리를 이제 컨트롤러 단에서 일괄 처리 
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	// 예외처리기
	@ExceptionHandler(FileNotFoundException.class)
	public String fileNotFoundExceptionHandler(Exception error, Model model) {
		log.info("GlobalExceptionHandler's @ExceptionHandler..." + error);
		model.addAttribute("error", error);
		return "error";
	}

	// 예외처리기
	@ExceptionHandler(ArithmeticException.class)
	public String arithmeticExceptionHandler(Exception error, Model model) {
		log.info("GlobalExceptionHandler's @ExceptionHandler..." + error);
		model.addAttribute("error", error);
		return "error";
	}
	
	// 예외처리기
	@ExceptionHandler(Exception.class)
	public String allException(Exception error, Model model) {
		log.info("GlobalExceptionHandler's @ExceptionHandler..." + error);
		model.addAttribute("error", error);
		return "error";
	}

}
