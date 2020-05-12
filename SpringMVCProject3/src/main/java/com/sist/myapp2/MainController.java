package com.sist.myapp2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main/")
public class MainController {
	
	//http://www.kobis.or.kr/kobis/business/main/main.do
	@RequestMapping("main.do")
	public String main_main(Model model){
		
		
		model.addAttribute("main_jsp","default.jsp");
		return "main/main";
	}
}
