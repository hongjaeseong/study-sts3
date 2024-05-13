package com.example.app.domain.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.app.domain.dto.MemoDto;

@Repository
public class MemoDaoImpl {
	// mapper - dao - service ( 과거 방식 )
	@Autowired
	private SqlSession sqlSession;
	
	private static String namespace="com.example.app.domain.mapper.MemoMapper.";	// 점 찍어주기 -> 내부의 함수 사용 위해
	
	public MemoDto Insert(MemoDto memoDto) {
		sqlSession.insert(namespace+"Insert",memoDto);
		
		return memoDto;
		
		
	// mapper - service ( 최근 방식 : 바로 연결 )
		
		
	}
}
