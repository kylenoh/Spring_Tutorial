package com.kyle.identity;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kyle.identity.dto.Member;
import com.kyle.identity.serviceImpl.MemberServiceImpl;

@Controller
public class MemberController {
	
	@Autowired
	MemberServiceImpl memberService;
	
	@RequestMapping(value = "/callJoin", method = RequestMethod.GET)
	public String Join() {
		return "identity/anonymous/join";
	}

	@RequestMapping(value = "/memberInsert", method = RequestMethod.POST)
	public String Insert(HttpServletRequest request, Member member) {
		
		memberService.memberInsert(member.getMember_id(), member.getMember_pw(), member.getMember_pwChk(), member.getMember_name(), member.getMember_mail());
		
		return "identity/user/loggedInfo";
	}
	
/*
	@RequestMapping(value = "/memberInsert", method = RequestMethod.POST)
	public ModelAndView Insert(HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("member_id", request.getParameter("member_id"));
		mv.addObject("member_pw", request.getParameter("member_pw"));
		mv.addObject("member_pwChk", request.getParameter("member_pwChk"));
		mv.addObject("member_name", request.getParameter("member_name"));
		mv.addObject("member_mail", request.getParameter("member_mail"));
		
		mv.setViewName("identity/anonymous/joinOK");
		
		return mv;
	}
*/	
	@RequestMapping(value = "/callLogin", method = RequestMethod.GET)
	public String login() {
		return "identity/user/login";
	}
	
}
