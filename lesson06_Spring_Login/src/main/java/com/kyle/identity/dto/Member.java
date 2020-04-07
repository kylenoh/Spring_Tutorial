package com.kyle.identity.dto;

public class Member {
//	Member 의 속성을 선언해 줍니다.
	private String member_id;
	private String member_pw;
	private String member_pwChk;
	private String member_name;
	private String member_mail;

//	기본 생성자를 만듭니다.
	public Member() {
		// TODO Auto-generated constructor stub
	}
	
//	Member 호출 시, 값을 담을 수 있는 커스텀 생성자를 만듭니다.
	public Member(String member_id, String member_pw, String member_pwChk, String member_name, String member_mail) {
		super();
		this.member_id = member_id;
		this.member_pw = member_pw;
		this.member_pwChk = member_pwChk;
		this.member_name = member_name;
		this.member_mail = member_mail;
	}

//	외부에서 값을 주고 받을 수 있는 Getter & Setter를 만듭니다.
	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_pw() {
		return member_pw;
	}

	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}

	public String getMember_pwChk() {
		return member_pwChk;
	}

	public void setMember_pwChk(String member_pwChk) {
		this.member_pwChk = member_pwChk;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_mail() {
		return member_mail;
	}

	public void setMember_mail(String member_mail) {
		this.member_mail = member_mail;
	}

}
