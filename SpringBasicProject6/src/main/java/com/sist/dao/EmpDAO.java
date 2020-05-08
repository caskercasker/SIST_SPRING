package com.sist.dao;
import java.util.*;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDAO extends SqlSessionDaoSupport {
	
	
	
//	@Autowired
	@Resource(name="ssf")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	public List<EmpVO> empALlData(){
		return getSqlSession().selectList("empAllData");
	}
	
	public EmpVO empFindData(int empno){
		return getSqlSession().selectOne("empFindData",empno);
	}
	
}
