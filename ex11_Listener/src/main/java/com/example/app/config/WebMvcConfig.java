package com.example.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.example.app.interceptor.MemoInterceptor;
import com.example.app.listener.CustomContextRefreshedListener;
import com.example.app.listener.MemoAddEventListener;
import com.example.app.listener.RequestHandleEventListener;

//servlet-context.xml 파일을 대체하는 작업
@Configuration
@EnableWebMvc
@ComponentScans({
	@ComponentScan("com.example.app.controller"),
	@ComponentScan("com.example.app.restcontroller")
})
public class WebMvcConfig implements WebMvcConfigurer {
	
	// MULTIPARTCONFIG
	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(1024*1024*10*2);		// 20MB // 전체 업로드 허용 사이즈
		multipartResolver.setMaxUploadSizePerFile(20971520);	// 20MB // 파일 1개당 허용 가능한 업로드 사이즈
		multipartResolver.setMaxInMemorySize(20971520);			// 20MB // 캐시 공간 (파일 임시 보관 장소)
		return multipartResolver;
	}
	
	// VIEWRESOLVER
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	// RESOURCES
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");	// src/main/resources/** 의 경로 지정
	}
	
	// INTERCEPTOR
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new MemoInterceptor()).addPathPatterns("/memo/*");
	}
	
	// LISTENER Bean 등록
	@Bean
	public RequestHandleEventListener requestHandleEventListener() {
		return new RequestHandleEventListener();
	}
	@Bean
	public CustomContextRefreshedListener customContextRefreshedListener() {
		return new CustomContextRefreshedListener();
	}
	
	@Bean
	public MemoAddEventListener memoAddEventListener() {
		return new MemoAddEventListener();
	}
	
	
}
