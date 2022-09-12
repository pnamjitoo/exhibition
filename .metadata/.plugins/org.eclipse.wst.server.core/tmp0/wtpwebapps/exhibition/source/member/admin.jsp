<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link href="${pageContext.request.contextPath}/css/reset.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/admin.css" rel="stylesheet">

    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.clickToGiveClass.js"></script>
    <script src="${pageContext.request.contextPath}/js/script.js"></script>

</head>
<body>
<%@include file="/source/main/header.jsp" %>
    <main>
        <div id="admin_wrap">
            <h2>관리자게시판</h2>
            <div id="admin_btn">
                <ul>
                    <li>
                        <input type="radio" name="btn" id="tag" checked>
                        <label for="tag">전시회목록</label>
                    </li>
                    <li>
                        <input type="radio" name="btn" id="cate">
                        <label for="cate">게시판목록</label>
                    </li>
                    <li>
                        <input type="radio" name="btn" id="mem">
                        <label for="mem">맴버목록</label>
                    </li>
                    <li>
                        <input type="radio" name="btn" id="cash">
                        <label for="cash">결제상세목록</label>
                    </li>
                </ul>
            </div><!--//admin_btn-->
        </div><!--//admin_wrap-->
    </main><!--//main-->
    
    <%@include file="/source/main/footer.jsp" %>
</body>
</html>