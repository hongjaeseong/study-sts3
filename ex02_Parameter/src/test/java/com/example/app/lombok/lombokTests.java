package com.example.app.lombok;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.example.app.domain.dto.PersonDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class lombokTests {

	// PersonDto의 Getter and Setter, 생성자 사용 여부를 테스트하기 위한 용도
	@Test
	public void personDtoTests() {
		PersonDto ob = new PersonDto();
		ob.setName("홍재성");
		ob.setAddr("대구 북구 구암동");
		ob.setAge(28);
		log.info(ob.toString());
		// Junit Test function..
		PersonDto ob2 = null;
		assertNotNull(ob);		// Getter and Setter, 생성자, toString 테스트
		assertNotNull(ob2);		// Null 테스트
	}
	
	@Test
	public void personDtoTests_2() {
		// @Builder
		PersonDto ob = PersonDto.builder()
						.age(24)
						.name("김규호")
						.addr("서울")
						.build();
		log.info(ob.toString());
		
		assertNotNull(ob);
		
	}

}
