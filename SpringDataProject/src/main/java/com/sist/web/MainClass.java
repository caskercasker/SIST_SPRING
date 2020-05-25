package com.sist.web;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class MainClass {
	public static void main(String[] args) {
		try {
			Configuration conf = new Configuration();
			System.setProperty("hadoop.home.dir", "C:\\winutils");
			
			// hadoop을 불러온다.
			// hadoop => 여러 유저가 수집한 데이터를 저장하는 장소
			// 네트워크를 통해 값을 모아온다.
			Job job = Job.getInstance(conf,"WordCount");
			job.setJarByClass(MainClass.class);
			job.setMapperClass(WordMapper.class);
			job.setReducerClass(WordReduce.class);
			
			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(IntWritable.class);
			
			System.out.println(job);
/*			
			FileInputFormat.addInputPath(job, new Path("./input.txt"));
			FileOutputFormat.setOutputPath(job, new Path("./output.txt"));*/
			
			job.waitForCompletion(true);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
}
