package com.sist.dao;
import java.util.*;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
// �����ڷμ� id�� �ʿ��ϴ� 
// <bean id="eDao" class="com.sist.dao.EmpDAO">
// �ڵ� id => empDAO
// MainClass => mainClass

@Repository
public class EmpDAO extends SqlSessionDaoSupport {

		
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	public List<EmpVO> empALlData(){
		return getSqlSession().selectList("empALlData");
	}
	
	public EmpVO empFindData(int empno){
		return getSqlSession().selectOne("empFindData",empno);
	}
	
}
