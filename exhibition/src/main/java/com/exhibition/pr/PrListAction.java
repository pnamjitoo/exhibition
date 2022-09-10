package com.exhibition.pr;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exhibition.controller.Action;

public class PrListAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "/source/pr/prList.jsp";
		PrDAO pDao = PrDAO.getInstance();
		List<PrVO> prList = pDao.selectAllPrs();
		request.setAttribute("prList", prList);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
