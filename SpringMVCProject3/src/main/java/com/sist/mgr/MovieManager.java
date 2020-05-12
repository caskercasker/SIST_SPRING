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
			//값을 받을 버퍼를 생성 
			
			StringBuffer sb = new StringBuffer();
			
			//연결이 있다면 
			if(conn!=null){
				//커넥션에서 가져온 데이터를 인코딩 해서 inpustream에 들어온 것을 , 버퍼 리더에다가 넣는다. 
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
				while(true){
					//버퍼리더가 있은 값을 한줄 한줄이 비엇을  때 까지 문자열 버퍼에 넣는다.
					String temp = br.readLine();
					if(temp==null)
						break;
					sb.append(temp);

				}
				
			}
			//stringBuffer를 stringfy 한다???
			json = sb.toString();
			
			//Jsoup을 통한 데이터가 HTML tag와 함꼐 들어옴.
			
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
