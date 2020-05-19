package com.sist.dao;

import org.springframework.stereotype.Repository;

//메모리 할당
@Repository
public class EmpDAO {
	// AOP 처리는 Spring의 트랜잭션 처리를 반복을 제거한 형태로 작동한다.
	// CRUD에 처리를 함
	public void emp_select() {
		//오라클 연결에서 반드시 반복되는 메소드
		//getConnection disConnection
		//getConnection();
		System.out.println("EMP 테이블에서 데이터를 가지고 온다.");
		//disConnection();
	}
	
	public void emp_insert(String name)
	{
		//getConnection();
		System.out.println(name+"을(를) 추가");
		//disConnection();
	}
	public void emp_update(int sabun, String name){
		//getConnection();
		System.out.println(sabun+"에 해당되는"+name+"을 수정하였습니다.");
		//disConnection();
	}
	
	public String emp_delete(int sabun){
		//getConnection();
		//int a = 10/0;
		System.out.println(sabun+"을(를) 삭제하였습니다.");
		//disConnection();
		return "삭제 완료";
	}
	
	public void driverClassNameConfig(){
		System.out.println("오라클 드라이버 등록");
	}
	
	public void display(){
		for(int i=0;i<=1000000; i++){
			System.out.println(i);
		}
		System.out.println("for문 종료...");
	}
}
