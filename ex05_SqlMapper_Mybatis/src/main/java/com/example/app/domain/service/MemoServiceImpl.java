package com.example.app.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.domain.dto.MemoDto;
import com.example.app.domain.mapper.MemoMapper;

@Service
public class MemoServiceImpl {
	// service - dao - mapper ( 과거 방식 )
//	@Autowired
//	private MemoDaoImpl memoDaoImpl;
//	
//	public boolean memoRegistration(MemoDto memoDto) {
//		memoDaoImpl.Insert(memoDto);
//		
//		return true;
//	}
	
	// service - mapper ( 최근 방식 : 바로 연결 )
	@Autowired
	private MemoMapper memoMapper;
	public boolean memoRegistration(MemoDto memoDto) {
		memoMapper.Insert(memoDto);
		return true;
	}
	
}
