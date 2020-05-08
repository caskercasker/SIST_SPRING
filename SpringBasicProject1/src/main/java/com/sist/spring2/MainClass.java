package com.sist.spring2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.*;

public class MainClass {
	public static void main(String[] args) {
	
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(Config.class);
		EmpDAO dao = ctx.getBean("empDAO",EmpDAO.class);
		List<EmpVO> list = dao.empAllData();
		for(EmpVO vo:list){
			System.out.println(vo.getEname()+" "+vo.getJob()+" "+vo.getSal());
		}
		ctx.close();
	}
}
