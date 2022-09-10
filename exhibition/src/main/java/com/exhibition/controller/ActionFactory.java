package com.exhibition.controller;

import com.exhibition.member.DeleteAction;
import com.exhibition.member.LoginAction;
import com.exhibition.member.LogoutAction;
import com.exhibition.member.MemberUpdateAction;
import com.exhibition.member.MypageAction;
import com.exhibition.member.RegistAction;
import com.exhibition.member.idCheckAction;
import com.exhibition.notice.NoticeDeleteAction;
import com.exhibition.notice.NoticeListAction;
import com.exhibition.notice.NoticeUpdateAction;
import com.exhibition.notice.NoticeUpdateActionForm;
import com.exhibition.notice.NoticeViewAction;
import com.exhibition.notice.NoticeWriteAction;
import com.exhibition.notice.NoticeWriteFormAction;
import com.exhibition.pr.PrDeleteAction;
import com.exhibition.pr.PrListAction;
import com.exhibition.pr.PrUpdateAction;
import com.exhibition.pr.PrUpdateFormAction;
import com.exhibition.pr.PrViewAction;
import com.exhibition.pr.PrWriteAction;
import com.exhibition.pr.PrWriteFormAction;
import com.exhibition.tema.TemaDeleteAction;
import com.exhibition.tema.TemaListAction;
import com.exhibition.tema.TemaUpdateAction;
import com.exhibition.tema.TemaWriteAction;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory(); //싱글톤

	private ActionFactory() {
		super();
	}

	public static ActionFactory getInstance() {
		return instance;
	}

public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory :" + command);
	/////******* member *******/////
		// 로그인 //
		if (command.equals("login")) {
			action = new LoginAction();
		// 로그아웃 //
		} else if (command.equals("logout")) {
			action = new LogoutAction();
		// 회원등록 //
		} else if (command.equals("regist")) {
			action = new RegistAction();
		// 마이페이지 //
		} else if (command.equals("mypage")) {
			action = new MypageAction();
		// 회원탈퇴 //
		} else if (command.equals("delete")) {
			action = new DeleteAction();
		// 회원정보 수정 //
		} else if (command.equals("memberupdate")) {
			action = new MemberUpdateAction();
		// 아이디 중복 검사 //
		} else if (command.equals("idcheck")) {
			action = new idCheckAction();
		}
	//////******* notice *******//////
		// 공지사항 목록 //
		if (command.equals("notice_list")) {
			action = new NoticeListAction();
		// 공지사항 작성 폼 //
		}else if (command.equals("notice_write_form")) {
			action = new NoticeWriteFormAction();
		// 공지사항 등록 //
		}else if(command.equals("notice_write")) {
			action = new NoticeWriteAction();
		// 공지사항 조회 //
		}else if(command.equals("notice_view")) {
			action = new NoticeViewAction();
		// 공지사항 삭제 //
		}else if(command.equals("notice_delete")) {
			action = new NoticeDeleteAction();
		// 공지사항 수정 //
		}else if(command.equals("notice_update")) {
			action = new NoticeUpdateAction();
		// 공지사항 수정 폼 //
		}else if(command.equals("notice_update_form")) {
			action = new NoticeUpdateActionForm();
		}
	//////******* pr *******//////
		// 홍보게시판 목록 //
		if (command.equals("pr_list")) {
			action = new PrListAction();
		// 홍보게시판 작성 폼 //
		} else if (command.equals("pr_write_form")) {
			action = new PrWriteFormAction();
		// 홍보게시판 등록 //
		} else if (command.equals("pr_write")) {
			action = new PrWriteAction();
		// 홍보게시판 상세 조회 //
		} else if (command.equals("pr_view")) {
			action = new PrViewAction();
		// 홍보게시판 수정 폼 //
		} else if (command.equals("pr_update_form")) {
			action = new PrUpdateFormAction();
		// 홍보게시판 수정 //
		} else if (command.equals("pr_update")) {
			action = new PrUpdateAction();
		// 홍보게시판 삭제 //
		} else if (command.equals("pr_delete")) {
			action = new PrDeleteAction();
		}
		//////******* tema *******//////
		// 테마 목록 //
		if (command.equals("tema_list")) {
			action = new TemaListAction();
		// 테마 등록 //
		}else if(command.equals("tema_write")) {
			action = new TemaWriteAction();
		// 테마 삭제 //
		}else if(command.equals("tema_delete")) {
			action = new TemaDeleteAction();
		// 테마 수정 //
		}else if(command.equals("tema_update")) {
			action = new TemaUpdateAction();
		}
		return action;
	}
}
