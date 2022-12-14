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
	<script type="text/javascript" src="/exhibition/source/member/member.js" charset="utf-8"></script>
	<link href="${pageContext.request.contextPath}/css/reset.css?ver=1" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/regist.css?ver=1" rel="stylesheet">
</head>
<body>
	<%@ include file="/source/main/header.jsp" %>
	<%response.setCharacterEncoding("utf-8");%>
    <main>
        <div id="regist_wrap">
            <form action="/exhibition/MemberServlet?command=regist" method="post" name="frm">
                <table>
                	<tr>
		                <td>아이디</td>
		                <td>
		                <input type="text" name="id" id="id">
		                <input type="hidden" name="reid">
<!-- 아이디 옆으로 중복체크 버튼 올려주세요	 -->	                		                
		        		<input type="button" value="중복체크" onclick="openCheck()">
		        		</td>
        			</tr>
        			<tr>
                        <td>비밀번호</td>
                        <td><input type="password" name="pwd"></td>
                    </tr>
                    <tr>
                        <td>비밀번호 확인</td>
                        <td><input type="password" name="pwd1"></td>
                    </tr>
                    <tr>
                        <td>이름</td>
                        <td><input type="text" name="mem_name"></td>
                    </tr>
                    <tr>
                        <td>닉네임</td>
                        <td><input type="text" name="nick"></td>
                    </tr>
                    <tr>
                        <td>나이</td>
                        <td><input type="text" name="age"></td>
                    </tr>
                    <tr>
                        <td>성별</td>
                        <td>
                            <label for="남">남</label>
                            <input type="radio" name="gender" value="남" id="남">
                            <label for="여">여</label>
                            <input type="radio" name="gender" value="여" id="여"> 
                        </td>
                    </tr>
                    <tr>
                        <td>전화번호</td>
                        <td><input type="tel" name="tel" placeholder="000-0000-0000"></td>
                    </tr>
                    <tr>
                        <td>주소</td>
                        <td><input type="text" name="addr"></td>
                    </tr>
                    <tr>
                        <td>가입유형</td>
                        <td>
                            <label for="판매자">판매자</label>
                            <input type="radio" name="rank" value="1" id="판매자">
                            <label for="일반가입자">일반가입자</label>
                            <input type="radio" name="rank" value="2" id="일반가입자" checked="checked">
                        </td>
                    </tr>
    				<tr>
                        <td colspan="2"><input type="submit" value="확인" onclick="return registCheck()">
                        <input type="reset" value="취소"></td>
                    </tr>
<%--                     <tr><td colspan="2">${message }</td></tr> --%>
                </table>
            </form>
        </div><!--//regist_wrap-->
    </main><!--//main-->
     <%@include file="/source/main/footer.jsp" %>
</body>
</html>