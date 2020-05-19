package com.sist.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Component;
import java.util.*;

//Join 처리 
//annotation 에서 join 처리 

public interface EmpMapper {
	
	//vo에 값을 실어주는 형태(Join이 된 테이블
	@Results({
		@Result(property="empno",column="empno"),
		@Result(property="ename",column="ename"),
		@Result(property="job",column="job"),
		@Result(property="mgr",column="mgr"),
		@Result(property="hiredate",column="hiredate"),
		@Result(property="sal",column="sal"),
		@Result(property="comm",column="comm"),
		@Result(property="deptno",column="deptno"),
		@Result(property="dvo.dname",column="dname"),
		@Result(property="dvo.loc",column="loc")
	})
	@Select("SELECT empno,ename,job,mgr,hiredate,sal,comm,dname,loc FROM emp,dept WHERE emp.deptno=dept.deptno "
			+"Order by sal DESC")
	public List<EmpVO> empAllData();
	
	@Select("SELECT DISTINCT mgr FROM emp")
	public List<Integer> empGetMgr();
	
	@Select("SELECT DISTINCT job FROM emp")
	public List<String> empGetJob();
	
	@SelectKey(keyProperty="empno", resultType=int.class,before=true,statement="SELECT NVL(max(empno)+1,1) as empno FROM emp")
	@Insert("Insert Into emp VALUES("
			+"#{empno},#{ename},#{job},#{mgr},SYSDATE,#{sal},#{comm},#{deptno})")
	public void empInsert(EmpVO vo);
}
