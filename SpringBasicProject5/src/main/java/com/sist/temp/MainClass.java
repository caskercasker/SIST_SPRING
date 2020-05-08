package com.sist.temp;

import javax.annotation.Resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MainClass {
	
	//자동 주입
/*	@Autowired
	@Qualifier("boardDAO")*/
	
//	@Resource(name="noticeDAO")
	
	
	@Autowired
	@Qualifier("boardDAO")
	private MyDAO dao;
	// private 변수임에도 스프링에서 접근이 가능함 (getter 세팅 없이 자동으로 넣었다)
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
				
		MainClass mc = (MainClass)app.getBean("mainClass");
		mc.dao.select();
		//		MainClass mc1 = new MainClass(); 		//생성하지 않은 dao라서 인식하지 못한다. 
		
		
		
	}

}
