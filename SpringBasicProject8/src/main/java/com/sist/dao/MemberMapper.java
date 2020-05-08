package com.sist.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import java.util.*;
//기본 mybatix XML을 어노테이션으로 적용 시키기.

public interface MemberMapper {
	@SelectKey(keyProperty="no",resultType=int.class,before=true,statement="SELECT NVL(MAX(no)+1,1) as no FROM spring_member")
	
	@Insert("INSERT INTO spring_member VALUES("
			+ "#{no},#{name},#{sex},#{addr},#{tel})")
	public void memberInsert(MemberVO vo);
	//     resultType=>리턴현		parameterType=>매개변수 , id=메소드명
	//함수 구현은 자식 구현체들이
	//SQL 문장은 넘겨준다.
	
	
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
