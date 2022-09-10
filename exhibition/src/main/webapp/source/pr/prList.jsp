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
</head>
<body>
	<div id="wrap" align="center">
		<h1>홍보 게시글 리스트</h1>
<!-- 게시글이 몇개인지 표기해야함, 10개 이상일시 페이지 넘어가도록 설정 -->
		<table class="list">
			<tr>
				<td colspan="5" style="border: white; text-align: right"><a
					href="/exhibition/PrServlet?command=pr_write_form">홍보게시글 등록</a></td>
			</tr>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자번호</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<c:forEach var="pr" items="${prList }"> <!-- request.setAttribute("prList",prList) -->
				<tr class="record">
					<td>${pr.pr_no }</td>
					<td><a href="/exhibition/PrServlet?command=pr_view&pr_no=${pr.pr_no}">
							${pr.title } </a></td>
					<td>${pr.mem_no}</td>
					<td><fmt:formatDate value="${pr.rdate }" /></td>
					<td>${pr.readcount}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>