package com.sist.spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass2 {
	public EmpDAO dao;

	public void setDao(EmpDAO dao) {
		this.dao = dao;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// DL => 등록된 클래스를 읽어올 때
		@SuppressWarnings("resource")
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		
		//DL
		MainClass2 mc = (MainClass2)app.getBean("mc2");
		
		//EmpDAO dao = (EmpDAO)app.getBean("dao");
		List<EmpVO> list = mc.dao.empAllData();
		
		for(EmpVO vo:list){
			System.out.println(vo.getEmpno()+" "
						+vo.getEmpno()+" "
						+vo.getJob()+" "
						+vo.getHiredate().toString()+" "
						+vo.getSal());
			
		}
	}
}
