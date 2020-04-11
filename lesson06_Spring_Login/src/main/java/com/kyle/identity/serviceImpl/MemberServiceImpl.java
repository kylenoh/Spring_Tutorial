package com.kyle.identity.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyle.identity.dao.MemberDAO;
import com.kyle.identity.dto.Member;
import com.kyle.identity.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDAO memberDao;

	@Override
	public void memberInsert(String member_id, String member_pw, String member_pwChk, String member_name,
			String member_mail) {
		
		if (member_pw.equals(member_pwChk)) {
			memberDao.memberInsert(member_id, member_pw, member_pwChk, member_name, member_mail);
		} else {
			
		}

	}

	@Override
	public Member getMemberById(Member member) {

		Member mem = memberDao.memberSelect(member);
		
		if (mem == null) {
			System.out.println("Login Fail!!");
		} else {
			System.out.println("Login Success!!");
		}

		return mem;
	}

	@Override
	public Member memberUpdate(Member member) {

		int result = memberDao.memberUpdate(member);
		
		if(result == 0 ) {
			System.out.println("Modify Fail!!");
		} else {
			System.out.println("Modify Success!!");
		}
		
		return member;
	}

	@Override
	public int memberDelete(Member member) {

		int result = memberDao.memberDelete(member);
		
		if(result == 0 ) {
			System.out.println("Delete Fail!!");
		} else {
			System.out.println("Delete Success!!");
		}
		
		return result;
	}

}
