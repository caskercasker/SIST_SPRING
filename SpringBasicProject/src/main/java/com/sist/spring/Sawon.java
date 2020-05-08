package com.sist.spring;

public class Sawon {
	private int sabun;
	private String name;
	private String dept;
	
	//매개변수를 통해 접근하는 생성자 사용...
	public Sawon(int sabun, String name, String dept) {
		this.sabun = sabun;
		this.name = name;
		this.dept = dept;
	}

	//매개변수 없는 생성자 사용...
	public Sawon(){
		
	}


	public int getSabun() {
		return sabun;
	}
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public void display(){
		System.out.println("Sawon:display() Call.....");
	}
}
