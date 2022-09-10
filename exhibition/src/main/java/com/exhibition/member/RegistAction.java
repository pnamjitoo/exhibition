package com.exhibition.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegistAction implements com.exhibition.controller.Action {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String mem_name = req.getParameter("mem_name");
		String nick = req.getParameter("nick");
		String age = req.getParameter("age");
		String gender = req.getParameter("gender");
		String tel = req.getParameter("tel");
		String addr = req.getParameter("addr");
		int rank = Integer.parseInt(req.getParameter("rank"));
		
		System.out.println(id + pwd + mem_name + nick + age + gender + tel + addr);
		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.registMember(id, pwd, mem_name, nick, age, gender, tel, addr, rank);
		HttpSession session = req.getSession();
		if (result == 1) {
			session.setAttribute("regist", "true");
		} else {
			session.setAttribute("regist", "false");
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("/source/member/login.jsp");
		dispatcher.forward(req, resp);
	}

}
