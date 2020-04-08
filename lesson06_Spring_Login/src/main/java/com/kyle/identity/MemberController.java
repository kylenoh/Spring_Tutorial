package com.kyle.identity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	public String callJoin() {
		return "identity/anonymous/join";
	}
	
	@RequestMapping(value = "/callLogin", method = RequestMethod.GET)
	public String calllogin() {
		return "identity/user/login";
	}
	
	@RequestMapping(value = "/callUpdate", method = RequestMethod.GET)
	public String callUpdate(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		
		memberService.getMemberById(member);
		
		return "identity/user/loggedInfoUpdate";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String callLogout(Member member, HttpSession session) {
		
		session.invalidate();
		
		return "portal/main";
	}
	
/*----------------------------------------------------------------------------------------*/
	@RequestMapping(value = "/memberInsert", method = RequestMethod.POST)
	public String Insert(HttpServletRequest request, Member member) {
		
		memberService.memberInsert(member.getMember_id(), member.getMember_pw(), member.getMember_pwChk(), member.getMember_name(), member.getMember_mail());
		
		return "portal/main";
	}
	
	@RequestMapping(value = "/memberModify", method = RequestMethod.POST)
	public String Modify(HttpServletRequest request, Member member) {
		
		HttpSession session = request.getSession();
		
		memberService.memberUpdate(member);
		
		session.setAttribute("member", member);
		
		return "identity/user/loggedInfo";
	}
	
	@RequestMapping(value = "/memberDelete", method = RequestMethod.GET)
	public String Delete(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		
		System.out.println(member.getMember_id());
		System.out.println(member.getMember_pw());
		
		memberService.memberDelete(member);
		
		return "portal/main";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(Member member, HttpSession session) {
		
		memberService.getMemberById(member);
		
		session.setAttribute("member", member);
		
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

	
}
