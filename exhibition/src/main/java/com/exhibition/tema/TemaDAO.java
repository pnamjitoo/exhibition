package com.exhibition.tema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBManager;

public class TemaDAO {
	private TemaDAO(){
	}
	private static TemaDAO instance = new TemaDAO();
	
	public static TemaDAO getInstance() {
		return instance;
	}
	
	//테마 목록 출력 메소드
	public List<TemaVO> selectAllTemas(){
		String sql ="select tema_no, tname from tema order by tema_no desc";
		List<TemaVO> list = new ArrayList<TemaVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				TemaVO tVo = new TemaVO();
				tVo.setTema_no(rs.getInt("tema_no"));
				tVo.setTname(rs.getString("tname"));
				list.add(tVo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	
	//테마 등록 메소드
	public void insertTema(TemaVO tVo) {
		String sql = "insert into notice("
				+"tema_no, tname)"
				+"values(notice_seq.nextval,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tVo.getTname());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn,pstmt);
		}
	}
	
	//테마 삭제 메소드
	public void deleteTema(String tema_no) {
		String sql = "delete tema where tema_no = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn= DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tema_no);
			pstmt.executeUpdate();
			System.out.println(tema_no);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//테마 수정 메소드
	public void updateTema(TemaVO tVo) {
		String sql = "update tema set tname where tema_no = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tVo.getTname());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn,pstmt);
		}
	}
}
