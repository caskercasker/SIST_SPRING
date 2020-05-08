package com.sist.spring;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.dao.*;

@Component
public class MainClass {
	
	@Autowired
	private EmpDAO dao;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		
		MainClass mc = (MainClass)app.getBean("mainClass");
		//MainClass mc = new MainClass();
		List<EmpVO> list = mc.dao.empALlData();
		for(EmpVO vo: list){
			System.out.println(vo.getEmpno()+" "+vo.getJob()+" "+vo.getSal());
			
		}
		System.out.println(mc.dao.empALlData());

/*		EmpDAO dao = (EmpDAO)app.getBean("empDAO");
		List<EmpVO> list = dao.empALlData();
		
		for(EmpVO vo:list){
			System.out.println(vo.getEname()+" "+vo.getJob()+" "+vo.getSal());
		}*/
	}
}
