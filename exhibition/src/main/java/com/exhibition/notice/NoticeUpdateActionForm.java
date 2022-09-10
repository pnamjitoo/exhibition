package com.exhibition.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exhibition.controller.Action;

public class NoticeUpdateActionForm implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String url = "/source/notice/notice.jsp";
		try {
			String num = String.valueOf(request.getParameter("num"));
			HttpSession session = request.getSession();
			NoticeDAO nDao = NoticeDAO.getInstance();
			String id = nDao.selectOneNoticeByNum(num).getId();
			int rank = Integer.parseInt(String.valueOf(session.getAttribute("rank")));
			if (session.getAttribute("loginUser").toString().equals(id) && rank==0) {
				url = "/source/notice/noticeUpdate.jsp";
				NoticeVO nVo = nDao.selectOneNoticeByNum(num);
				request.setAttribute("notice", nVo);
			} else {
				session.setAttribute("not_update", "false");
			}
		} finally {
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
	}
}