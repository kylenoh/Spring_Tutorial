package com.kyle.identity;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kyle.identity.dto.Member;
import com.kyle.identity.serviceImpl.MemberServiceImpl;

@Controller
public class MemberController {
	
	@Autowired
	MemberServiceImpl memberService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "/portal/main";
	}
	
	@ModelAttribute("path")
	public String getContextPath(HttpServletRequest request) {
		return request.getContextPath();
//		/login 을 출력합니다
	}
	
	@ModelAttribute("serverTime")
	public String getServerTime(Locale locale) {
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		return dateFormat.format(date);
	}
	
	@RequestMapping(value = "/callJoin", method = RequestMethod.GET)
	public String callJoin() {
		return "identity/anonymous/join";
	}
	
	@RequestMapping(value = "/callLogin", method = RequestMethod.GET)
	public String calllogin(HttpServletRequest request) {
		return "identity/user/login";
	}
	
	@RequestMapping(value = "/callModify", method = RequestMethod.GET)
	public ModelAndView callUpdate(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("sessionMember");
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("sessionMember", memberService.getMemberById(member));
		
		mv.setViewName("/identity/user/Modify");
		
		return mv;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String callLogout(Member member, HttpSession session) {
		
		session.invalidate();
		
		return "identity/user/logout";
	}
	

	
/*----------------------------------------------------------------------------------------*/
	@RequestMapping(value = "/memberInsert", method = RequestMethod.POST)
	public String Insert(HttpServletRequest request, Member member) {
		
		memberService.memberInsert(member.getMember_id(), member.getMember_pw(), member.getMember_pwChk(), member.getMember_name(), member.getMember_mail());
		
		return "identity/anonymous/joinInfo";
	}
	
	@RequestMapping(value = "/memberModify", method = RequestMethod.POST)
	public ModelAndView Modify(HttpServletRequest request, Member member) {
		
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		
		Member mem = memberService.memberUpdate(member);
		
		if(mem == null) {
			mv.setViewName("/identity/user/Modify");
		} else { 
			session.setAttribute("sessionMember", mem);
			mv.setViewName("/identity/user/ModifyInfo");
		}
		
		return mv;
	}
	
	@RequestMapping(value = "/memberDelete", method = RequestMethod.GET)
	public String Delete(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("sessionMember");
		
		memberService.memberDelete(member);
		session.invalidate();
		
		return "identity/user/logout";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(Member member, HttpSession session) {
		
		Member mem = memberService.getMemberById(member);
		session.setAttribute("sessionMember", mem);
		
//		if(mem == null) {
//			return "identity/user/login";
//		}
		
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
