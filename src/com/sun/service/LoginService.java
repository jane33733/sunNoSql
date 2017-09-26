package com.sun.service;

import com.sun.request.vo.LoginVO;
import com.sun.respose.vo.LoginInfoVO;

public interface LoginService {

	LoginInfoVO validateUser(final LoginVO loginVO); 
	
}
