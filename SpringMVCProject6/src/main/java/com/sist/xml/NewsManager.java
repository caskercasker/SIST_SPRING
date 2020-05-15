package com.sist.xml;
import java.util.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import org.springframework.stereotype.Component;

import java.net.*;
// newssearch.naver.com/search.naver?where=rss&query=��ȭ

@Component
public class NewsManager {
	public List<Item> newsAllData(String fd){
		
		List<Item> list = new ArrayList<Item>();
		try {
			
			//List<Item> list = new ArrayList<Item>();
			// �����ϴ� CLASS ���ε� context �� �������� ��ü�� �����ؾ� ��.
			JAXBContext jc = JAXBContext.newInstance(RSS.class);
			Unmarshaller un = jc.createUnmarshaller();
			URL url = new URL("http://newssearch.naver.com/search.naver?where=rss&query="
							+URLEncoder.encode(fd,"UTF-8"));
			RSS rss = (RSS)un.unmarshal(url);
			list = rss.getChannel().getItem();
	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
}
