package com.sist.dao;
import java.util.*;

import org.mybatis.spring.support.SqlSessionDaoSupport;


public class EmpDAO extends SqlSessionDaoSupport {
	public List<EmpVO> empALlData(){
		return getSqlSession().selectList("empALlData");
	}
	
	public EmpVO empFindData(int empno){
		return getSqlSession().selectOne("empFindData",empno);
	}
	
}
