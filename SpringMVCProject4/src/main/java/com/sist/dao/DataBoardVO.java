package com.sist.dao;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

/*
 * ������ �̽����� �Է� â�� ��� ������ ó���ϱⰡ �������.... ��  
 * 
 * <input type="text" name="names[0]"/>
 * <input type="text" name="names[1]"/>
 * <input type="text" name="names[2]"/>
 * <input type="text" name="names[3]"/>
 * <input type="text" name="names[4]"/>
 * 
 * => List<String> names;  
 * 
 * Arrays.asList(�迭)
 * 
 * 
 * �迭 ������ HTML ���� �ϸ� LIST���� �Ѳ����� ������ �ִ�. 
 * ������ ���������� JSP ���� ó���ϴ� request ������ model���� ��� ó���Ѵ�. 
 * �� ȭ�� MVC ���� ��𿡼��� Ȱ�밡���� �����Ͱ� 
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
	
	//�������� ������ ���ÿ� ���ε� �ϱ� ���ؼ� �����س��� Collection List
	private List<MultipartFile> files;
	
}
