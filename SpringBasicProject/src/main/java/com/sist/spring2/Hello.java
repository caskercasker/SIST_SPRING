package com.sist.spring2;

// 1.8
public interface Hello	{
	public void display();
	
	//구현한 메소드를 가지고 갈 수 있다.
	public default void sayHello(){}
	public static void sayHello2(){}
}
