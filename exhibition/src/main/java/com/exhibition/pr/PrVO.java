package com.exhibition.pr;

import java.sql.Timestamp;

public class PrVO {

	private int pr_no;	//홍보번호
	private String id;	//회원아이디
	private String nick; //회원별명
	private String title;	//제목
	private String pr_photo;	//사진
	private String place;	//개최장소
	private String descript;	//홍보설명
	private int pr_rdcnt;		//조회수
	private Timestamp rdate;	//등록일
	private Timestamp idate;
	
	public Timestamp getIdate() {
		return idate;
	}
	public void setIdate(Timestamp idate) {
		this.idate = idate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public int getPr_no() {
		return pr_no;
	}
	public void setPr_no(int pr_no) {
		this.pr_no = pr_no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPr_photo() {
		return pr_photo;
	}
	public void setPr_photo(String pr_photo) {
		this.pr_photo = pr_photo;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public Timestamp getRdate() {
		return rdate;
	}
	public void setRdate(Timestamp rdate) {
		this.rdate = rdate;
	}
	public int getPr_rdcnt() {
		return pr_rdcnt;
	}
	public void setPr_rdcnt(int readcount) {
		this.pr_rdcnt = readcount;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}



}