package com.exhibition.item;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exhibition.controller.Action;

public class ItemViewAction implements Action {
	@Override
	  public void execute(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException { 
			String item_no = null;
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			if (request.getParameter("item_no") == null) {
				response.sendRedirect("/source/item/board.jsp");
			} else {
				item_no = request.getParameter("item_no").toString();
			}
			response.getWriter().write(getJson(item_no));
		}
	//ajax 통신 이용
	public String getJson(String item_no){
		
		StringBuffer result = new StringBuffer("");
		ItemDAO iDao = ItemDAO.getInstance();
		ItemVO itemList = iDao.selectOneItemByNum(item_no);
		result.append("{\"result\":[");
		result.append("{\"item_no\": \"" + itemList.getItem_no() + "\",");
		result.append("\"item_name\": \"" + itemList.getItem_name() + "\",");
		result.append("\"price\": \"" + itemList.getPrice() + "\",");
		result.append("\"benefit\": \"" + itemList.getBenefit() + "\",");
		result.append("\"sale\": \"" + itemList.getSale() + "\",");
		result.append("\"num\": \"" + itemList.getNum() + "\",");
		result.append("\"item_content\": \"" + itemList.getItem_content() + "\",");
		result.append("\"place\": \"" + itemList.getPlace() + "\",");
		result.append("\"location\": \"" + itemList.getLocation() + "\",");
		result.append("\"likes\": \"" + itemList.getLikes() + "\",");
		result.append("\"hits\": \"" + itemList.getHits() + "\",");
		result.append("\"opendate\": \"" + itemList.getOpendate() + "\",");
		result.append("\"closedate\": \"" + itemList.getClosedate() + "\",");
		result.append("\"item_photo\": \"" + itemList.getItem_photo() + "\",");
		result.append("\"runtime\": \"" + itemList.getRuntime() + "\",");
		result.append("\"item_age\": \"" + itemList.getItem_age() + "\",");
		result.append("\"item_rdate\": \"" + itemList.getItem_rdate() + "\",");
		result.append("\"tema_no\": \"" + itemList.getTema_no() + "\"}]}");
		return result.toString();
		
		
	}
}
