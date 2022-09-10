package com.exhibition.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exhibition.controller.Action;

public class LogoutAction implements Action {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		String url="/source/member/login.jsp";
		HttpSession session = req.getSession();
		if (session.getAttribute("loginUser") != null) {
			session.removeAttribute("loginUser");
			session.removeAttribute("rank");
			session.setAttribute("logout", "true");
		}
		  RequestDispatcher dispatcher = req.getRequestDispatcher(url);
		  dispatcher.forward(req, resp);
	}
}
