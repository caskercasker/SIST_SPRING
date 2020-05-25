package com.sist.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import java.util.*;

public interface ReplyMapper {
	//select keys는 한번만 사용 가능
	// 실행한 결과값은 keyproperty의 no에 값을 집어 넣는다.(Alias)
	@SelectKey(keyProperty="no",resultType=int.class, before=true,
				statement="SELECT NVL(MAX(no)+1,1) as no FROM music_reply2")
	@Insert("INSERT INTO music_reply2(no,mno,id,msg,group_id) VALUES("
			+ "#{no}, #{mno}, #{id}, #{msg},"
			+"(SELECT NVL(MAX(group_id)+1,1) FROM music_reply2))")
	public void replyInsert(ReplyVO vo);
	// group id는 같으나 sequence와 일치하지 않는다.
	
	
	//시간을 표시하기 위해 오라클에서 실행
	@Select("SELECT no,mno,id,msg,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday ,group_tab FROM music_reply2 WHERE mno=#{mno} "
			+ "ORDER BY group_id DESC,group_step ASC")
	public List<ReplyVO> replyListData(int mno);
	
	//트랜잭션 처리
	//@Select 
	@Select("SELECT group_id,group_step,group_tab "
			+"FROM music_reply2 "
			+"WHERE no=#{no}")
	public ReplyVO replyParentInfoData(int no);
	//@Update
	@Update("UPDATE music_reply2 SET "
			+"group_step=group_step+1 "
			+"WHERE group_id=#{group_id} AND group_step>#{group_step}")
	public void replyGroupsStepIncrement(ReplyVO vo);
	//@Insert
	@SelectKey(keyProperty="no",resultType=int.class, before=true,
			statement="SELECT NVL(MAX(no)+1,1) as no FROM music_reply2")
	@Insert("INSERT INTO music_reply2(no,mno,id,msg,group_id,group_step,group_tab,root) VALUES("
			+ "#{no}, #{mno}, #{id}, #{msg},"
			+"#{group_id},#{group_step},#{group_tab},#{root})")
	public void reply_Reply_Insert(ReplyVO vo);
	//@Update - 댓글이 입력된 경우 depth를 올림
	@Update("UPDATE music_reply2 SET "
			+"depth=depth+1 "
			+"WHERE no=#{no}")
	public void replyDepthIncrement(int no);
	
	//######################################################################
	@Update("UPDATE music_reply2 SET "
			+"msg=#{msg} "
			+"WHERE no=#{no}")
	public void replyUpdate(ReplyVO vo);
	
	
	//################################################삭제시 트랜잭션
	/*
	 * @ deptah,root
	 * depth==0, 
	 * @ DELETE
	 * depth!=0
	 * @Update
	 * 
	 * @depth 감소
	 */
	
	@Select("SELECT depth,root from music_reply2 "
			+ "WHERE no=#{no}")
	public ReplyVO replyInfoData(int no);
	
	
	@Delete("DELETE FROM music_reply2 "
			+"WHERE no=#{no}")
	public void replyDelete(int no);
	
	@Update("UPDATE music_reply2 SET "
			+ "msg=#{msg} WHERE no=#{no}")
	public void replyMsgUpdate(ReplyVO vo);
	
	
	@Update("UPDATE music_reply2 SET "
			+"depth=depth-1 "
			+"WHERE no=#{no}")
	public void replyDepthDecrement(int no);
}
