package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;


public interface BoardMapper {
	@Select("SELECT no,subject,name,regdate,hit,num "
			+"FROM (SELECT no,subject,name,regdate,hit,rownum as num "
			+"FROM (SELECT no,subject,name,regdate,hit "
			+"FROM board ORDER BY no DESC)) "
			+"WHERE num BETWEEN #{start} AND #{end}")
	public List<BoardVO> boardListData(Map map);
	
	//총 페이지 구하기
	@Select("SELECT CEIL(COUNT(*)/10.0) FROM board")
	public int boardTotalPage();
	
	@SelectKey(statement="SELECT NVL(MAX(no)+1,1) as no FROM board",keyProperty="no", resultType=int.class, before=true)
	@Insert("INSERT INTO board VALUES("
			+"#{no}, #{name}, #{subject}, #{content}, #{pwd},SYSDATE,0)")
	public void boardInsert(BoardVO vo);
	
	// 상세보기
	@Update("UPDATE board SET hit=hit+1 "
			+"WHERE no=#{no}")
	public void hitIncrement(int no);
	
	@Select("SELECT * FROM board "
			+"WHERE no=#{no}")
	public BoardVO boardDetailData(int no);
	
	//수정하기
	@Select("SELECT pwd FROM board "
			+"WHERE no=#{no}")
	public String boardGetPwd(int no);
	
	@Update("UPDATE board SET "
			+"name=#{name},subject=#{subject},content=#{content} "
			+"WHERE no=#{no}")
	public void boardUpdate(BoardVO vo);
	
	@Delete("DELETE FROM board WHERE no=#{no}")
	public void boardDelete(int no);
}
