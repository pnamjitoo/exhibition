<%@page import="com.exhibition.tema.TemaVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link href="${pageContext.request.contextPath}/css/reset.css?ver=1" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/board.css?ver=1" rel="stylesheet">
</head>
<!-- 테마, 아이템 리스트 불러오는 ajax 통신 ------------------------------->
<script src="https://code.jquery.com/jquery-3.6.0.slim.js" integrity="sha256-HwWONEZrpuoh951cQD1ov2HUK5zA5DwJ1DNUXaM6FsY=" crossorigin="anonymous"></script>
<script type="text/javascript">
    $(document).ready(function(){
    	function getParameterByName(name) {
		  name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
		  var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
		  results = regex.exec(window.location.search);
		  return results == null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
		}
    	
    	//테마 호출
        $.ajax({
            type : "GET",
            url : "/exhibition/TemaServlet?command=tema_list",
            async : false,
            error : function(){
                alert("통신실패-tema");
            },
            success : function(result){
                var html = "";
                $.each(JSON.parse(result), function(index, item) {
                	for (var i=0; i<item.length; i++){
	                    var temaList = JSON.parse(JSON.stringify(item[i]));
	                    var tema_no = temaList["tema_no"].toString();
	                    var tname = temaList["tname"].toString();
	                    html = html + "<option value=\"" + tema_no + "\">" + tname + "</option>";
                	}
                });
        		$("#cate").html(html);
            }
        });
    	//아이템 목록 호출//
    	var tema_no = getParameterByName('tema_no');
    	var html = "";
    	var url = "/exhibition/ItemServlet?command=item_list&tema_no=" + tema_no
		$.ajax({
	        type : "POST",
	        url : url,
	        async : false,
	        error : function(){
	        	html = "<h2>상품 내역이 존재하지 않습니다.</h2>"
	        	$("#item").html(html);
	        },
	        success : function(result){
	            $.each(JSON.parse(result), function(index, item) {
	            	for (var i=0; i<item.length; i++){
	                    var itemList = JSON.parse(JSON.stringify(item[i]));
	                    var item_no = itemList["item_no"].toString();
	                    var item_name = itemList["item_name"].toString();
	                    var item_photo = itemList["item_photo"].toString();
	                    var tema_no = itemList["tema_no"].toString();
						html = html + "<div class=\"item_photo\"><a href=\"/exhibition/source/item/itemInfo.jsp?item_no=" + item_no + "\"><img src=\"" + item_photo + "\"></a></div>";
						html = html + "<div class=\"item_name\"><a href=\"/exhibition/source/item/itemInfo.jsp?item_no=" + item_no + "\">" + item_name + "</a></div>";
	            	}
	            });
	    		$("#item").html(html);
	        }
	    });
    });
</script>
<%@ include file="/source/main/header.jsp" %>
<!--------------------------------------------------------->
<body>
    <main>
        <div id="board_wrap">
            <h2>전체보기</h2>
            <div id="sort_bar">
            	<form>
                    <select name="local" id="local" class="sort_form">
                        <option value>지역</option>
                        <option value="">서울특별시</option>
                        <option value="">부산광역시</option>
                        <option value="">대구광역시</option>
                        <option value="">인천광역시</option>
                        <option value="">대전광역시</option>
                        <option value="">광주광역시</option>
                        <option value="">울산광역시</option>
                        <option value="">세종특별자치시</option>
                        <option value="">경기도</option>
                        <option value="">강원도</option>
                        <option value="">충천북도</option>
                        <option value="">충천남도</option>
                        <option value="">전라북도</option>
                        <option value="">전라남도</option>
                        <option value="">경상북도</option>
                        <option value="">경상남도</option>
                        <option value="">제주특별자치도</option>
                    </select>
                    <select name="price" id="price" class="sort_form">
                        <option value>이용금액</option>
                        <option value="0">무료</option>
                        <option value="1">유료</option>
                    </select>
                    <select name ="cate" id="cate" class="sort_form">
<!-- 테마 ajax 들어오는 곳 -->
                    </select>
                    <span>기간</span>
                    <input type="date" value="start" id="start_date">
                    <span>-</span>
                    <input type="date" value="finish" id="finish_date">
                    <input type="text" name="search_text" id="search_text" placeholder="공연명을 입력하세요.">
                    <button type="button" class="btn" >검색</button>
                    <button type="button" class="btn_reset" >초기화</button>
                </form>
            </div><!--//sort_bar-->

            <div id="item_view">
                <div class="item" id="item">
<!-- 아이템 ajax 들어오는 곳 -->
                </div>
            </div><!--//item view-->
        </div><!--//board_wrap-->
    </main>
    <%@include file="/source/main/footer.jsp" %>
</body>
</html>