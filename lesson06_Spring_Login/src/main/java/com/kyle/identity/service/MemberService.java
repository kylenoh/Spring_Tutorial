package com.kyle.identity.service;

public interface MemberService {
	void memberInsert(String member_id, String member_pw, String member_pwChk, String member_name, String member_mail);

}
