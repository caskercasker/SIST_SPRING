package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class MemberDAO {
	@Autowired
	private MemberMapper mapper;
	
	public List<MemberVO> memberAllData(){
		return mapper.memberAllData();
	}
	
	public MemberVO memberDetailData(int no){
		return mapper.memberDetailData(no);
	}
	
	public void memberInsert(MemberVO vo){
		mapper.memberInsert(vo);
	}
}
