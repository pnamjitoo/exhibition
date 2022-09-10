package com.exhibition.notice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exhibition.controller.Action;

public class NoticeUpdateAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		NoticeVO nVo = new NoticeVO();
		try {
			String num = String.valueOf(request.getParameter("num"));
			NoticeDAO nDao = NoticeDAO.getInstance();
			String id = nDao.selectOneNoticeByNum(num).getId();
			HttpSession session = request.getSession();
			int rank = Integer.parseInt(String.valueOf(session.getAttribute("rank")));
			if (session.getAttribute("loginUser").toString().equals(id) && rank==0){
				nVo.setNot_no(Integer.parseInt(num));
				nVo.setTitle(request.getParameter("title"));
				nVo.setNot_photo(request.getParameter("not_photo"));
				nVo.setDescript(request.getParameter("descript"));
				nDao.updateNotice(nVo);
			} else {
				session.setAttribute("not_update", "false");
			}
		} finally {
			new NoticeListAction().execute(request, response);
		}
	}
}	
