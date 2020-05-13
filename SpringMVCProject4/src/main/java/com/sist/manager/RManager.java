package com.sist.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.rosuda.REngine.Rserve.RConnection;
import org.springframework.stereotype.Component;
import java.io.*;
/*
 * Spring ==> 수집(Hadoop) => mapreduce,spark====> R ====> React
 * 							================
 * 							mongoDB
 * 
 */
@Component
public class RManager {
	public static void main(String[] args) {
		try {
/*			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			Connection conn = DriverManager.getConnection(url,"hr","happy");
			
			String sql="SELECT empno,ename,job,sal FROM emp";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			//엑셀 첫번째 행 만들기
			String temp = "empno,ename,job,sal\n";
			
			//엑셀에 값 넣기.
			while(rs.next()){
				temp+=rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getInt(4)+"\n";
			}
			rs.close();
			ps.close();
			conn.close();
			
			temp=temp.substring(0,temp.lastIndexOf("\n"));
			
			FileWriter fw = new FileWriter("c:\\upload\\emp.csv");
			fw.write(temp);
			fw.close();*/
			//csv 파일을 콤마로 구분해서 만듬.
			
			
			RConnection rc = new RConnection();
			
			//R 명령어를 보내는 method => Rserve 로 보낸다.
			//루트명 슬래스 구분자(sep)
			//
			rc.voidEval("emp<-read.csv(\"c:/upload/emp.csv\",header=T,sep=\",\")");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
