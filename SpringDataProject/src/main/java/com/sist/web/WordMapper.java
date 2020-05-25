package com.sist.web;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	
	//Longwritable 줄 번호  => text 한줄을 받아옴  ex> 1
	//Text 문자열
	// Text,Inwritable => ex> Java ,1 로 저장 
	
	
	//상수 -  단어 하나당 1을 부여 한다.
	private final IntWritable one = new IntWritable(1);
	
	private Text keyValue = new Text();
		
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		
		//문자열을 자른다. 공백을 기준으로 자름.
		//value 의 타입은 Text ==> StringTokenizer 를 사용하기 위해 변환 시켜야 한다. 
		StringTokenizer st = new StringTokenizer(value.toString());
		
		while(st.hasMoreTokens()){
			//String을 text로 다시 바꿔서 저장해야됨.
			keyValue.set(st.nextToken());   //String=> Text로 바꾸는 형식
			
			//context 에 자른 값을 저장 한다.	
			context.write(keyValue, one);
		}
	}
}
