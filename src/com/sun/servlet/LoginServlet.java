package com.sun.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = -1428426644907957580L;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginServlet.class);
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.debug("[loginCheck]------ Start ");
		
		//編碼部分應該用Filter統一處理
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
    	
    	//檢查帳密
		request.getRequestDispatcher("\\login\\validate.do").forward(request, response);
		
	}

}
