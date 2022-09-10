package com.exhibition.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exhibition.controller.Action;

public class NoticeListAction implements Action{
	@Override
	public void execute (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "/source/notice/notice.jsp";
		NoticeDAO nDao = NoticeDAO.getInstance();
		List<NoticeVO> noticeList = nDao.selectAllNotices();
		request.setAttribute("noticeList", noticeList);
		HttpSession session = request.getSession();
		session.setAttribute("not_list", "true");
		RequestDispatcher dispather = request.getRequestDispatcher(url);
		dispather.forward(request,response);
	}
	
}