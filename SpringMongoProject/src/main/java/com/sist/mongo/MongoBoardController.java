package com.sist.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.BoardDAO;
import com.sist.dao.BoardVO;

import java.util.*;

@Controller
public class MongoBoardController {
	@Autowired
	private BoardDAO dao;
	
	@RequestMapping("board/list.do")
	public String board_list(String page,Model model){
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		List<BoardVO> list = dao.boardListData(curpage);
		int totalpage = dao.boardTotalPage();
		
		model.addAttribute("list",list);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("curpage",curpage);
		return "board/list"; 
	}
	
	@RequestMapping("board/insert.do")
	public String board_insert(){
		
		
		return "board/insert";
	}
	
	@RequestMapping("board/insert_ok.do")
	public String board_insert_ok(BoardVO vo){
		
		dao.boardInsert(vo);
		return "redirect:../board/list.do";
	}
}
