<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link href="${pageContext.request.contextPath}/css/reset.css?ver=1" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/noticeWrite.css?ver=1" rel="stylesheet">
</head>
<body>s
<%@include file="/source/main/header.jsp" %> 
    <main>
    <%try {
    	String rank = String.valueOf(session.getAttribute("rank"));
		if (rank.equals("0")) { 
		response.setCharacterEncoding("utf-8");%>
        <div id="notice_write_wrap">
            <div id="title">
                공지사항 수정
            </div><!--//title-->
            <div id="notice_write">
                <form method="post" action="/exhibition/NoticeServlet">
                <input type="hidden" name="command" value="notice_update">
                <input type="hidden" name="num" value="${notice.not_no}">
                    <table>
                        <tr>
                            <th>제목</th>
                            <td><input type="text" value="${notice.title }" name="title"></td>
                        </tr>
                        <tr>
                            <th>사진</th>
                            <td><label for="input_img" id="upload">업로드</label><input type="file" accept="image/*" value="not_photo" id="input_img"></td>
                        </tr>
                        <tr>
                            <th>내용</th>
                            <td><input type="text" name="descript" value="${notice.descript }" size="50" id="notice_info"></td>
                        </tr>
                    </table>
                    <input type="submit" value="수정완료">
                    <input type="reset" value="다시작성">
                </form>
            </div><!--//notice_write-->
        </div><!--//notice_write_wrap-->
        <%}
	} catch (Exception e) {
		response.sendRedirect("/source/notice/noticeView.jsp");
	}%>
    </main>
</body>
<%@ include file="/source/main/footer.jsp" %>
</html>