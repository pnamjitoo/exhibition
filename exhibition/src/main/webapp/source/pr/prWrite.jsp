<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/shopping.css?ver=1">
<script type="text/javascript" src="js/pr.js"></script>
</head>
<body>
	<div id="wrap" align="center">
		<h1>홍보게시글 등록</h1>
		<form name="frm" method="post" action="PrServlet">
			<input type="hidden" name="command" value="pr_write">
			<table>
				<tr>
					<th>작성자번호</th>
					<td><input type="text" name="mem_no"> * 필수 </td>
				</tr>
				<%-- <tr>
					<th>작성자번호</th>
					<td><input type="text" name="mem_no" disabled>${member.mem_no}</td>
				</tr> --%>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pass"> * 필수 (게시물 수정
						삭제시 필요합니다.)</td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" size="70" name="title"> * 필수</td>
				</tr>
				<tr>
					<th>사진</th>
					<td><input type="file" size="70" name="pr_photo"> * 필수</td>
				</tr>
				
				<!-- <tr>
					<th>사진</th>
					<td><input type="text" size="70" name="pr_photo"> * 필수</td>
				</tr> -->
				<tr>
					<th>장소</th>
					<td><input type="text" size="70" name="place"> * 필수</td>
				</tr>
				<tr>
					<th>설명</th>
					<td><textarea cols="70" rows="15" name="descript"></textarea></td>
				</tr>
			</table>
			<br>
			<br> <input type="submit" value="등록"
				onclick="return prCheck()"> <input type="reset"
				value="다시 작성"> <input type="button" value="목록"
				onclick="location.href='/exhibition/PrServlet?command=pr_list'">
		</form>
	</div>
</body>
</html>