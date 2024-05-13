package com.example.app.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

// MyBatis 구성 파일
@Configuration
public class MybatisConfig {
	
	// 의존성 주입
	@Autowired
	private DataSource dataSource3;
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {		// sqlSessionFactory 생성
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();	//SqlSessionFactoryBean에서 sessionFatory 생성
		sessionFactory.setDataSource(dataSource3);
		
		// BoardMapper.xml 파일 위치 지정
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource[] resources = resolver.getResources("classpath*:mapper/*.xml");
		sessionFactory.setMapperLocations(resources);
		
		return sessionFactory.getObject();
	}
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	// sqlSession을 만들어 bean으로 등록하는 작업
	@Bean
	public SqlSessionTemplate sqlSessionTemplate() {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
	
}
