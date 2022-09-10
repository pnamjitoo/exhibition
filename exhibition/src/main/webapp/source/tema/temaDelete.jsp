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
 <h1>상품 삭제 - 관리자 페이지</h1>
 <form action ="temaDelete.do" method="post">
 	<br>
 	<input type ="hidden" name="tema_no" value="${tema.tema_no}">
 	<h1>삭제 하시겠습니까?</h1> 
 	<input type = "submit" value = "삭제">
 	<input type ="button" value="취소" onclick="location.href = 'temaList.do'">
 </form>
</body>
</html>