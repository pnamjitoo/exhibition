package com.exhibition.notice;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exhibition.controller.Action;

public class NoticeDeleteAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String num = String.valueOf(request.getParameter("num"));
			NoticeDAO nDao = NoticeDAO.getInstance();
			String id = nDao.selectOneNoticeByNum(num).getId().toString();
			HttpSession session = request.getSession();
			int rank = Integer.parseInt(String.valueOf(session.getAttribute("rank")));
			if (session.getAttribute("loginUser").toString().equals(id) && rank==0) {
				nDao.deleteNotice(num);
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			new NoticeListAction().execute(request, response);
		}
	}
}