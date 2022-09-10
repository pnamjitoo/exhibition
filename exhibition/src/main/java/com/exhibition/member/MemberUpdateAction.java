package com.exhibition.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberUpdateAction implements com.exhibition.controller.Action {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		HttpSession session = req.getSession();
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String url="/source/member/login.jsp";
		String field = null;
		String data = null;
		String uid = (String) session.getAttribute("loginUser");
		if (uid != null) {
			url="/source/member/mypage.jsp";
			if (req.getParameter("pwd") != null) {
				field = "pwd";
				data = req.getParameter("pwd");
			}
			if (req.getParameter("mem_name") != null) {
				field = "mem_name";
				data = req.getParameter("mem_name");
			}
			if (req.getParameter("nick") != null) {
				field = "nick";
				data = req.getParameter("nick");
			}
			if (req.getParameter("age") != null) {
				field = "age";
				data = req.getParameter("age");
			}
			if (req.getParameter("gender") != null) {
				field = "gender";
				data = req.getParameter("gender");
			}
			if (req.getParameter("tel") != null) {
				field = "tel";
				data = req.getParameter("tel");
			}
			if (req.getParameter("addr") != null) {
				field = "addr";
				data = req.getParameter("addr");
			}
			MemberDAO mDao = MemberDAO.getInstance();
			mDao.setMember(field, data, uid);
			session.setAttribute("memUpdate", "true");
			req.setAttribute("userData", mDao.getMember(uid));
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher(url);
		dispatcher.forward(req, resp);
	}
}
