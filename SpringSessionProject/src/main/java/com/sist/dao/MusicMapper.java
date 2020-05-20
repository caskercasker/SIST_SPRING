package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;

/*
 * Ʈ����� (�ϰ�ó��) -> AOP ó��
 * 
 * public void insert(){}
 * public void update(){}
 * public void delete(){}
 *  
 * @Transactional ================================ Ʈ����� AOP Ȱ��
 * public String replyInsert()
 * {
 * 	try{
 * 		
 * 		insert() : ����
 * 		update() : ����
 * 		insert() : ����
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
