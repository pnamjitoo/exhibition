package com.exhibition.member;

public class MemberVO {
	
	private int mem_no;
	private String id;
	private String pwd;
	private String mem_name;
	private String nick;
	private String age;
	private String gender;
	private String tel;
	private String addr;
	private int rank;
	
	public int getMem_no() {
		return mem_no;
	}
	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	@Override
	public String toString() {
		return "MemberDAO [mem_no=" + mem_no + ", id=" + id + ", pwd=" + pwd + ", mem_name=" + mem_name + ", nick="
				+ nick + ", age=" + age + ", gender=" + gender + ", tel=" + tel + ", addr=" + addr + ", rank=" + rank
				+ "]";
	}
}
