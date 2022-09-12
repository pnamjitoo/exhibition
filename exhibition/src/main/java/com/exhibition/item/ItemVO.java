package com.exhibition.item;

import java.sql.Timestamp;

public class ItemVO {
	private int item_no;
	private String item_name;
	private int price;
	private String benefit;
	private int sale;
	private int num;
	private String item_content;
	private String place;
	private String location;
	private int likes;
	private int hits;
	private Timestamp opendate;
	private Timestamp closedate;
	private String item_photo;
	private String runtime;
	private String item_age;
	private Timestamp item_rdate;
	private int tema_no;
	
	public String getItem_photo() {
		return item_photo;
	}
	public void setItem_photo(String item_photo) {
		this.item_photo = item_photo;
	}
	public int getItem_no() {
		return item_no;
	}
	public void setItem_no(int item_no) {
		this.item_no = item_no;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getBenefit() {
		return benefit;
	}
	public void setBenefit(String benefit) {
		this.benefit = benefit;
	}
	public int getSale() {
		return sale;
	}
	public void setSale(int sale) {
		this.sale = sale;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getItem_content() {
		return item_content;
	}
	public void setItem_content(String item_content) {
		this.item_content = item_content;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public Timestamp getOpendate() {
		return opendate;
	}
	public void setOpendate(Timestamp opendate) {
		this.opendate = opendate;
	}
	public Timestamp getClosedate() {
		return closedate;
	}
	public void setClosedate(Timestamp closedate) {
		this.closedate = closedate;
	}
	public String getRuntime() {
		return runtime;
	}
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}
	public String getItem_age() {
		return item_age;
	}
	public void setItem_age(String item_age) {
		this.item_age = item_age;
	}
	public Timestamp getItem_rdate() {
		return item_rdate;
	}
	public void setItem_rdate(Timestamp item_rdate) {
		this.item_rdate = item_rdate;
	}
	public int getTema_no() {
		return tema_no;
	}
	public void setTema_no(int tema_no) {
		this.tema_no = tema_no;
	}

}
