package com.exhibition.pr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exhibition.controller.Action;

public class PrDeleteAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pr_no=request.getParameter("pr_no");
		PrDAO pDao=PrDAO.getInstance();
		pDao.deletePr(pr_no);
		new PrListAction().execute(request, response);
	}
}
