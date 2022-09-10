package com.exhibition.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginAction implements com.exhibition.controller.Action {
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		String url = "/source/member/login.jsp";
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		MemberDAO mDao = MemberDAO.getInstance();
		String result = mDao.loginCheck(id, pwd);
		int rank = mDao.getMember(id).getRank();
		
		HttpSession session = req.getSession();
		if (result != null) {
			session.setAttribute("loginUser", result);
			session.setAttribute("rank", rank);
			
		}	else {
			session.setAttribute("login", "false");
		}
		  RequestDispatcher dispatcher = req.getRequestDispatcher(url);
		  dispatcher.forward(req, resp);
		

	}
	
}
