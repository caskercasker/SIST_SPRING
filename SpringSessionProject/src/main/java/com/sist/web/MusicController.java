package com.sist.web;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.dao.*;

/* 
 * {} => ROW
 * [{},{},{}] 
 */
@RestController
public class MusicController {
	
	@Autowired
	private MusicDAO dao;
	
	@RequestMapping("main/music.do")
	public String main_list(){
		String result="";
		List<MusicVO> list = dao.musicListData();
		
		//JSON 으로 값을 넘기기 [ ]
		JSONArray arr = new JSONArray();
		for(MusicVO vo:list){
			JSONObject json = new JSONObject();
			json.put("mno", vo.getMno());
			//json.put("rank", vo.getRank());
			json.put("title",vo.getTitle());
			json.put("singer", vo.getSinger());
			json.put("album", vo.getAlbum());
			json.put("poster", vo.getPoster());
			json.put("idcrement", vo.getIdcrement());
			json.put("state",vo.getState());
			//json.put("key", vo.getKey());
			//json.put("hit", vo.getHit());
			
			arr.add(json);
		}
		result = arr.toJSONString();
		System.out.println(result);
		return result;
	}
}
