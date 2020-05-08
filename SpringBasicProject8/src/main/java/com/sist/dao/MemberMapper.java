package com.sist.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import java.util.*;
//�⺻ mybatix XML�� ������̼����� ���� ��Ű��.

public interface MemberMapper {
	@SelectKey(keyProperty="no",resultType=int.class,before=true,statement="SELECT NVL(MAX(no)+1,1) as no FROM spring_member")
	
	@Insert("INSERT INTO spring_member VALUES("
			+ "#{no},#{name},#{sex},#{addr},#{tel})")
	public void memberInsert(MemberVO vo);
	//     resultType=>������		parameterType=>�Ű����� , id=�޼ҵ��
	//�Լ� ������ �ڽ� ����ü����
	//SQL ������ �Ѱ��ش�.
	
	
	/*
	 * <select id="memberAllData" resultType="MemberVO">
	 * 	SELECT * FROM spring_member
	 * </select>
	 */
	@Select("SELECT * FROM spring_member")
	public List<MemberVO> memberAllData();
	
	@Select("SELECT * FROM spring_member "
			+"WHERE no=#{no}")
	public MemberVO memberDetailData(int no);
}
