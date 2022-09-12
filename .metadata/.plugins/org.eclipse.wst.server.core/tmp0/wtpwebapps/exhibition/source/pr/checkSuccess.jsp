<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
if (window.name == "update") {
window.opener.parent.location.href = "/exhibition/PrServlet?command=pr_update_form&pr_no=${param.pr_no}";
} else if (window.name == 'delete') {
alert('삭제되었습니다.');
window.opener.parent.location.href = "/exhibition/PrServlet?command=pr_delete&pr_no=${param.pr_no}";
}
window.close();
</script>
</body>
</html>