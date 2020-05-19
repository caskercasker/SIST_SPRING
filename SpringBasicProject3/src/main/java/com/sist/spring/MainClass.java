package com.sist.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.*;

public class MainClass {
	public static void main(String[] args) {
		//�����̳ʿ� xml ���� ���� => �Ľ� => ��ϵ� Ŭ������ �޸� �Ҵ�
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		/*
		 * 	Ŭ���� �޸� �Ҵ�
		 * 	sexXxx()�� ���� ä���
		 * 	init-method�� �����ϸ� ȣ��
		 *  =====================
		 *  	���α׷��Ӱ� �ʿ��� �޼ҵ带 ȣ��
		 *  ====================	
		 *  	destroy-method�� ȣ��	
		 *  	�޸𸮸� ���� 
		 */
		EmpDAO dao = (EmpDAO)app.getBean("dao");
		List<EmpVO> list = dao.empAllData();
		for(EmpVO vo:list){
			System.out.println(vo.getEname()+" "
					+vo.getComm()+" "
					+vo.getJob()+" "
					+vo.getSal());
		}
	
	}
}
