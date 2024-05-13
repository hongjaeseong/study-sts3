package com.example.app.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration					// 설정파일을 bean으로 만들고 관리
@EnableTransactionManagement	// 트랜잭션을 관리하는 파일을 bean으로 만들고 관리
public class TxConfig {
	
	@Autowired
	private DataSource dataSource3;		// Mybatis와 동일하게 맞춤(Hikari 사용)
	
	@Bean
	public DataSourceTransactionManager transactionManager() {	// 데이터소스에서 사용하는 트랜잭션 관리자를 생성
		return new DataSourceTransactionManager(dataSource3);
	}
	
	
}
