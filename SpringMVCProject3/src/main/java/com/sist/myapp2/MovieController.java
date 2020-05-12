package com.sist.myapp2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import com.sist.dao.*;
import com.sist.mgr.NewsManager;
import com.sist.mgr.NewsVO;

@Controller
@RequestMapping("movie/")
public class MovieController {
	@Autowired
	private MovieDAO dao;
	
	@Autowired
	private NewsManager mgr;
	
/*	@RequestMapping("main/main.do")
	public String main_main(){
		return "main/main";
	}*/
	//==> MainController 에 코딩 
	
	
	@RequestMapping("list.do")
	public String movie_list(Model model,String page){
		if(page==null)
			page="1";
		int curpage = Integer.parseInt(page);
		int rowSize = 12;
		int start = (curpage*rowSize)-(rowSize-1);
		int end = curpage*rowSize;
		//프로그램 => 시작
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("end", end);
		map.put("type", 1);
		
		//DAO에서 데이터 받기
		List<MovieVO> list = dao.movieListData(map);
		int totalpage = dao.movieTotalPage(1);
		model.addAttribute("list",list);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("curpage",curpage);
		model.addAttribute("main_jsp","../movie/list.jsp");
		model.addAttribute("title", "현재상영영화");
		return "main/main";
	}
	@RequestMapping("shc.do")
	public String movie_shc(Model model,String page){
		if(page==null)
			page="1";
		int curpage = Integer.parseInt(page);
		int rowSize = 12;
		int start = (curpage*rowSize)-(rowSize-1);
		int end = curpage*rowSize;
		//프로그램 => 시작
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("end", end);
		map.put("type", 2);
		
		//DAO에서 데이터 받기
		List<MovieVO> list = dao.movieListData(map);
		int totalpage = dao.movieTotalPage(2);
		model.addAttribute("list",list);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("curpage",curpage);
		model.addAttribute("main_jsp","../movie/list.jsp");
		model.addAttribute("title", "개봉예정영화");
		return "main/main";
	}
	@RequestMapping("box.do")
	public String movie_box(Model model,String page){
		if(page==null)
			page="1";
		int curpage = Integer.parseInt(page);
		int rowSize = 12;
		int start = (curpage*rowSize)-(rowSize-1);
		int end = curpage*rowSize;
		//프로그램 => 시작
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("end", end);
		map.put("type", 5);
		
		//DAO에서 데이터 받기
		List<MovieVO> list = dao.movieListData(map);
		int totalpage = dao.movieTotalPage(5);
		model.addAttribute("list",list);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("curpage",curpage);
		model.addAttribute("main_jsp","../movie/list.jsp");
		model.addAttribute("title", "박스오피스");
		return "main/main";
	}
	
	@RequestMapping("news.do")
	public String movie_news(Model model){
		
		List<NewsVO> list = mgr.newsALLData();
		model.addAttribute("list",list);
		model.addAttribute("main_jsp", "../movie/news.jsp");
		return "main/main";
	}
	
	@RequestMapping("detail.do")
	public String movie_detail(Model model,int mno){
		
		MovieVO vo = dao.movieDetailData(mno);
		model.addAttribute("vo",vo);
		model.addAttribute("main_jsp","../movie/detail.jsp");
		return "main/main";
	}
}
