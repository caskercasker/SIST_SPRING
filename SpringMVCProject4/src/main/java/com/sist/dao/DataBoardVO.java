package com.sist.dao;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

/*
 * 저번에 이슈였던 입력 창에 묶어서 보내서 처리하기가 힘들었다.... ㅜ  
 * 
 * <input type="text" name="names[0]"/>
 * <input type="text" name="names[1]"/>
 * <input type="text" name="names[2]"/>
 * <input type="text" name="names[3]"/>
 * <input type="text" name="names[4]"/>
 * 
 * => List<String> names;  
 * 
 * Arrays.asList(배열)
 * 
 * 
 * 배열 형식의 HTML 값을 하면 LIST에서 한꺼번에 묶을수 있다. 
 * 이유는 스프링에서 JSP 에서 처리하는 request 값들을 model에서 묶어서 처리한다. 
 * 즉 화면 MVC 구조 어디에서는 활용가능한 데이터가 
 *
 */


@Getter
@Setter
public class DataBoardVO {
	private int no;
	private String name;
	private String subject;
	private String pwd;
	private String content;
	private Date regdate;
	private int hit;
	private String filename;
	private String filesize;
	private int filecount;
	
	//여러개의 파일을 동시에 업로드 하기 위해서 저장해놓은 Collection List
	private List<MultipartFile> files;
	
}
