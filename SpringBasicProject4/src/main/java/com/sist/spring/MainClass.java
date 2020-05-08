package com.sist.spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app = new ClassPathXmlApplicationContext("emp.xml");
		EmpDAO dao = (EmpDAO)app.getBean("dao");
		List<EmpVO> list = dao.empALlData();
		
		for(EmpVO vo:list){
			System.out.println(vo.getEname()+" "+vo.getJob()+" "+vo.getDeptno());
		}
	}

}
