package com.sun.test.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.sun.dao.LoginDao;
import com.sun.request.vo.LoginVO;
import com.sun.respose.vo.LoginInfoVO;
import com.sun.service.LoginService;

@RunWith(SpringJUnit4ClassRunner.class)
//@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration("file:WebContent/WEB-INF/context-dispatcher.xml")
@WebAppConfiguration
public class LoginServiceTest {

	
	@InjectMocks
	@Autowired
	private LoginService loginService;
	
	@Mock
	@Autowired
	private LoginDao loginDao;
		
	@Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void loginSuccess() {
				
		LoginVO loginVO = new LoginVO();
		loginVO.setAccount("haha");
		loginVO.setPassword("123");
		
		LoginInfoVO loginInfoVO = new LoginInfoVO();
		loginInfoVO.setIsExist(true);
		
    	when(loginDao.queryLoginInfo(loginVO)).thenReturn(loginInfoVO);
		loginService.validateUser(loginVO);
		
	}
	
	@Test
	public void loginFail() {
		
		LoginVO loginVO = mock(LoginVO.class);
		//指定loginDao.queryLoginInfo會回傳null資料，之後再呼叫要測試的Function
    	when(loginDao.queryLoginInfo(loginVO)).thenReturn(null);
    	loginService.validateUser(loginVO);

	}

}
