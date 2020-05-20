package com.sist.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class MusicDAO {
	@Autowired
	private MusicMapper mapper;
	
	public List<MusicVO> musicListData(){
		return mapper.musicListData();
	}
	
	public MusicVO muiscDetailData(int mno){
		return mapper.muiscDetailData(mno);
	}
	
	public int idCount(String id){
		return mapper.idCount(id);
	}
	
	// ssf.opensession(true)
	
	public String memberGetPassword(String id){
		return mapper.memberGetPassword(id);
	}
}
