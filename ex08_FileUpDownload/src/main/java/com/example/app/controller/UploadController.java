package com.example.app.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/upload")
public class UploadController {
	// Upload 방법
	// InMemory -> x,  
	// DB - blob -> x, db에 바이너리 데이터가 들어간다면 검색속도가 현저히 떨어짐
	// FileSystem -> c:\\path\\files.. (단점: OS,운영체제를 따라 달라짐)
	
	// FileSystem 경로 지정
	String UPLOAD_PATH="c:\\upload";
	
	@GetMapping("/file")		// file.jsp 페이지로 이동
	public void up_file() {
		log.info("GET /upload/file..");
	}
	
	@PostMapping("/file")		// file.jsp 페이지에서 singleFile라는 이름으로 파일 전달받고 처리
	public void up_file_post(@RequestParam("singleFile") MultipartFile file) throws IllegalStateException, IOException {
		log.info("POST /upload/file.."+file);
		
		// 파일 정보(이름, 크기) 확인
		log.info("FILENAME : " + file.getOriginalFilename());
		log.info("FILESIZE : " + file.getSize() + "byte");
		
		// 개별폴더 생성 (UUID)
		String subDir = UPLOAD_PATH + File.separator + UUID.randomUUID();	//랜덤 폴더 생성 // separator : '\\' 와 동일한 기능 수행
		File dir = new File(subDir); // subDir 경로를 가진 파일 dir 생성
		if(!dir.exists())	// 파일 dir가 없다면
			dir.mkdirs();	// 파일 dir 생성
		
		// 파일명 추출
		String filename = file.getOriginalFilename();
		// 파일객체 생성
		File fileObject = new File(subDir,filename);
		// 단일 파일 업로드
		file.transferTo(fileObject);	
	}
	
	@GetMapping("/files")		// files.jsp 페이지로 이동
	public void up_files_2() {
		log.info("GET /upload/files..");
	}
	
	@PostMapping("/files")		// files.jsp 페이지에서 files라는 이름으로 파일 전달받고 처리
	public void up_files_2_post(@RequestParam("files") MultipartFile[] files) throws IllegalStateException, IOException {
		log.info("POST /upload/files.."+files);

		// 개별폴더 생성 (UUID)
		String subDir = UPLOAD_PATH + File.separator + UUID.randomUUID();	//랜덤 폴더 생성 // separator : '\\' 와 동일한 기능 수행
		File dir = new File(subDir); // subDir 경로를 가진 파일 dir 생성
		if(!dir.exists())	// 파일 dir 없다면
			dir.mkdirs();	// 파일 dir 생성
		
		// 파일 정보(이름, 크기) 확인
		for(MultipartFile file : files) {
			log.info("--------------");
			log.info("FILENAME : " + file.getOriginalFilename());
			log.info("FILESIZE : " + file.getSize() + "byte");
			
			// 파일명 추출
			String filename = file.getOriginalFilename();
			// 파일객체 생성
			File fileObject = new File(subDir,filename);
			// 파일 업로드
			file.transferTo(fileObject);	
		}
		
	}
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("GET /upload/list..");
		
		File base_dir = new File(UPLOAD_PATH);	// c드라이브에 upload 경로에 새로운 파일 생성
		File[] sub_dir = base_dir.listFiles();	// 파일의 목록을 배열로 반환해 sub_dir 배열에 저장
		for(File dir : sub_dir) {				// for문을 이용해 요소별 정보 로깅
			log.info("SUB_DIR : " + dir);
			
			File tmp = new File(dir.getPath());
			for(File file : tmp.listFiles()) {
				log.info("FILE : " + file);
			}
		}
		model.addAttribute("root",base_dir);	// 파일객체의 주소가 전달
		
	}
	
}
