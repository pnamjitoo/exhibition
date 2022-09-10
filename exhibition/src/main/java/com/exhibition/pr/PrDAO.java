package com.exhibition.pr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBManager;

public class PrDAO {
	private PrDAO() {
	}

	private static PrDAO instance = new PrDAO();

	public static PrDAO getInstance() {
		return instance;
	}
	
	//홍보게시판 조회 메소드
	public List<PrVO> selectAllPrs() {
		String sql = "select * from pr order by pr_no desc";
		List<PrVO> list = new ArrayList<PrVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				PrVO pVo = new PrVO();
				pVo.setPr_no(rs.getInt("pr_no"));
				pVo.setId(rs.getString("id"));
				pVo.setNick(rs.getString("nick"));
				pVo.setTitle(rs.getString("title"));
				pVo.setPr_photo(rs.getString("pr_photo"));
				pVo.setPlace(rs.getString("place"));
				pVo.setDescript(rs.getString("descript"));
				pVo.setPr_rdcnt(rs.getInt("pr_rdcnt"));
				pVo.setRdate(rs.getTimestamp("rdate"));
				pVo.setRdate(rs.getTimestamp("idate"));
				list.add(pVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	
	//홍보게시판 등록 메소드
	public void insertPr(PrVO pVo) {
		String sql = "insert into pr(" + "pr_no, id, nick, title, pr_photo, place, pr_rdcnt, rdate, idate, descript) "
				+ "values(pr_seq.nextval, ?, ?, ?, ?, ?, 0, sysdate, null, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pVo.getId());
			pstmt.setString(2, pVo.getNick());
			pstmt.setString(3, pVo.getTitle());
			pstmt.setString(4, pVo.getPr_photo());
			pstmt.setString(5, pVo.getPlace());
			pstmt.setString(6, pVo.getDescript());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	//홍보게시판 조회수 메소드
	public void updateReadCount(String pr_no) {
		String sql = "update pr set pr_rdcnt=pr_rdcnt+1 where pr_no=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pr_no);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	// 게시판 글 상세 내용 보기 :글번호로 찾아온다. : 실패 null,
	public PrVO selectOnePrByPr_no(String pr_no) {
		String sql = "select * from pr where pr_no = ?";
		PrVO pVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pr_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				pVo = new PrVO();
				pVo.setPr_no(rs.getInt("pr_no"));
				pVo.setId(rs.getString("id"));
				pVo.setId(rs.getString("nick"));
				pVo.setTitle(rs.getString("title"));
				pVo.setPr_photo(rs.getString("pr_photo"));
				pVo.setPlace(rs.getString("place"));
				pVo.setPr_rdcnt(rs.getInt("pr_rdcnt"));
				pVo.setRdate(rs.getTimestamp("rdate"));
				pVo.setRdate(rs.getTimestamp("idate"));
				pVo.setDescript(rs.getString("descript"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return pVo;
	}

	//홍보게시판 수정 메소드
	public void updatePr(PrVO pVo) {
		String sql = "update pr set title=?, pr_photo=?, place=?, idate=sysdate, descript=? where pr_no=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pVo.getTitle());
			pstmt.setString(2, pVo.getPr_photo());
			pstmt.setString(3, pVo.getPlace());
			pstmt.setString(4, pVo.getDescript());
			pstmt.setInt(5, pVo.getPr_no());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	/* 회원에게 등급에 따른 작성 권한을 부여하므로, 작성자만 삭제할 수 있도록 설정해야함 */
	/*
	 * //홍보게시판 비밀번호 체크 메소드 public PrVO checkPassWord(String pass, String pr_no) {
	 * String sql = "select * from pr where pass=? and pr_no=?"; Connection conn =
	 * null; PreparedStatement pstmt = null; ResultSet rs = null; PrVO pVo = null;
	 * try { conn = DBManager.getConnection(); pstmt = conn.prepareStatement(sql);
	 * pstmt.setString(1, pass); pstmt.setString(2, pr_no); rs =
	 * pstmt.executeQuery(); if (rs.next()) { pVo = new PrVO();
	 * pVo.setPr_no(rs.getInt("pr_no")); pVo.setMem_no(rs.getInt("mem_no"));
	 * pVo.setPass(rs.getString("pass")); pVo.setTitle(rs.getString("title"));
	 * pVo.setPr_photo(rs.getString("pr_photo"));
	 * pVo.setPlace(rs.getString("place"));
	 * pVo.setDescript(rs.getString("descript"));
	 * pVo.setReadcount(rs.getInt("readcount"));
	 * pVo.setRdate(rs.getTimestamp("rdate")); } } catch (SQLException e) {
	 * e.printStackTrace(); } return pVo; }
	 */
	
	//홍보게시판 삭제 메소드
	public void deletePr(String pr_no) {
		String sql = "delete pr where pr_no=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pr_no);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
