package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Repository
public class ReplyDAO {
	@Autowired
	private ReplyMapper mapper;
	
	public void replyInsert(ReplyVO vo){
		mapper.replyInsert(vo);
	}
	
	public List<ReplyVO> replyListData(int mno){
		return mapper.replyListData(mno);
	}
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void replyReplyInsert(int pno,ReplyVO vo){
		
		ReplyVO pvo = mapper.replyParentInfoData(pno);
		mapper.replyGroupsStepIncrement(pvo);
		vo.setGroup_id(pvo.getGroup_id());

		//하나씩 증가
		vo.setGroup_step(pvo.getGroup_step()+1);
		vo.setGroup_tab(pvo.getGroup_tab()+1);
		vo.setRoot(pno);;
		mapper.reply_Reply_Insert(vo);
		mapper.replyDepthIncrement(pno);
	}
	
	public void replyUpdate(ReplyVO vo){
		mapper.replyUpdate(vo);
	}
	
	public void replyDelete(int no){
		mapper.replyDelete(no);
	}
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void replyReplyDelete(int no){
		
		ReplyVO vo = mapper.replyInfoData(no);  //depth,root

		if(vo.getDepth()==0){
			mapper.replyDelete(no);
		}else{
			String ss = "관리자가 삭제한 게시물 입니다.";
			ReplyVO rvo = new ReplyVO();
			rvo.setNo(no);
			rvo.setMsg(ss);
			mapper.replyMsgUpdate(rvo);
		}
		
		mapper.replyDepthDecrement(vo.getRoot());
	}
}
