package com.example.app.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.domain.dto.MemoDto;
import com.example.app.domain.mapper.MemoMapper;
import com.example.app.listener.MemoAddEvent;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
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
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	public boolean memoRegistration(MemoDto memoDto) throws Exception {
			memoMapper.Insert(memoDto);
			//MemoAdd 이벤트 등록
			publisher.publishEvent(new MemoAddEvent(this,memoDto));
			return true;
	}
	
	@Transactional(rollbackFor = Exception.class)	// 예외가 발생하면 무조건 롤백처리를 하는 트랜잭션 애노테이션 설정
	public void addMemoTx(MemoDto memoDto) throws Exception {
		log.info("MemoService addMemoTx() invoke..");
		memoMapper.Insert(memoDto);		// RollBack x (트랜잭션 처리가 안되어있기 때문)
		log.info(memoDto.toString());
		memoDto.setId(memoDto.getId()-1);
		memoMapper.Insert(memoDto);		// PK 중복 오류발생!
	}
	
	@Transactional(rollbackFor = Exception.class)	// 예외가 발생하면 무조건 롤백처리를 하는 트랜잭션 애노테이션 설정
	public boolean modifiedMemo(MemoDto dto) throws Exception {
		
		memoMapper.Update(dto);
		return true;
		
	}
	
	@Transactional(rollbackFor = Exception.class)	// 예외가 발생하면 무조건 롤백처리를 하는 트랜잭션 애노테이션 설정
	public boolean removeMemo(int id) throws Exception {
		
		
		// 하단의 코드 확인해보기
		return memoMapper.Delete(id)>0; 
	}

	@Transactional(rollbackFor = Exception.class)	// 예외가 발생하면 무조건 롤백처리를 하는 트랜잭션 애노테이션 설정
	public List<MemoDto> getAllMemo(MemoDto memoDto) throws Exception {
		
		return memoMapper.GetAllMemo(memoDto);
	}
	
}
