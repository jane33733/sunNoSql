package com.sun.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sun.request.vo.LoginVO;
import com.sun.respose.vo.LoginInfoVO;

@Transactional
@Repository
public class LoginDao extends BaseDao {

	public LoginInfoVO queryLoginInfo(LoginVO loginVO){
		LoginInfoVO loginInfo = null;
		StringBuilder str = new StringBuilder();
		str.append("SELECT  ");
		str.append("	a.id AS accountId ");
		str.append("	,a.account AS account ");
		str.append("	,u.id AS userId ");
		str.append("	,u.name AS userName  ");
		str.append("FROM sun_account a ");
		str.append("JOIN sun_user u ");
		str.append("ON a.user_id = u.id ");
		str.append("WHERE a.account = :account ");
		str.append("AND a.password = :password ");
		try {
			
			final Query query = this.sessionFactory.getCurrentSession().createSQLQuery(str.toString());
			
			query.setString("account", loginVO.getAccount());
			query.setString("password", loginVO.getPassword());
			query.setResultTransformer(Transformers.aliasToBean(LoginInfoVO.class));
			
			List resultList = query.list();
			
			if (resultList.size() == 1) {
				loginInfo = (LoginInfoVO)resultList.get(0);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return loginInfo;
	} 
	
}
