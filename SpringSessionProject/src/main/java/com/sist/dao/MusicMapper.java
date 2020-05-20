package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;

/*
 * 트랜잭션 (일괄처리) -> AOP 처리
 * 
 * public void insert(){}
 * public void update(){}
 * public void delete(){}
 *  
 * @Transactional ================================ 트랜잭션 AOP 활용
 * public String replyInsert()
 * {
 * 	try{
 * 		
 * 		insert() : 정상
 * 		update() : 오류
 * 		insert() : 정상
 * 		
 * 		commit()	=> Around
 * 	}catch (Exception ex){
 *  	rollback()			==> After Throwing
 *  }
 *  finally{
 *  	conn.setAutoCommit 	==> After *  
 *  }
 *  	return  String ==>	After Returning
 * }
 */
public interface MusicMapper {
	@Select("SELECT * FROM music_genie ORDER BY mno ASC")
	public List<MusicVO> musicListData();
	
	@Select("SELECT * FROM music_genie WHERE mno=#{mno}")
	public MusicVO muiscDetailData(int mno);
	
	@Select("SELECT COUNT(*) FROM member "
			+"WHERE id=#{id}")
	public int idCount(String id);
	
	@Select("SELECT pwd FROM member "
			+"WHERE id=#{id}")
	public String memberGetPassword(String id);
}
