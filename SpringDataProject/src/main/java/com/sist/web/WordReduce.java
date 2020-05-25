package com.sist.web;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

//작업 단위가 재귀형식으로 돌아가는것 같이 않다.
//2개의 map을 묶어서 처리한다.
// 1,1,1,1,1,1==> 6
public class WordReduce extends Reducer<Text, IntWritable, Text, IntWritable>{
	
	private IntWritable val = new IntWritable();

	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,
			Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {
	
		int sum = 0;
		
		for (IntWritable i : values) {
				sum += i.get(); //받아온 intwritable 을 정수형으로 넣음. 
		}
		val.set(sum);//다시 Intwritable 로 변환, 바꾸지 않으면 context에서 인식하지 못함.
		context.write(key, val);
	}
}
