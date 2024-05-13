package com.example.app.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class CustomHandler implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CustomHandler's handleRequest() invoke!!..");
		
		return null;
	}
	
	public void HELLO() {
		System.out.println("CustomHandler's HELLO() invoke!!..");
	}

}
