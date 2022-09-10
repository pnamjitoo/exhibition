package com.exhibition.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteAction implements com.exhibition.controller.Action {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("loginUser");
		String url = "/source/member/login.jsp";
		if (id != null) {
			session.removeAttribute("loginUser") ;
			MemberDAO mDao = MemberDAO.getInstance();
			mDao.deleteMem(id);	
			session.setAttribute("deleteMem", "true");
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher(url);
		dispatcher.forward(req, resp);
	}

}
