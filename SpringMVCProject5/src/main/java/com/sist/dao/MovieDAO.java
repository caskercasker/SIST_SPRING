package com.sist.dao;
import org.springframework.stereotype.Repository;

import java.util.*;
import com.mongodb.*;

@Repository
public class MovieDAO {
	private MongoClient mc; //Connection
	private DB db;	//DataBase (XE)
	private DBCollection dbc;  //Table
	
	public MovieDAO(){
		try {
			mc = new MongoClient("localhost",27017);
			db = mc.getDB("mydb");
			dbc = db.getCollection("movie");
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}
	}
	// {mno:100, title:'',.......} ==> BasicDBObject
	public void movieInsert(MovieVO vo){
		try {
			BasicDBObject obj = new BasicDBObject();
			obj.put("mno", vo.getMno());
			obj.put("title", vo.getTitle());
			obj.put("poster", vo.getPoster());
			obj.put("genre",vo.getGenre());
			obj.put("grade",vo.getGrade());
			obj.put("director",vo.getDirector());
			obj.put("actor",vo.getActor());
			obj.put("story",vo.getStory());
			
			dbc.insert(obj);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public List<MovieVO> movieListData(int page){
		List<MovieVO> list = new ArrayList<MovieVO>();
		try {
			int rowSize = 12;
			//앞에 데이터는 버리고 가져올 데이터만 가져온다 몽고DB
			int skip = (rowSize*page)-rowSize;
			DBCursor cursor = dbc.find().skip(skip).limit(rowSize);
			while(cursor.hasNext()){
				BasicDBObject obj = (BasicDBObject)cursor.next();
				MovieVO vo = new MovieVO();
				vo.setMno(obj.getInt("mno"));
				vo.setTitle(obj.getString("title"));
				vo.setPoster(obj.getString("poster"));
				
				list.add(vo);
			}
			cursor.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
		
	}
	
	/*
	 * 분산 데이터 처리
	 * NoSQL => SQL 이 존재하지 않고 함수를 이용해서 처리 
	 * 
	 * 
	 */
	public int movieTotalPage(){
		int total=0;
		try {
			
			//SELECT CEIL(count(*)/12.0) FROM movie
			int count = (int)dbc.count(); //함수로 전체 개수를 구함
			
			//SELECT COUNT(*) FROM movie
			total=(int)(Math.ceil(count/12.0)); //자바를 통해서 pagination 올림함수 사용. 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return total;
	}
	
	public List<MovieVO> movieFindData(String fd){
		//SELECT * FROM movie WHERE title LIKE '%fd%'
		// find({"title",{"$regex","*."+fd}})
		// find({no:1})
		List<MovieVO> list = new ArrayList<MovieVO>();
		try {
			//조건에 따른 검색 결과를 담고 있는 object.... 오브젝트 단위로 실행한다.
			//
			BasicDBObject where = new BasicDBObject("title",new BasicDBObject("$regex",".*"+fd));
			
			//ResultSet과 같은기능
			DBCursor cursor = dbc.find(where);
			while(cursor.hasNext()){
				BasicDBObject obj = (BasicDBObject)cursor.next();
				// {}
				MovieVO vo = new MovieVO();
				//검색결과에 대한 mno 처리를 위해 값을 세팅해주어야 한다. 
				vo.setMno(obj.getInt("mno"));
				vo.setTitle(obj.getString("title"));
				vo.setPoster(obj.getString("poster"));
				list.add(vo);
			}
			cursor.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	public MovieVO movieDetailData(int mno){
		MovieVO vo = new MovieVO();
		try {
			BasicDBObject where = new BasicDBObject("mno",mno);
			//하나의 값만 찾아올 경우 메소드 findOne()을 사용함. 
			
			BasicDBObject res = (BasicDBObject) dbc.findOne(where);
			
			vo.setMno(res.getInt("mno"));
			vo.setTitle(res.getString("title"));
			vo.setActor(res.getString("actor"));
			vo.setDirector(res.getString("director"));
			vo.setPoster(res.getString("poster"));
			vo.setGenre(res.getString("genre"));
			vo.setGrade(res.getString("grade"));
			vo.setStory(res.getString("story"));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return vo;
	}
}
