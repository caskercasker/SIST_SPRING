package com.sist.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ListController {
	@RequestMapping("main/list.do")
	public String main_list(HttpServletRequest request){
		request.setAttribute("msg", "Hello Spring!!");
		return "list";
	}
}
