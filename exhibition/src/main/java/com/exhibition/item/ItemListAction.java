package com.exhibition.item;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.exhibition.controller.Action;

public class ItemListAction implements Action {
	@Override
	  public void execute(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException { 
			int tema_no;
			int nowPage;
			int cntPerPage;
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			if (request.getParameter("nowPage") != null) {
				nowPage = Integer.parseInt(request.getParameter("nowPage").toString());
			} else {
				nowPage = 1;
			}
			if (request.getParameter("cntPerPage") != null) {
				cntPerPage = Integer.parseInt(request.getParameter("cntPerPage").toString());
			} else {
				cntPerPage = 10;
			}
			if (request.getParameter("tema_no") != null && request.getParameter("tema_no").toString() != "") {
				tema_no = Integer.parseInt(request.getParameter("tema_no").toString());
			} else {
				tema_no = 1;
			}
			response.getWriter().write(getJson(tema_no, nowPage, cntPerPage));
		}
	//ajax 통신 이용
	public String getJson(int tema_no, int nowPage, int cntPerPage){
		
		StringBuffer result = new StringBuffer("");
		ItemDAO iDao = ItemDAO.getInstance();
		List<ItemVO> itemList = iDao.selectAllItems(tema_no, nowPage, cntPerPage);
		result.append("{\"result\":[");
		for (int i = 0; i<itemList.size() - 1; i++) {
			result.append("{\"item_no\": \"" + itemList.get(i).getItem_no() + "\",");
			result.append("\"item_name\": \"" + itemList.get(i).getItem_name() + "\",");
			result.append("\"item_photo\": \"" + itemList.get(i).getItem_photo() + "\",");	
			result.append("\"tema_no\": \"" + itemList.get(i).getTema_no() + "\"},");
			}
		
		result.append("{\"item_no\": \"" + itemList.get(itemList.size() -1).getItem_no() + "\","); 
		result.append("\"item_name\": \"" + itemList.get(itemList.size() - 1).getItem_name() + "\",");
		result.append("\"item_photo\": \"" + itemList.get(itemList.size() -1).getItem_photo() + "\","); 
		result.append("\"tema_no\": \"" + itemList.get(itemList.size() - 1).getTema_no() + "\"}]}");
		return result.toString();
		
		
	}
}