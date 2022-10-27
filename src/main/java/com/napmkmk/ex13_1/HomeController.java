package com.napmkmk.ex13_1;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		
		return "login";
	}
	
	
	@RequestMapping(value = "checkId")
	public String checkId(@RequestParam("id") String id, @RequestParam ("pw") String pw , Model model) {
		//HttpServletRequest빼고 어노테이션 리퀘스트 파람으로 정의 그러면 아래 두줄이 사라짐. 단점은 길어지면 보기 어렵다.
		
	
		
//		String mid = request.getParameter("id");
//		String mpw = request.getParameter("pw");
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		return "checkId";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		
		
		return "join";
		
	}
	
//	@RequestMapping(value = "/joinOk")
//	private String joinOk(HttpServletRequest request , Model model) {
//		
//		String mid  = request.getParameter("id");
//		String mpw  = request.getParameter("pw");
//		String mname  = request.getParameter("name");
//		String memail  = request.getParameter("email");
//		
//		MemberDto member = new MemberDto(mid, mpw, mname, memail); // 4개를 갖고 생성자가 태어남
//		
//		model.addAttribute("memberInfo" , member); // 한번에 보내는 방법  memberInfo로 코드로 가져가면 됨.
//		
//		
////		model.addAttribute("id" , mid);
////		model.addAttribute("pw" , mpw);
////		model.addAttribute("name" , mname);
////		model.addAttribute("email" , memail);
//		
//		return "joinOk";
//	}

	
	@RequestMapping (value = "joinOk")
	public String joinOk(@ModelAttribute("memberInfo") MemberDto memberDto) { // @ModelAttribute 쓰면 데이터 객체 이름을 원하는걸로 변경가능
		
		
		return "joinOk";
	}
	
	
	
//
//	@RequestMapping (value = "joinOk")
//	public String joinOk(MemberDto memberDto) { // 맴버 디티오 선언 일반객체 부르기 ★★★객체 이름이 ★클래스★ 이름과 같아야 합니다★★
//		
//		
//		return "joinOk";
//	}
	
	@RequestMapping(value = "/height/{memberHT}")
	public String memberHeight(@PathVariable String memberHT, Model model) {
		model.addAttribute("memberHT", memberHT);
		
		return "memberHeight";
	}
	

}
