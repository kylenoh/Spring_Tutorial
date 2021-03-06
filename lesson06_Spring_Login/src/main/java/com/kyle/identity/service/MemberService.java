package com.kyle.identity.service;

import com.kyle.identity.dto.Member;

public interface MemberService {
	void memberInsert(String member_id, String member_pw, String member_pwChk, String member_name, String member_mail);
	Member getMemberById(Member member);
	Member memberUpdate(Member member);
	int memberDelete(Member member);
}
