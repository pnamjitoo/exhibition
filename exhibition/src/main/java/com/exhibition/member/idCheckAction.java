package com.exhibition.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exhibition.controller.Action;

public class idCheckAction implements Action {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		String id = req.getParameter("id");
		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.confirmID(id);
		req.setAttribute("id", id);
		req.setAttribute("result", result);
		System.out.println(id);
		System.out.println(result);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/source/member/idcheck.jsp");
		dispatcher.forward(req, resp);
	}
}
