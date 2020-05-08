package com.sist.temp;

import javax.annotation.Resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MainClass {
	
	//�ڵ� ����
/*	@Autowired
	@Qualifier("boardDAO")*/
	
//	@Resource(name="noticeDAO")
	
	
	@Autowired
	@Qualifier("boardDAO")
	private MyDAO dao;
	// private �����ӿ��� ���������� ������ ������ (getter ���� ���� �ڵ����� �־���)
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
				
		MainClass mc = (MainClass)app.getBean("mainClass");
		mc.dao.select();
		//		MainClass mc1 = new MainClass(); 		//�������� ���� dao�� �ν����� ���Ѵ�. 
		
		
		
	}

}
