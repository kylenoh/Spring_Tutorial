package com.kyle.identity.serviceImpl;

import org.springframework.stereotype.Service;

import com.kyle.identity.service.MemberService;


@Service
public class MemberServiceImpl implements MemberService{

	@Override
	public void memberInsert(String member_id, String member_pw, String member_pwChk, String member_name,
			String member_mail) {
		if (member_pw.equals(member_pwChk)) {
			System.out.println("비밀번호가 일치합니다.");
		}else {
			System.out.println("비밀번호 오류입니다.");
		}
	
	}
		


}
