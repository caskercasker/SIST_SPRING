package com.sist.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	
	//(..) 매개변수가 있어도 되고 없어도 된다. 
	//                 return 형 	     대상                 메소드 구분자 (emp_로 시작하는 모든 메소드)
	@Before("execution(public * com.sist.dao.EmpDAO.emp_*(..))")
	public void getConnection() {
		System.out.println("오라클 연결");
	}
	
	//finally
	@After("execution(public * com.sist.dao.EmpDAO.emp_*(..))")
	public void disConnection(){
		System.out.println("오라클 연결 해제");
	}
	
	
	//정상 수행이 되었다면. 
	@AfterReturning(value="execution(* com.sist.dao.EmpDAO.emp_*(..))", returning ="ret")
	//returning ="ret" 리턴 값
	public void retunValue(Object ret){
		if(ret!=null)
			System.out.println(ret);
	}
	
	//메소드 수행하는 과정 => 오류가 발생할 경우에 처리 
	@AfterThrowing(value="execution(* com.sist.dao.EmpDAO.emp_*(..))",throwing="ex")
	public void throwValue(Throwable ex){
		System.out.println(ex.getMessage());
	}
	
	
	// 트랜잭션때 활용
	// log 파일 제각 
	@Around("execution(* com.sist.dao.EmpDAO.display())")
	public Object display(ProceedingJoinPoint pjp) throws Throwable{
		
		Signature s = pjp.getSignature();
		System.out.println(s.getName());
		//before 시점
		long start=System.currentTimeMillis();
		//display 호출 
		
		//setAutoCommit(false)
		Object obj = pjp.proceed();
		//conn.commit()
		
		//after 시점
		long end = System.currentTimeMillis();
		System.out.println("시작시간"+start);
		System.out.println("수행시간:"+(end-start));
		System.out.println("종료시간"+end);
		
		return obj;
	}
}
