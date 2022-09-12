<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 테마 리스트 관리자 페이지</h1>
	<table class="list">
	<tr>
		<td colspan="5" style="border: white; text-align: center">
			<a href="temaWrite.do">테마 등록</a>
		</td>
	</tr>
	
		<tr><th>번호</th><th>테마	명</th><th> 테마 수정</th><th>테마 삭제</th></tr>
		
		<c:forEach var = "tema" items = "${temaList}" >
			<tr>
				<td>${tema.tema_no}</td>
				<td>${tema.tname}</td>				
				<td><a href="temaUpdate.do?tema_no=${tema.tema_no}"> 수정 </a></td>
				<td><a href="temaDelete.do?tema_no=${tema.tema_no}"> 삭제 </a></td>
			</tr>
		</c:forEach>
	</table>
		
</body>
</html>