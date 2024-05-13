package com.example.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.app.domain.dto.PersonDto;

// bean 객체를 java config에서 만들기
@Configuration
public class PersonDtoBeanConfig {

	@Bean
	public PersonDto person03() {
		return PersonDto.builder()
				.name("구자욱")
				.addr("대구")
				.age(49)
				.build();
	}
	@Bean(name = "personBean")
	public PersonDto person04() {
		return PersonDto.builder()
				.name("류현진")
				.addr("대전")
				.age(89)
				.build();
	}
}
