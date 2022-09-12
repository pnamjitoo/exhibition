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
    <link href="${pageContext.request.contextPath}/css/itemInfo.css?ver=1" rel="stylesheet">

</head>
<!-- 아이템 리스트 불러오는 ajax 통신 ------------------------------->
<script src="https://code.jquery.com/jquery-3.6.0.slim.js" integrity="sha256-HwWONEZrpuoh951cQD1ov2HUK5zA5DwJ1DNUXaM6FsY=" crossorigin="anonymous"></script>
<script type="text/javascript">
    $(document).ready(function(){
    	function getParameterByName(name) {
		  name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
		  var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
		  results = regex.exec(window.location.search);
		  return results == null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
		}
    	
    	//아이템 호출//
    	var item_no = getParameterByName('item_no');
    	var url = "/exhibition/ItemServlet?command=item_view&item_no=" + item_no
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
                    var itemList = JSON.parse(JSON.stringify(item[0]));
                    console.log(itemList);
                    console.log(JSON.stringify(itemList["item_no"]));
                    var item_no = itemList["item_no"].toString();
                    var item_name = itemList["item_name"].toString();
                    var price = itemList["price"].toString();
                    var benefit = itemList["benefit"].toString();
                    var sale = itemList["sale"].toString();
                    var num = itemList["num"].toString();
                    var item_content = itemList["item_content"].toString();
                    var place = itemList["place"].toString();
                    var location = itemList["location"].toString();
                    var likes = itemList["likes"].toString();
                    var hits = itemList["hits"].toString();
                    var opendate = itemList["opendate"].toString();
                    var closedate = itemList["closedate"].toString();
                    var item_photo = itemList["item_photo"].toString();
                    var runtime = itemList["runtime"].toString();
                    var item_age = itemList["item_age"].toString();
                    var item_rdate = itemList["item_rdate"].toString();
                    var tema_no = itemList["tema_no"].toString();
	                $("#item_index").html(item_name + "<span>" + hits + "</span><span id=\"count\">조회수 :</span><span>" + item_rdate + "</span><span id=\"add\">등록날짜 :</span>");
	                $("#item_img").html("<img src=\"" + item_photo + "\">");
	                $("#item_text").html("<div class=\"head\">이름</div><div class=\"text\">" + item_name + "</div><div class=\"head\">지역</div><div class=\"text\">" + location + "</div><div class=\"head\">개최장소</div><div class=\"text\">"+place+"</div><div class=\"head\">가격</div><div class=\"text\">" + price + "원</div><div class=\"head\">할인율</div><div class=\"text\">" + sale + "%</div><div class=\"head\">혜택</div><div class=\"text\">"+benefit+"</div><div class=\"head\">재고</div><div class=\"text\">" + num + "매</div><div class=\"head\">관람시간</div><div class=\"text\">"+runtime+"</div><div class=\"head\">관람연령</div><div class=\"text\">"+item_age+"</div><div class=\"head\">개장날짜</div><div class=\"text\">" + opendate + "</div><div class=\"head\">종료날짜</div><div class=\"text\">" + closedate + "</div><div id=\"fav\">좋아요 : <span>" + likes + "</span></div>");
	                $("#info").html("<img src=\"" + item_content + "\">");
	            });
	        }
	    });
    });
</script>
<body>
    <%@ include file="/source/main/header.jsp" %>
    
    <main>
        <h2 id="item_index">
<!--             전시회이름 
            <span>1</span>
            <span  id="count">조회수 :</span>
            <span>2020.09.13</span>
            <span id="add">등록날짜 :</span> -->
        </h2>
        <div id="item_img">

        </div>
        <div id="item_text">
<!--             <div class="head">
                이름
            </div>//head
            <div class="text">
                O O 전시회
            </div>//text
            <div class="head">
                개최장소
            </div>//head
            <div class="text">
                 서울시
            </div>//text
            <div class="head">
                가격
            </div>//head
            <div class="text">
                 12345원
            </div>//text
            <div class="head">
                할인율
            </div>//head
            <div class="text">
                 5%
            </div>//text
            <div class="head">
                재고
            </div>//head
            <div class="text">
                 100개
            </div>//text
            <div class="head">
                개장날짜
            </div>//head
            <div class="text">
                 2020.09.15
            </div>//text
            <div class="head">
                종료날짜
            </div>//head
            <div class="text">
                 2020.09.18
            </div>//text
            <div id="fav">
                좋아요 : <span>1</span>
            </div> -->
        </div><!--//item_text-->
        <div id="item_info">
<!--             <h2>전시회설명</h2>
            <div  class="info">
                이 전시회는 ...
            </div>//info -->
        </div><!--//item_info-->
        <div id="rev_photo">
            <h2>리뷰사진</h2>
            <ul>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
            </ul>
        </div>
    </main>
    
    <%@include file="/source/main/footer.jsp" %>
</body>
</html>