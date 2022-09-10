<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link href="${pageContext.request.contextPath}/css/reset.css?ver=1" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/notice.css?ver=1" rel="stylesheet">
</head>
<body>
	<%@include file="/source/main/header.jsp" %>
	<%if(session.getAttribute("not_list") == null){
		  response.sendRedirect("/exhibition/NoticeServlet?command=notice_list");
	  } else {
		  session.setAttribute("not_list", null);
	  }
	  if (session.getAttribute("message") != null) { %>
		<script>alert(${message})</script> 
		<%}
		session.setAttribute("not_write", null);
		session.setAttribute("not_update", null);%>
    <main>
        <div id ="notice_wrap">
            <h2>공지사항</h2>
        	<div id="notice_write_form">
        		<a href="/exhibition/NoticeServlet?command=notice_write_form">공지사항등록</a>
        	</div>
            <table>
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>작성일</th>
                    <th>조회수</th>
                </tr>
                <c:forEach var="notice" items="${noticeList}">
                <tr>
                    <td>${notice.not_no }</td>
                    <td><a href="/exhibition/NoticeServlet?command=notice_view&num=${notice.not_no }">${notice.title}</a></td>
                    <td>${notice.nick }(${notice.id })</td>
                    <td><fmt:formatDate value="${notice.rdate }"/></td>
                    <td>${notice.not_rdcnt}</td>
                </tr>
<!-- 작성하는 버튼 추가 -->
                </c:forEach>
            </table>
        </div><!--//notice_wrap-->
    </main>
    <%@ include file="/source/main/footer.jsp" %>
</body>
</html>