package com.sist.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//XML 파싱
		@SuppressWarnings("resource")
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		
		//등록된 클래스를 사용
/*		Sawon sa = (Sawon)app.getBean("sa"); //DL (Dependency Lookup) + DI => DI(IoC)
		Sawon sa1 = (Sawon)app.getBean("sa1");
		Sawon sa2 = (Sawon)app.getBean("sa2");
		Sawon sa3 = (Sawon)app.getBean("sa3");
		Sawon sa4 = (Sawon)app.getBean("sa4");
		Sawon sa5 = (Sawon)app.getBean("sa5");*/
		Sawon sa6 = (Sawon)app.getBean("sa6");

		System.out.println("sa="+sa6);
		System.out.println("사번:"+sa6.getSabun());
		System.out.println("이름:"+sa6.getName());
		System.out.println("부서:"+sa6.getDept());
	}
}
