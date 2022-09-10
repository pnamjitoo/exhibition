package com.exhibition.notice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exhibition.controller.Action;
import com.exhibition.member.MemberDAO;
import com.exhibition.member.MemberVO;

public class NoticeWriteAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		try {
			MemberDAO mDao = MemberDAO.getInstance();
			MemberVO user = mDao.getMember((String)session.getAttribute("loginUser"));
			String id = user.getId();
			int rank = Integer.parseInt(String.valueOf(session.getAttribute("rank")));
			if (rank == 0) {
				String nick = user.getNick();
				NoticeVO nVo = new NoticeVO();
				nVo.setId(id);
				nVo.setNick(nick);
				nVo.setTitle(request.getParameter("title"));
				nVo.setNot_photo(request.getParameter("not_photo"));
				nVo.setDescript(request.getParameter("discript"));
				NoticeDAO nDao = NoticeDAO.getInstance();
				nDao.insertNotice(nVo);
				session.setAttribute("not_write", nick);
			} else {
				session.setAttribute("not_write", "false");
			}
		} catch(Exception e) {
			session.setAttribute("not_write", "false");
		} finally {
			new NoticeListAction().execute(request, response);
		}
	}
}
