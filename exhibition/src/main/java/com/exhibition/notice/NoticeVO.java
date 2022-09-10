package com.exhibition.notice;

import java.sql.Timestamp;

public class NoticeVO{
	private int not_no;
	private String title;
	private String id;
	private String nick;
	private int not_rdcnt;
	private Timestamp rdate;
	private Timestamp idate;
	private String not_photo;
	private String descript;
	
	public int getNot_rdcnt() {
		return not_rdcnt;
	}
	public void setNot_rdcnt(int not_rdcnt) {
		this.not_rdcnt = not_rdcnt;
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
	public Timestamp getIdate() {
		return idate;
	}
	public void setIdate(Timestamp idate) {
		this.idate = idate;
	}
	public String getNot_photo() {
		return not_photo;
	}
	public void setNot_photo(String not_photo) {
		this.not_photo = not_photo;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public int getNot_no() {
		return not_no;
	}
	public void setNot_no(int not_no) {
		this.not_no = not_no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Timestamp getRdate() {
		return rdate;
	}
	public void setRdate(Timestamp rdate) {
		this.rdate = rdate;
	}
	
	
	
	
}

