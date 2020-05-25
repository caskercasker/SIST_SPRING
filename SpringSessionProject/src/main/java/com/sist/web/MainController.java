package com.sist.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.MusicDAO;
import com.sist.dao.MusicVO;
import com.sist.dao.ReplyDAO;
import com.sist.dao.ReplyVO;

@Controller
public class MainController {
	
	@Autowired
	private MusicDAO dao;
	
	@Autowired
	private ReplyDAO rDao;
	
	@RequestMapping("main/list.do")
	public String main_list(){
		return "main/list";
	}
	
	@RequestMapping("main/detail.do")
	public String main_detail(int mno,Model model){
		
		MusicVO vo = dao.muiscDetailData(mno);
		JSONObject json = new JSONObject(); //[{mno:1, title:''},{} ]
		json.put("mno",vo.getMno());
		json.put("title",vo.getTitle());
		json.put("singer",vo.getSinger());
		json.put("album",vo.getAlbum());
		json.put("state",vo.getState());
		json.put("idcrement",vo.getMno());
		json.put("poster",vo.getPoster());
		json.put("key",vo.getKey());
		
		
		model.addAttribute("json",json.toJSONString());
		model.addAttribute("mno",mno);
		
		List<ReplyVO> rlist=rDao.replyListData(mno);
		model.addAttribute("rlist",rlist);
		return "main/detail";
	}
	
	@GetMapping("main/login.do")
	public String main_login(){
		return "main/login";
	}
	// request,response,session.pageContext,page,exception,config,out => DispatcherServlet
	
	// list.do
	// invoke(Object ... obj)
	
	//session 처리 매개변수 확인
	
	// Cookie cook = new Cookie()
	// ==> response.addCookie(cook)
	// 다운로드 => response
	@PostMapping("main/login_ok.do")
	public String main_login_ok(String id,String pwd,Model model,HttpSession session ){
		
		String result="";
		int count = dao.idCount(id);
		if(count==0) //ID 가 없는 경우
		{
			result = "NOID";
		}else //ID가 존재하는 경우 
		{
			String db_pwd=dao.memberGetPassword(id);
			if(db_pwd.equals(pwd)){
				result="OK";
				session.setAttribute("id", id);
			}
			else{
				result="NOPWD";
			}
		}
		model.addAttribute("result",result);
		return "main/login_ok";
	}
	@RequestMapping("main/logout.do")
	public String main_logout(HttpSession session){
		//세션 해제 
		session.invalidate();
		
		return "redirect:list.do";
	}
	@RequestMapping("main/reply_insert.do")
	public String reply_insert(ReplyVO vo,HttpSession session){
		try{
			String id=(String)session.getAttribute("id");
			vo.setId(id);
			rDao.replyInsert(vo);
			
		}catch(Exception ex){
			System.out.println("입력 실패");
		}
		//uri는 .do 까지만 뒤에 내용은 request 에 담겨서 보내짐
		return "redirect:detail.do?mno="+vo.getMno();
	}
	
	
	/*
	 * 
	 * 
	 */
	@RequestMapping("main/reply_reply_insert.do")
	public String reply_reply_insert(int pno,int mno,String msg,HttpSession session){
		ReplyVO vo = new ReplyVO();
		String id=(String)session.getAttribute("id");
		vo.setMno(mno);
		vo.setMsg(msg);
		vo.setId(id);
		
		rDao.replyReplyInsert(pno, vo);
		//추가
		return "redirect:detail.do?mno="+mno;
	}
	
	@RequestMapping("main/reply_reply_update.do")
	public String reply_replyUpdate(ReplyVO vo){
		
		//수정 => DAO
		rDao.replyUpdate(vo);
		return "redirect:detail.do?mno="+vo.getMno();
	}
	
	@RequestMapping("main/reply_delete.do")
	public String reply_delete(int no, int mno){
		
		//삭제
		rDao.replyReplyDelete(no);
		return "redirect:detail.do?mno="+mno;
	}
}
