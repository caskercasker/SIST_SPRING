package com.sist.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.*;

@Repository
public class BoardDAO {
	@Autowired
	private MongoTemplate mt;

	public List<BoardVO> boardListData(int page){
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		//mongodb.core.query.Query --> 몽고디비에서 JSON을 만들어야 find 함수를 이용해서 데이터를 찾아 올수 있다. ex> find({no:1}) 
		//RDB 의 SQL = "SELECT ~~ WHERE no=1"
		Query query = new Query();
		int rowSize=10;
		int skip=(rowSize*page)-rowSize;
		
		//find 메소드에 시작점 skip, 끝점을 limit로 만듬
		query.skip(skip).limit(rowSize);
		//쿼리로 가져올 값을 정렬할 기준 

		//2.0.0 버전에서 존재하는 Sort 
		//정렬  ex> RDB의 ORDER BY no DESC
		
		//query.with(Sort.by("DESC", "no"));
		query.with(new Sort(Sort.Direction.DESC,"no"));

		//List<BoardVO>	find의 default return 형은 list, 따라서 반환값은 BoardVO.class로 형변환
		list = mt.find(query, BoardVO.class,"board");  
		
		return list;
	}
	
	public int boardTotalPage(){
		int total=0;
		Query query = new Query();// 조건 없은 검색  - DEFAULT find({})
		
		//RDB 의 SELECT COUNT(*) FROM board; 
		//빅데이터는 데이터가 많기 때문에  기본 타입이 long 형태
		//몽고 디비를 임시 저장소로 사용한다?
		int count = (int) mt.count(query, "board");
		total = (int)(Math.ceil(count/10.0));
		
		return total;
	}
	public void boardInsert(BoardVO vo){
		//
		BoardVO rvo = new BoardVO();
		Query query = new Query();
		
		//query.with(Sort.by("DESC", "no"));
		query.with(new Sort(Sort.Direction.DESC,"no"));
		rvo=mt.findOne(query, BoardVO.class,"board");
		System.out.println(rvo.getNo()+1);
		vo.setNo(rvo.getNo()+1); //SELECT max(no)+1
		vo.setRegdate(new SimpleDateFormat("yyyy-MM-dd").format(new Date())); //SYSDATE삽입
		vo.setHit(0);
		
		
		mt.insert(vo, "board");
	}
	
	public BoardVO bordDetailData(int no){
		BoardVO vo = new BoardVO();
		BasicQuery query = new BasicQuery("{no:"+no+"}");
		Update update = new Update();
		vo=mt.findOne(query, BoardVO.class,"board"); //find= list, findOne=Object
		update.set("hit", vo.getHit()+1);//조회수 증가
		mt.updateFirst(query, update, "board");
		vo=mt.findOne(query, BoardVO.class,"board");
		
		return vo;
	}
	
	public boolean boardUpdate(BoardVO vo){
		boolean bCheck=false;
		BasicQuery query = new BasicQuery("{no:"+vo.getNo()+"}");
		BoardVO dbvo = mt.findOne(query, BoardVO.class,"board");
		if(vo.getPwd().equals(dbvo.getPwd())){
			bCheck=true;
			Update update=new Update();
			update.set("name", vo.getName());
			update.set("subject", vo.getSubject());
			update.set("content", vo.getContent());
			mt.updateFirst(query, update, BoardVO.class);
		}
		
		return bCheck;
	}
}
