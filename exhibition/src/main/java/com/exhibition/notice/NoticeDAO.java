package com.exhibition.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBManager;

public class NoticeDAO{
	private NoticeDAO() {
	}
	private static NoticeDAO instance = new NoticeDAO();
	
	public static NoticeDAO getInstance() {
		return instance;
	}
	
	//공지사항 목록 출력 메소드
	public List<NoticeVO> selectAllNotices(){
		String sql ="select not_no, title, id, nick, rdate, not_rdcnt from notice order by not_no desc";
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				NoticeVO nVo = new NoticeVO();
				nVo.setNot_no(rs.getInt("not_no"));
				nVo.setTitle(rs.getString("title"));
				nVo.setId(rs.getString("id"));
				nVo.setNick(rs.getString("nick"));
				nVo.setNot_rdcnt(rs.getInt("not_rdcnt"));
				nVo.setRdate(rs.getTimestamp("rdate"));
				list.add(nVo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	
	//공지사항 등록 메소드
	public void insertNotice(NoticeVO nVo) {
		String sql = "insert into notice("
				+"not_no, id, nick, title, not_photo, descript, not_rdcnt, rdate, idate)"
				+"values(notice_seq.nextval,?,?,?,?,?,0,sysdate,null)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nVo.getId());
			pstmt.setString(2,nVo.getNick());
			pstmt.setString(3, nVo.getTitle());
			pstmt.setString(4, nVo.getNot_photo());
			pstmt.setString(5, nVo.getDescript());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn,pstmt);
		}
	}
	
	//공지사항 상세 조회 메소드
	public NoticeVO selectOneNoticeByNum(String num) {
	String sql = "select * from notice where not_no = ?";
	NoticeVO nVo = null;
	Connection conn = null;
	PreparedStatement pstmt =null;
	ResultSet rs=null;
	try {
		conn = DBManager.getConnection();
		updateReadCount(num);
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,num);
		rs= pstmt.executeQuery();
		if(rs.next()) {
			nVo = new NoticeVO();
			nVo.setNot_no(rs.getInt("not_no"));
			nVo.setId(rs.getString("id"));
			nVo.setNick(rs.getString("nick"));
			nVo.setTitle(rs.getString("title"));
			nVo.setNot_photo(rs.getString("not_photo"));
			nVo.setDescript(rs.getString("descript"));
			nVo.setNot_rdcnt(rs.getInt("not_rdcnt"));
			nVo.setRdate(rs.getTimestamp("rdate"));
			nVo.setIdate(rs.getTimestamp("idate"));
			}
			System.out.println(nVo.getNot_rdcnt());
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt,rs);
		}
		return nVo;
	}
	
	//공지게시판 조회수 메소드
	public void updateReadCount(String not_no) {
		String sql = "update notice set not_rdcnt=not_rdcnt+1 where not_no=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, not_no);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	//공지사항 삭제 메소드
	public void deleteNotice(String num) {
		String sql = "delete notice where not_no = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn= DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.executeUpdate();
			System.out.println(num);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//공지사항 수정 메소드
	public void updateNotice(NoticeVO nVo) {
		String sql = "update notice set title = ?,not_photo = ?,descript=?,idate=sysdate where not_no = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nVo.getTitle());
			pstmt.setString(2, nVo.getNot_photo());
			pstmt.setString(3, nVo.getDescript());
			pstmt.setInt(4, nVo.getNot_no());
			System.out.println(nVo.getNot_no());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn,pstmt);
		}
			
	}
	
}
		
			
		
	
		

	
	