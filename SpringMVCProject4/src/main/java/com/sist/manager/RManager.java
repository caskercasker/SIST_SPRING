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
/*	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
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
			fw.close();
			//csv ������ �޸��� �����ؼ� ����.
			
			
			RConnection rc = new RConnection();
			
			//R ��ɾ ������ method => Rserve �� ������.
			//��Ʈ�� ������ ������(sep)
			//
			rc.voidEval("emp<-read.csv(\"c:/upload/emp.csv\",header=T,sep=\",\")");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}*/
	//C:\springDev\springStudy\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\SpringMVCProject4\board
	public void rGraph(int no){
		try {
			//R ���� => Rserve ����
			//default localhost 
			RConnection rc = new RConnection();
			rc.voidEval("library(rJava)"); //import
			rc.voidEval("library(KoNLP)"); //import
			rc.voidEval("library(wordcloud)");
			//���� ���� ��ġ�� ���ϸ� ���� Ȯ���� ����
			rc.voidEval("png(\"C:/springDev/springStudy/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/SpringMVCProject4/board/"+no+".png\",width=700,height=450)");
			//txt ���Ͽ��� ���ڿ� �б�
			rc.voidEval("data<-readLines(\"C:/data/board.txt\")");
			//��� ����
			rc.voidEval("data2<-sapply(data,extractNoun,USE.NAMES = F)");
			//������ �迭 ����
			rc.voidEval("data3<-unlist(data2)");
			//gsub = replace �Լ� �ѱ��� �ƴ� ���� �������� ó�� 
			rc.voidEval("data3<-gsub(\"[A-Za-z]\",\"\",data3)");
			rc.voidEval("data3<-gsub(\"[0-9]\",\"\",data3)");
			rc.voidEval("data3<-Filter(function(x){nchar(x)>=2},data3)");
			rc.voidEval("data4<-table(data3)");
			//
			rc.voidEval("data5<-head(sort(data4,decreasing = T),10)");
			//rc.voidEval("barplot(data5,col=rainbow(15))");
			rc.voidEval("wordcloud(names(data5),freq=data5,scale=c(5,1),rot.per=0.25,min.freq=2,random.order = F,colors=rainbow(15))");
			rc.voidEval("dev.off()");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
