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
/*	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
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
			fw.close();
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
	}*/
	//C:\springDev\springStudy\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\SpringMVCProject4\board
	public void rGraph(int no){
		try {
			//R 연결 => Rserve 동작
			//default localhost 
			RConnection rc = new RConnection();
			rc.voidEval("library(rJava)"); //import
			rc.voidEval("library(KoNLP)"); //import
			rc.voidEval("library(wordcloud)");
			//파일 저장 위치와 파일명 파일 확장자 설정
			rc.voidEval("png(\"C:/springDev/springStudy/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/SpringMVCProject4/board/"+no+".png\",width=700,height=450)");
			//txt 파일에서 문자열 읽기
			rc.voidEval("data<-readLines(\"C:/data/board.txt\")");
			//명사 추출
			rc.voidEval("data2<-sapply(data,extractNoun,USE.NAMES = F)");
			//이차원 배열 해제
			rc.voidEval("data3<-unlist(data2)");
			//gsub = replace 함수 한글이 아닌 것은 공백으로 처리 
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
