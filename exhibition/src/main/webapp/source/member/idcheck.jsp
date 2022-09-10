<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="/exhibition/source/member/member.js" charset="utf-8"></script>
</head>
<body>
	<h2>아이디 중복확인</h2>
	<form action="/exhibition/MemberServlet?" method="get" name="frm">
		<input type="hidden" name="command" value="idcheck">
	아이디	<input type="text" name="id" value="${id}">
		<input type="submit" value="중복 체크" onclick="return idCheck()">
	<br>
	    <c:if test="${result==1}">
			<script type="text/javascript">
				opener.document.frm.id.value="";
			</script>
			${id}는 이미 사용 중인 아이디입니다.
	    </c:if>
		<c:if test="${result==-1}">
			${id}는 사용 가능한 아이디입니다.
			<input type="button" value="사용" class="cancel" onclick="idok()">
		</c:if>
	</form> 
</body>
</html>