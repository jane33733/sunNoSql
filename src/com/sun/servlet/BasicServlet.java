package com.sun.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BasicServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6741615731193751225L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//編碼部分應該用Filter統一處理
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	}
}
