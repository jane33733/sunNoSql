package com.sun.util;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ValidateUtil extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static public boolean validateLogin(HttpServletRequest request, HttpServletResponse response){
		boolean isLogin = false;
		HttpSession session = request.getSession(true);
		if ((boolean) session.getAttribute("validate")) {
			isLogin = true;
		}		
		return isLogin;
	} 
}
