package com.exhibition.tema;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exhibition.controller.Action;
import com.exhibition.notice.NoticeListAction;


public class TemaWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession();
		try {
			int rank = Integer.parseInt(String.valueOf(session.getAttribute("rank")));
			if (rank == 0 || rank == 1) {
				TemaVO tVo = new TemaVO();
				tVo.setTname(req.getParameter("tname"));
				TemaDAO tDao = TemaDAO.getInstance();
				tDao.insertTema(tVo);
				session.setAttribute("tema_write", "true");
			} else {
				session.setAttribute("not_write", "false");
			}
		} catch(Exception e) {
			session.setAttribute("not_write", "false");
		} finally {
			new NoticeListAction().execute(req, resp);
		}
	}

}
