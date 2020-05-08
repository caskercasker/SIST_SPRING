package com.sist.spring;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.dao.EmpDAO;
import com.sist.dao.EmpVO;
/*
 *  Ŭ���� �޸� �Ҵ�
 *  @Component, @Repository, @Service, @Controller, @RestController, @ControllerAdvice, 
 *	
 *  ����(DI)
 *	@Required,
 *  @Autowired, 
 *  @PostConstruct, 
 *  @PreDestroy, 
 *  @Resource
 */
@Component
public class MainClass {
	
	@Autowired
	private EmpDAO dao;
	
	//init-method
	@PostConstruct
	public void init(){
		System.out.println("======== ��� ���� ========");
	}
	
	// destryo-method
	@PreDestroy
	public void destroy(){
		System.out.println("======== ���α׷� ���� =======");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext app = new GenericXmlApplicationContext("app.xml");
		MainClass mc = (MainClass)app.getBean("mainClass");
		List<EmpVO> list = mc.dao.empALlData();
		for(EmpVO vo:list){
			System.out.println(vo.getEname()+ " "+vo.getDeptno());
		}
		EmpVO vo = mc.dao.empFindData(7788);
		System.out.println("���:"+vo.getEmpno());
		System.out.println("�̸�:"+vo.getEname());
		System.out.println("����:"+vo.getJob());
		System.out.println("�Ի���"+vo.getHiredate());
		System.out.println("�޿�"+vo.getSal());
		
		app.close();
		
	}
}
