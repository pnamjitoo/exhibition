<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>테마 등록 - 관리자 페이지</h1>
<form action ="temaWrite.do" method ="post">
	<table>
		<tr>
			<th> 테마명 </th>
			<td><input type="text" name="tname"></td>
		</tr>
	</table>
	<br>
	<input type = "submit" value="등록" onclick ="return temaCheck()">
	<input type = "reset" value="다시작성">
	<input type ="button"  value="목록" onclick = "location.href = 'temaList.do'">
	


</form>
</body>
</html>