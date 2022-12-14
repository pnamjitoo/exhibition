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
    <link href="${pageContext.request.contextPath}/css/noticeView.css?ver=1" rel="stylesheet">

</head>
<%@ include file="/source/main/header.jsp" %>
<body>
    <main>
        <div id ="notice_wrap">
            <div id="notice_title">
              ${notice.title }
          <% try {
        	  String rank = String.valueOf(session.getAttribute("rank"));
  			  if (rank.equals("0")) {%>
              <input type="button" id="update" value="수정" onclick="location.href='/exhibition/NoticeServlet?command=notice_update_form&num=${notice.not_no}'"/>
              <label for="update">수정</label>
              <input type="button" id="delete" value="삭제" onclick="location.href='/exhibition/NoticeServlet?command=notice_delete&num=${notice.not_no}'">
              <label for="delete">삭제</label>
            <%	}
          	} finally {%>
            </div><!--//notice_title-->
            <div id="notice_sub_title">
                <div id="notice_writer">
                <span class="form">작성자</span><span>${notice.nick }(${notice.id})</span>
                <span class="form">작성일</span><span><fmt:formatDate value="${notice.rdate }"/></span>
				<span>(<fmt:formatDate value="${notice.idate }"/>수정)</span>
				<span class="form">조회수</span><span>${notice.not_rdcnt }</span>
                
                </div><!--//notice_writer-->
            </div><!--//notice_sub_title-->
            <div id="notice_info">
                ${notice.descript }
            </div><!--//notice_info-->

          	<%}%>
        </div><!--//notice_wrap-->
    </main>
</body>
<%@ include file="/source/main/footer.jsp" %>
</html>