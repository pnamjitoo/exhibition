<%@page import="com.exhibition.member.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link href="${pageContext.request.contextPath}/css/reset.css?ver=1" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/mypage.css?ver=1" rel="stylesheet">

    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.clickToGiveClass.js?ver=1"></script>
    <script src="${pageContext.request.contextPath}/js/script.js?ver=1"></script>
    <script src="${pageContext.request.contextPath}/js/mypagescript.js?ver=1"></script>
</head>
<body>
	<%@include file="/source/main/header.jsp" %>
	<main>
	<% 
	if (session.getAttribute("memUpdate") != null) {%>
		<script>alert("회원정보 수정이 완료되었습니다.")</script>
		<% session.setAttribute("memUpdate", null);
	} 
  	request.setCharacterEncoding("utf-8");
  	response.setCharacterEncoding("utf-8");
  	MemberVO userData = new MemberVO();
	  	try {
	  		userData = (MemberVO) request.getAttribute("userData");
			////////member fields/////////
			int mem_no = userData.getMem_no();
			String id = userData.getId();
			String pwd = userData.getPwd();
			String mem_name = userData.getMem_name();
			String nick = userData.getNick();
			String age = userData.getAge();
			String gender = userData.getGender();
			String tel = userData.getTel();
			String addr = userData.getAddr();
			int rank = userData.getRank();%>

       <div id="mypage_wrap" class="" >
       </div><!--//mypage_wrap-->
           <div id="page_menu">
               <div class="logo">
                   LOGO ID
               </div><!--//logo-->
               <div class="user_name">
                   <%=mem_name%>
               </div><!--//user_name-->
               <div class="user_nick">
                   <%=nick%>
               </div><!--//user_nick-->
               <div id="page_btn">
                   <ul>
                       <li>
                           <input type="radio" name="page_btn" id="profile" checked>
                           <label for="profile" id="profile_btn">내프로필</label>
                       </li>
                       <li>
                           <input type="radio" name="page_btn" id="cart">
                           <label for="cart" id="cart_btn">구매내역</label>
                       </li>
                   </ul>
               </div><!--//page_btn-->
               <div class="hr"></div>

           </div><!--//page_menu-->
           <div id="page_layer">
               <div id="profile_layer" class="open">
                   <div id="profile_basic">
                       <h2>기본정보</h2>
                       <div id="profile_name" class="profile_form">
                           <%=mem_name%>
                       <button type="button" class="profile_btn" id="regist_open">수정</button>
                           <div id="profile_regist" class="">
                               <h3>이름변경</h3>
                               <div id="regist_name">
                                   <span>이전정보 :</span> <%=mem_name%>
                               </div><!--//regist_name-->
                               <div id="regist_update">
                                   <form action="/exhibition/MemberServlet?command=memberupdate" method="post">
                                   <input type="text" name="mem_name" placeholder="이름을 입력해주세요."><br>
                                   <input type="submit" value="수정완료">
                                   <button type="button" class="profile_btn" id="regist_close">취소</button>
                                   </form>
                               </div><!--//regist_update-->
                           </div><!--//profile_regist-->
                       </div><!--//profile_name-->
                       <div id="profile_nick" class="profile_form">
                           <%=nick%>
                           <button type="button" class="profile_btn">수정</button>
                       </div><!--//profile_nick-->
                       <div id="profile_tel" class="profile_form">
                           <img src="image/phone.png"><span> <%=tel%></span>
                           <button type="button" class="profile_btn">수정</button>
                       </div>
                   </div><!--//profile_basic-->
<!-- 
멤버 필드에서 멤버넘버, 아이디, 랭크 빼고 수정 가능하게 해주세요
랭크는 조회만 가능 
-->
                   <div id="profile_addr">
                       <h2>주소</h2>
                       <div id="addr" class="profile_form">
                           <%=addr%>
                           <button type="button" class="profile_btn">수정</button>
                       </div>
                   </div><!--//profile_addr-->
                   <a href="/exhibition/MemberServlet?command=delete" id="regist_delete">탈퇴하기</a>
               </div><!--//profile_layer-->
               <div id="cart_layer" class="">
                   <div id="cart_form">
                   </div>
               </div>
           </div><!--//page_layer-->

   </main><!--//main-->

   <%@include file="/source/main/footer.jsp" %>
 	<%			} catch ( NullPointerException e) {
 				response.sendRedirect("/exhibition/source/member/login.jsp");
			}%> 