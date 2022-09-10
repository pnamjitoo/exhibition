package com.exhibition.pr;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exhibition.controller.Action;

public class PrViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "/source/pr/prView.jsp";
		String pr_no = request.getParameter("pr_no");
		PrDAO pDao = PrDAO.getInstance();
		pDao.updateReadCount(pr_no);
		PrVO pVo = pDao.selectOnePrByPr_no(pr_no);
		request.setAttribute("pr", pVo);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
