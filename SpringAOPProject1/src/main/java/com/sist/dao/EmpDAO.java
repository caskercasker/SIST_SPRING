package com.sist.dao;

import org.springframework.stereotype.Repository;

//�޸� �Ҵ�
@Repository
public class EmpDAO {
	// AOP ó���� Spring�� Ʈ����� ó���� �ݺ��� ������ ���·� �۵��Ѵ�.
	// CRUD�� ó���� ��
	public void emp_select() {
		//����Ŭ ���ῡ�� �ݵ�� �ݺ��Ǵ� �޼ҵ�
		//getConnection disConnection
		//getConnection();
		System.out.println("EMP ���̺��� �����͸� ������ �´�.");
		//disConnection();
	}
	
	public void emp_insert(String name)
	{
		//getConnection();
		System.out.println(name+"��(��) �߰�");
		//disConnection();
	}
	public void emp_update(int sabun, String name){
		//getConnection();
		System.out.println(sabun+"�� �ش�Ǵ�"+name+"�� �����Ͽ����ϴ�.");
		//disConnection();
	}
	
	public String emp_delete(int sabun){
		//getConnection();
		//int a = 10/0;
		System.out.println(sabun+"��(��) �����Ͽ����ϴ�.");
		//disConnection();
		return "���� �Ϸ�";
	}
	
	public void driverClassNameConfig(){
		System.out.println("����Ŭ ����̹� ���");
	}
	
	public void display(){
		for(int i=0;i<=1000000; i++){
			System.out.println(i);
		}
		System.out.println("for�� ����...");
	}
}
