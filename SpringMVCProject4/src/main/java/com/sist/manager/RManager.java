package com.sist.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.rosuda.REngine.Rserve.RConnection;
import org.springframework.stereotype.Component;
import java.io.*;
/*
 * Spring ==> ����(Hadoop) => mapreduce,spark====> R ====> React
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
			
			//���� ù��° �� �����
			String temp = "empno,ename,job,sal\n";
			
			//������ �� �ֱ�.
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
			//csv ������ �޸��� �����ؼ� ����.
			
			
			RConnection rc = new RConnection();
			
			//R ���ɾ ������ method => Rserve �� ������.
			//��Ʈ�� ������ ������(sep)
			//
			rc.voidEval("emp<-read.csv(\"c:/upload/emp.csv\",header=T,sep=\",\")");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}