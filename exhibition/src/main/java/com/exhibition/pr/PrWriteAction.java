package com.exhibition.pr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exhibition.controller.Action;

public class PrWriteAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrVO pVo = new PrVO();
		pVo.setMem_no(Integer.parseInt(request.getParameter("mem_no")));
		pVo.setPass(request.getParameter("pass"));
		pVo.setTitle(request.getParameter("title"));
		pVo.setPr_photo(request.getParameter("pr_photo"));
		pVo.setPlace(request.getParameter("place"));
		pVo.setDescript(request.getParameter("descript"));
		PrDAO pDao = PrDAO.getInstance();
		pDao.insertPr(pVo);
		new PrListAction().execute(request, response);
	}
}
