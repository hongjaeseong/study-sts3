package com.example.app.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.domain.dto.MemoDto;

import lombok.extern.slf4j.Slf4j;

// RestController 만들어보기! (raw한 데이터 전달 목적)
// raw Data type : text_plain, json, xml
@RestController				// restcontroller 애노테이션 설정
@Slf4j						// 로깅 용 애노테이션 설정
@RequestMapping("/rest")	// request mapping할 uri 지정
public class SimpleRestController {
	
	// raw 데이터 전달 (text_plain)
	@GetMapping(value="/getText",produces=MediaType.TEXT_PLAIN_VALUE)
	public String Rest01() {
		log.info("GET /rest/getText...");
		return "HELLO WROLD";
	}
	// raw 데이터 전달 (json)
	@GetMapping(value="/getJson",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public MemoDto Rest02() {
		log.info("GET /rest/getJson...");
		return new MemoDto(1,"HAHA");
	}
	// raw 데이터 전달 (xml)
	@GetMapping(value="/getXml",produces=MediaType.APPLICATION_XML_VALUE)
	public MemoDto Rest03() {
		log.info("GET /rest/getXml...");
		return new MemoDto(1,"HAHA");
	}
	// 여러 raw 데이터 전달 (list)
	@GetMapping(value="/getXmlList",produces=MediaType.APPLICATION_XML_VALUE)
	public List<MemoDto> Rest04() {
		log.info("GET /rest/getXmlList...");
		List<MemoDto> list = new ArrayList<MemoDto>();	// list 만들기
		for(int i=0;i<40;i++) {						// for문 이용해 list에 MemoDto 값 넣기
			list.add(new MemoDto(i, "memo"+i));
		}
		
		return list;		// list 반환
	}
	
	// 클라이언트로 전달 시 웹의 상태여부(성공,실패)를 확인 (ResponseEntity 활용)
	// 반환값으로 ResponseEntity를 활용하여 기본적인 반환자료형인 값과 웹의 상태를 보여주는 코드도 같이 반환한다.
	@GetMapping(value="/getXmlList2/{show}",produces=MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity< List<MemoDto> > Rest05(@PathVariable Boolean show) {
		log.info("GET /rest/getXmlList2...");
		if(show!=null && show==true) {			
			List<MemoDto> list = new ArrayList<MemoDto>();
			for(int i=0;i<40;i++) {		
				list.add(new MemoDto(i, "memo"+i));
			}
			return new ResponseEntity(list,HttpStatus.OK);	// HttpStatus.OK : 웹의 상태를 보여주는 값
		}
	return new ResponseEntity(null,HttpStatus.BAD_REQUEST);	// HttpStatus.BAD_REQUEST : 웹의 상태를 보여주는 값
	}
	
}
	
	
