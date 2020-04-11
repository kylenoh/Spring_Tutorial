package com.kyle.identity.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.kyle.identity.dto.Member;


@Repository
public class MemberDAO {

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String userid = "Tutorial";
	private String userpw = "12341234";
	
	private DriverManagerDataSource datasource;
	private JdbcTemplate template;
	
	public MemberDAO() {
		datasource = new DriverManagerDataSource();
		datasource.setDriverClassName(driver);
		datasource.setUrl(url);
		datasource.setUsername(userid);
		datasource.setPassword(userpw);
		
		template = new JdbcTemplate();
		template.setDataSource(datasource);
	}
	
	public int memberInsert(String member_id, String member_pw, String member_pwChk, String member_name, String member_mail) {

		int result = 0;
		final String sql = "INSERT INTO TEST_MEMBER VALUES(?,?,?,?,?)";

			result = template.update(sql, new PreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement pstmt) throws SQLException {
					pstmt.setString(1, member_id);
					pstmt.setString(2, member_pw);
					pstmt.setString(3, member_pwChk);					
					pstmt.setString(4, member_name);					
					pstmt.setString(5, member_mail);					
				}
			});
			
		return result;
	}
		
	public Member memberSelect(Member member) {

		List<Member> members = null;
		String sql = "SELECT * FROM TEST_MEMBER WHERE member_id = ? AND member_pw = ?";
		members = template.query(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, member.getMember_id());
				pstmt.setString(2, member.getMember_pw());
			}
			
		},new RowMapper<Member>() {

			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member mem = new Member();
				mem.setMember_id(rs.getString("member_id"));
				mem.setMember_pw(rs.getString("member_pw"));
				mem.setMember_pwChk(rs.getString("member_pwChk"));
				mem.setMember_name(rs.getString("member_name"));
				mem.setMember_mail(rs.getString("member_mail"));
				
				return mem;
			}
		});
		
		if(members.isEmpty()) 
			return null;
		
		return members.get(0);
	}

	public int memberUpdate(Member member) {

		int result = 0;
		String sql = "UPDATE TEST_MEMBER SET member_pw = ?, member_pwChk = ?, member_Name = ?, member_Mail = ? WHERE member_id = ?";
		
		result = template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, member.getMember_pw());
				pstmt.setString(2, member.getMember_pwChk());
				pstmt.setString(3, member.getMember_name());
				pstmt.setString(4, member.getMember_mail());
				pstmt.setString(5, member.getMember_id());
			}
			
		});
		return result;
	}

	public int memberDelete(Member member) {

		int result = 0;
		String sql = "DELETE TEST_MEMBER WHERE member_id = ? AND member_pw = ?";
		
		result = template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, member.getMember_id());
				pstmt.setString(2, member.getMember_pw());
			}
		});
		return result;
	}
	
	/*			
	 * 			Insert	(이전 형태의 JDBC)		
	 * 
				datasource.getConnection();
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
			
			Select	(이전 형태의 JDBC)
			
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
			
			Update	(이전 형태의 JDBC)
			
			try {
			
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
		
			Delete	(이전 형태의 JDBC)
			
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
			
	*/
}
