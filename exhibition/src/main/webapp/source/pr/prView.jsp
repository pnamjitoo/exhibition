<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/shopping.css?ver=1">
<script type="text/javascript" src="script/pr.js"></script>
</head>
<body>
	<div id="wrap" align="center">
		<h1>홍보 게시글 상세보기</h1>
		<table>
			<tr>
				<th>작성자번호</th>
				<td>${pr.mem_no}</td>
				<th>사진</th>
				<td><img src="./images/${pr.pr_photo}" width="100" height="100"></td>
				<%-- <td>${pr.pr_photo}</td> --%>
			</tr>
			<tr>
				<th>작성일</th>
				<td><fmt:formatDate value="${pr.rdate}" /></td>
				<th>조회수</th>
				<td>${pr.readcount }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="3">${pr.title }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3"><pre>${pr.descript }</pre></td>
			</tr>
		</table>
		<br> <br> <input type="button" value="게시글 수정"
			onclick="open_win('/exhibition/PrServlet?command=pr_check_pass_form&pr_no=${pr.pr_no}', 'update')">
		<input type="button" value="게시글 삭제"
			onclick="open_win('/exhibition/PrServlet?command=pr_check_pass_form&pr_no=${pr.pr_no}', 'delete')">
		<input type="button" value="게시글 리스트"
			onclick="location.href='/exhibition/PrServlet?command=pr_list'"> 
		<input type="button" value="게시글 등록"
			onclick="location.href='/exhibition/PrServlet?command=pr_write_form'">
	</div>
</body>
</html>