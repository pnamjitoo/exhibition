package com.exhibition.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private MemberDAO() {

	}

	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {
		return instance;
	}

	public Connection getConnection() throws Exception {
		Connection conn = null;
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
		conn = ds.getConnection();
		return conn;
	}

	//로그인 체크 메소드
	public String loginCheck(String id, String pwd) {
		String result = null;
		String sql = "select pwd, id from member where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id); 
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getString("pwd")!=null && rs.getString("pwd").equals(pwd)) {
						result = rs.getString("id");
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}	finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			}	catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	//회원정보 수정 메소드
	public void setMember(String field, String data, String id) {
		String sql = "UPDATE member SET " + field +"=? WHERE id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, data);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
		}	catch(Exception e) {
			e.printStackTrace();
		}	finally {
			try {
				if(rs != null) rs.close();
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			}	catch(Exception e) {
				e.printStackTrace();
			}
		}
	} 

	//회원정보 조회 메소드
	public MemberVO getMember(String uid) {
		MemberVO loginUser = new MemberVO();
		String sql = "select * from member where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {			
			MemberVO mVo = new MemberVO();
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid); //회원정보 존재시 1 리턴
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int mem_no = rs.getInt("mem_no");
				mVo.setMem_no(mem_no);
				String id = rs.getString("id");
				mVo.setId(id);
                String pwd = rs.getString("pwd");
                mVo.setPwd(pwd);
                String mem_name = rs.getString("mem_name");
                mVo.setMem_name(mem_name);
                String nick = rs.getString("nick");
                mVo.setNick(nick);
                String age = rs.getString("age");
                mVo.setAge(age);
                String gender = rs.getString("gender");
                mVo.setGender(gender);
                String tel = rs.getString("tel");
                mVo.setTel(tel);
                String addr = rs.getString("addr");
                mVo.setAddr(addr);
                int rank = rs.getInt("rank");
                mVo.setRank(rank);
			}	
			loginUser = mVo;
		}	catch(Exception e) {
			e.printStackTrace();
		}	finally {
			try {
				if(rs != null) rs.close();
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			}	catch(Exception e) {
				e.printStackTrace();
			}
		}
		return loginUser;
	}
	
	//회원 삭제 메소드
	public void deleteMem(String id) {
		String sql = "DELETE FROM member WHERE id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		}	catch(Exception e) {
			e.printStackTrace();
		}	finally {
			try {
				if(rs != null) rs.close();
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			}	catch(Exception e) {
				e.printStackTrace();
			}
		}
	} 
	
	//회원 가입 - 아이디 중복 확인 메소드
	public int confirmID(String id) {
		int result = -1;
		String sql = "select id from member where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = 1;
			}	else {
				result = -1;
			}
		}	catch(Exception e) {
			e.printStackTrace();
		}	finally {
			try {
				if(rs != null) rs.close();
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			}	catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	//회원 등록 메소드
	public int registMember(String id, String pwd, String mem_name, String nick, String age, String gender, String tel,
			String addr, int rank) {
		String sql = "INSERT INTO member VALUES (member_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = -1;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, mem_name);
			pstmt.setString(4, nick);
			pstmt.setString(5, age);
			pstmt.setString(6, gender);
			pstmt.setString(7, tel);
			pstmt.setString(8, addr);
			pstmt.setInt(9, rank);
			result = pstmt.executeUpdate();
		}	catch(Exception e) {
			e.printStackTrace();
		}	finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			}	catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
