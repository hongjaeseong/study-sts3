package com.example.app.mybatis;

import java.sql.Connection;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.app.domain.dto.BoardDto;
import com.example.app.domain.mapper.BoardMapper;
import com.example.app.domain.service.BoardServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Slf4j
public class MybatisTests {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void test() {
		log.info(sqlSessionFactory.toString());
		
		SqlSession session = sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		log.info(conn.toString());
	}
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	public void BoardMapperTests() {
//		boardMapper.Insert(new BoardDto((long) 123,"abc","abc","abc","abc"));
//		boardMapper.Insert(new BoardDto((long) 124,"abc","abc","abc","abc"));
//		boardMapper.Insert(new BoardDto((long) 125,"abc","abc","abc","abc"));
//		boardMapper.Update(new BoardDto((long) 123,"bbb"));
//		boardMapper.Delete((long) 123);
//		BoardDto r1 = boardMapper.SelectOne((long) 124);
//		log.info(r1.toString());
//		List<BoardDto> list = boardMapper.SelectAll();
//		for(BoardDto dto : list) {
//			log.info(dto.toString());
//		}
	}
	
	@Autowired
	private BoardServiceImpl boardServiceImpl;
	
	@Test
	public void BoardServiceImplTests() {
		boardServiceImpl.boardRegistration(new BoardDto((long) 123,"abc","abc","abc","abc"));
	}

}
