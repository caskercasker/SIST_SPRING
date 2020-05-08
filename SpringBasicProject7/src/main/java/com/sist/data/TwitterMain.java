package com.sist.data;

import twitter4j.FilterQuery;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

public class TwitterMain {
	public static void main(String[] args) {
		
	try
	{
		//io 통신을 위한 공간을 만듬.
		TwitterStream ts = new TwitterStreamFactory().getInstance();
		String[] data={"용인확진자","EXO"};
		
		TwitterListener listener = new TwitterListener();
		
		//리스터는 만든다
		//리스너와 통로를 연결   => 배열이 넘어갈때마다 onstate 호출 
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
