package com.sist.data;

import twitter4j.FilterQuery;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

public class TwitterMain {
	public static void main(String[] args) {
		
	try
	{
		//io ����� ���� ������ ����.
		TwitterStream ts = new TwitterStreamFactory().getInstance();
		String[] data={"����Ȯ����","EXO"};
		
		TwitterListener listener = new TwitterListener();
		
		//�����ʹ� �����
		//�����ʿ� ��θ� ����   => �迭�� �Ѿ������ onstate ȣ�� 
		ts.addListener(listener);
		
		//
		FilterQuery fq = new FilterQuery();
		fq.track(data);
		
		//
		ts.filter(fq);
		
	}catch(Exception ex){
		ex.printStackTrace();
		}
	}
}
