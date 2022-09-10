<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 테마 수정</title>
</head>
<body>
	<h1>테마 수정 관리자 페이지</h1>
	<form method="post" action = "temaUpdate.do">
	<input type="hidden" name="tema_no" value="${tema.tema_no}">
	
	<table>
	<tr>
		<th> 테마명 </th>
		<td><input type = "text" name="tname" value="${tema.tname}"></td>
	</tr>		
	</table>
	<br>
	<input type="submit" value = "수정" onclick ="return temaCheck()">
	<input type="reset" value = "원본">
	<input type="button" value ="목록" onclick ="location.href='temaList.do'">
	</form>
</body>
</html>