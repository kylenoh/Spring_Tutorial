package com.kyle.identity.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.kyle.identity.dto.Member;


@Repository
public class MemberDAO {

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String userid = "Tutorial";
	private String userpw = "12341234";

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public int insert(String member_id, String member_pw, String member_pwChk, String member_name, String member_mail) {

		int result = 0;

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, userpw);
			String sql = "INSERT INTO TEST_MEMBER VALUES(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member_id);
			pstmt.setString(2, member_pw);
			pstmt.setString(3, member_pwChk);
			pstmt.setString(4, member_name);
			pstmt.setString(5, member_mail);
			result = pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public Member memberSelect(Member member) {

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, userpw);
			String sql = "SELECT * FROM TEST_MEMBER WHERE member_id = ? AND member_pw = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMember_id());
			pstmt.setString(2, member.getMember_pw());
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String memId = rs.getString("member_id");
				String memPw = rs.getString("member_pw");
				String memPwChk = rs.getString("member_pwChk");
				String memName = rs.getString("member_Name");
				String memMail = rs.getString("member_Mail");
				
				member.setMember_id(memId);
				member.setMember_pw(memPw);
				member.setMember_pwChk(memPwChk);
				member.setMember_name(memName);
				member.setMember_mail(memMail);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return member;

	}

	public int memberUpdate(Member member) {

		int result = 0;

		try {
			
			System.out.println(member.getMember_id());
			System.out.println(member.getMember_pw());
			System.out.println(member.getMember_pwChk());
			System.out.println(member.getMember_name());
			System.out.println(member.getMember_mail());
			
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, userpw);
			String sql = "UPDATE TEST_MEMBER SET member_pw = ?, member_pwChk = ?, member_Name = ?, member_Mail = ? WHERE member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMember_pw());
			pstmt.setString(2, member.getMember_pwChk());
			pstmt.setString(3, member.getMember_name());
			pstmt.setString(4, member.getMember_mail());
			pstmt.setString(5, member.getMember_id());
			result = pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;

	}

	public int memberDelete(Member member) {

		int result = 0;

		try {

			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, userpw);
			String sql = "DELETE TEST_MEMBER WHERE member_id = ? AND member_pw = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMember_id());
			pstmt.setString(2, member.getMember_pw());
			result = pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;

	}
}
