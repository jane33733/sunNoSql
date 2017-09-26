package com.sun.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.request.vo.LoginVO;
import com.sun.respose.vo.LoginInfoVO;
import com.sun.service.LoginService;

@Controller
@RequestMapping(value = "login")
public class LoginController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 358203527105212734L;
	
	/** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
    
    @Autowired
    private LoginService loginService;
    
    @ResponseBody
    @RequestMapping(value = "validate", method = RequestMethod.POST)
    public boolean loginValidate(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	LOGGER.info("[loginCheck]------ Start ");
    	HttpSession session = null;
        boolean login = false;
        
        try {
        	
        	LoginVO loginVO = LoginVO.getInstance(request);
        	
        	if (StringUtils.isNotBlank(loginVO.getAccount()) && StringUtils.isNoneBlank(loginVO.getPassword())) {
        		
        		LoginInfoVO loginInfoVO = loginService.validateUser(loginVO);
        		LOGGER.debug("loginInfoVO {}", loginInfoVO.toString());
        		
        		if (loginInfoVO.getIsExist()) {
        			session = request.getSession();
        			session.setAttribute("account", loginInfoVO.getAccount());
        			session.setAttribute("userName", loginInfoVO.getUserName());
        			session.setAttribute("validate", true);
        			
//        			request.getRequestDispatcher("\\pages\\productInfo.jsp").forward(request,response);
        			response.sendRedirect("pages/feature/productInfo.jsp");
        		} else {
        			response.sendRedirect("\\pages\\error\\errorSimple.jsp");
        		}
        	}
			
		} catch (Exception e) {
			LOGGER.error("[loginValidate]------ error ");
			e.printStackTrace();
		}
		
        
        return login;
    }
    
    
//    @ResponseBody
//    @RequestMapping(value = "validate", method = RequestMethod.POST)
//    public boolean loginCheck(HttpServletRequest request,
//    		//不推薦用restful API 作登入登出的功能，有資安風險問題
//            HttpServletResponse response, @RequestBody LoginVO queryVO) throws Exception {
//        LOGGER.debug("[loginCheck]------ Start " + queryVO.getAccount());
//        boolean login = false;
//        System.out.println("[loginCheck]------ Start " + queryVO.getAccount());
//        //直接當作通過
//        HttpSession session = request.getSession();
//		session.setAttribute("account",queryVO.getAccount());
//		session.setAttribute("name","db output name");
//		
//        
//        return login;
//    }
    
}
