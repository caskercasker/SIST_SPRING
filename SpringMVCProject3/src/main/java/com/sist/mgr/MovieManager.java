package com.sist.mgr;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;
import java.util.*;

import javax.xml.stream.util.StreamReaderDelegate;

import java.io.*;
import java.net.*;


@Component
public class MovieManager {
	public static void main(String[] args) {
		MovieManager m = new MovieManager();
		m.movieGetJson("searchMainDailyBoxOffice.do");
		System.out.println("ppp");
	}
	public String movieGetJson(String url){
		String json="";
		try {
			URL strUrl = new URL("http://www.kobis.or.kr/kobis/business/main/"+url);
			HttpURLConnection conn = (HttpURLConnection)strUrl.openConnection();
			//���� ���� ���۸� ���� 
			
			StringBuffer sb = new StringBuffer();
			
			//������ �ִٸ� 
			if(conn!=null){
				//Ŀ�ؼǿ��� ������ �����͸� ���ڵ� �ؼ� inpustream�� ���� ���� , ���� �������ٰ� �ִ´�. 
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
				while(true){
					//���۸����� ���� ���� ���� ������ �����  �� ���� ���ڿ� ���ۿ� �ִ´�.
					String temp = br.readLine();
					if(temp==null)
						break;
					sb.append(temp);

				}
				
			}
			//stringBuffer�� stringfy �Ѵ�???
			json = sb.toString();
			
			//Jsoup�� ���� �����Ͱ� HTML tag�� �Բ� ����.
			
/*			Document doc = Jsoup.connect("http://www.kobis.or.kr/kobis/business/main/"+url).get();
			json=doc.toString();*/
			
			System.out.println(json);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return json;
	}
}
