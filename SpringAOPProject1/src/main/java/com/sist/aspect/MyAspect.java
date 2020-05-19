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
	
	//(..) �Ű������� �־ �ǰ� ��� �ȴ�. 
	//                 return �� 	     ���                 �޼ҵ� ������ (emp_�� �����ϴ� ��� �޼ҵ�)
	@Before("execution(public * com.sist.dao.EmpDAO.emp_*(..))")
	public void getConnection() {
		System.out.println("����Ŭ ����");
	}
	
	//finally
	@After("execution(public * com.sist.dao.EmpDAO.emp_*(..))")
	public void disConnection(){
		System.out.println("����Ŭ ���� ����");
	}
	
	
	//���� ������ �Ǿ��ٸ�. 
	@AfterReturning(value="execution(* com.sist.dao.EmpDAO.emp_*(..))", returning ="ret")
	//returning ="ret" ���� ��
	public void retunValue(Object ret){
		if(ret!=null)
			System.out.println(ret);
	}
	
	//�޼ҵ� �����ϴ� ���� => ������ �߻��� ��쿡 ó�� 
	@AfterThrowing(value="execution(* com.sist.dao.EmpDAO.emp_*(..))",throwing="ex")
	public void throwValue(Throwable ex){
		System.out.println(ex.getMessage());
	}
	
	
	// Ʈ����Ƕ� Ȱ��
	// log ���� ���� 
	@Around("execution(* com.sist.dao.EmpDAO.display())")
	public Object display(ProceedingJoinPoint pjp) throws Throwable{
		
		Signature s = pjp.getSignature();
		System.out.println(s.getName());
		//before ����
		long start=System.currentTimeMillis();
		//display ȣ�� 
		
		//setAutoCommit(false)
		Object obj = pjp.proceed();
		//conn.commit()
		
		//after ����
		long end = System.currentTimeMillis();
		System.out.println("���۽ð�"+start);
		System.out.println("����ð�:"+(end-start));
		System.out.println("����ð�"+end);
		
		return obj;
	}
}
