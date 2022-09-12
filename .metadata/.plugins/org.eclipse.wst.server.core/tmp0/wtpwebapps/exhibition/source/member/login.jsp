<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
	<link href="${pageContext.request.contextPath}/css/reset.css?ver=1">
    <link href="${pageContext.request.contextPath}/css/login.css?ver=1" rel="stylesheet">
    <script type="text/javascript" src="/exhibition/source/member/member.js" charset="utf-8"></script>
</head>
<body>
	<main>
<!-- 자바스크립트 팝업창 -->
       <%@ include file="/source/main/header.jsp" %>
     <%if (session.getAttribute("login") == "true") {%>
     	<script>alert("로그인에 성공했습니다.")</script>
     <%} else if (session.getAttribute("login") == "false") {%>
  	<script>alert("아이디와 비밀번호를 확인해주세요.")</script>
    <% } else if (session.getAttribute("logout") != null) {%>
		<script>alert("로그아웃 되었습니다.")</script>
	<%} else if (session.getAttribute("deleteMem") != null) {%>
		<script>alert("정상적으로 탈퇴했습니다.")</script>
	<%} else if (session.getAttribute("regist") == "true") {%>
		<script>alert("회원가입이 완료되었습니다.")</script>
	<%} else if (session.getAttribute("regist") == "false") { %>
		<script>alert("회원가입에 실패했습니다.")</script>
	<%}
	session.setAttribute("login", null);
	session.setAttribute("logout", null);
	session.setAttribute("deleteMem", null);
	session.setAttribute("regist", null);
	session.setAttribute("not_write", null); %>
     <div id="main_wrap">
     	<div id="login_wrap">
    <%if (session.getAttribute("loginUser") != null) {%> 
<!-- 로그인한 사용자에게 보이는 부분 -->
<div id="login_succes">
          <h2><%=(String)session.getAttribute("loginUser") %>님 환영합니다.</h2>
          <a href="${pageContext.request.contextPath}/source/main/index.jsp">홈으로</a>
          <a href="/exhibition/MemberServlet?command=mypage">마이페이지</a>
          <a href="/exhibition/MemberServlet?command=logout">로그아웃</a>
          <a href="/exhibition/MemberServlet?command=delete" id="regist_delete">회원탈퇴</a>
       </div><!-- 로그인 정보가 없는 사용자에게 보이는 부분-->
	<%}	else { %>
                <form action="/exhibition/MemberServlet?command=login" method="post" name="frm" onsubmit="return loginCheck()" >
                    <table>
                        <tr>    
                            <td>아이디</td>
                            <td><input type="text" name = "id"></td>
                            <td rowspan="2" class="btn"><input type="submit" value="LOGIN"></td>
                        </tr>
                        <tr>    
                            <td>비밀번호</td>
                            <td><input type="text" name = "pwd"></td>
                        </tr>
                    </table>
                </form>
        </div><!--//login_wrap-->
            <div id="login_btn">
	                <ul>
	               		<li><a href="#">아이디찾기</a></li>
	               		<li><a href="#">비밀번호찾기</a></li>
	               		<li><a href="/exhibition/source/member/regist.jsp">회원가입</a></li>
	               	</ul>
            </div><!--//login_btn-->
        </div><!--//main_wrap-->
        <%} %>
    </main><!--//main-->
    <%@include file="/source/main/footer.jsp" %>
</body>
</html>