package com.exhibition.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MypageAction implements com.exhibition.controller.Action {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		String url = "/source/member/mypage.jsp";
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("loginUser");
		if (id != null) {
			MemberDAO mDao = MemberDAO.getInstance();
			MemberVO result = mDao.getMember(id);	
			req.setAttribute("userData", result);
		} else {
			url = "/source/member/login.jsp";
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher(url);
		dispatcher.forward(req, resp);
	}
}
