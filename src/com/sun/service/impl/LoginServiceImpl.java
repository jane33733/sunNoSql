package com.sun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.dao.LoginDao;
import com.sun.request.vo.LoginVO;
import com.sun.respose.vo.LoginInfoVO;
import com.sun.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao loginDao;
	
	@Override
	public LoginInfoVO validateUser(LoginVO loginVO) {
		LoginInfoVO loginInfoVO = loginDao.queryLoginInfo(loginVO);
		if (loginInfoVO == null) {
			loginInfoVO = new LoginInfoVO();
			loginInfoVO.setIsExist(false);
		} else {
			loginInfoVO.setIsExist(true);
		}
		return loginInfoVO;
	}

	
	
}
