/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.65
 * Generated at: 2022-09-12 15:16:26 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.source.notice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class noticeWrite_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("/WEB-INF/lib/standard.jar", Long.valueOf(1662538386000L));
    _jspx_dependants.put("jar:file:/C:/dev/exhibition/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/exhibition/WEB-INF/lib/standard.jar!/META-INF/c.tld", Long.valueOf(1098678690000L));
    _jspx_dependants.put("/source/main/header.jsp", Long.valueOf(1662980560602L));
    _jspx_dependants.put("/source/main/footer.jsp", Long.valueOf(1662863473093L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("    <title>Page Title</title>\r\n");
      out.write("    <meta name='viewport' content='width=device-width, initial-scale=1'>\r\n");
      out.write("    <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/css/reset.css?ver=1\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/css/noticeWrite.css?ver=1\" rel=\"stylesheet\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset='utf-8'>\r\n");
      out.write("    <meta http-equiv='X-UA-Compatible' content='IE=edge'>\r\n");
      out.write("    <title>Page Title</title>\r\n");
      out.write("    <meta name='viewport' content='width=device-width, initial-scale=1'>\r\n");
      out.write("    <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/css/reset.css?ver=1\" rel=\"stylesheet\"/>\r\n");
      out.write("    <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/css/header.css?ver=1\" rel=\"stylesheet\"/>\r\n");
      out.write("\r\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.2.1.min.js\"></script>\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/js/jquery.bxslider.js?ver=1\" ></script>\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/js/jquery.clickToGiveClass.js?ver=1\"></script>\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/js/jquery.scrollToGiveClass.js?ver=1\"></script>\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/js/jquery.slidy.js?ver=1\"></script>\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/js/script.js?ver=1\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<!-- 테마 리스트 불러오는 ajax 통신 ------------------------------->\r\n");
      out.write("<script type=\"text/javascript\" language=\"javascript\">\r\n");
      out.write("    $(document).ready(function(){\r\n");
      out.write("        $.ajax({\r\n");
      out.write("            type : \"GET\",\r\n");
      out.write("            url : \"/exhibition/TemaServlet?command=tema_list\",\r\n");
      out.write("            error : function(){\r\n");
      out.write("                alert(\"통신실패!!!!\");\r\n");
      out.write("            },\r\n");
      out.write("            success : function(result){\r\n");
      out.write("                var html = \"\";\r\n");
      out.write("                $.each(JSON.parse(result), function(index, item) {\r\n");
      out.write("                	for (var i=0; i<item.length; i++){\r\n");
      out.write("	                    //alert(index + \": \" + JSON.stringify(item[i]));\r\n");
      out.write("	                    var temaList = JSON.parse(JSON.stringify(item[i]));\r\n");
      out.write("	                    var tema_no = temaList[\"tema_no\"].toString();\r\n");
      out.write("	                    var tname = temaList[\"tname\"].toString();\r\n");
      out.write("						html = html + \"<h2>\" + tname + \"</h2>\"\r\n");
      out.write("						html = html + \"<li><a href=\\\"/exhibition/source/item/board.jsp?tema_no=\" + tema_no + \"\\\">\" + tname + \"</a></li>\";\r\n");
      out.write("                	}\r\n");
      out.write("                });\r\n");
      out.write("        		$(\"#tema\").html(html);\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("    });\r\n");
      out.write("</script>\r\n");
      out.write("<!--------------------------------------------------------->\r\n");
      out.write("    <div id=\"wrap\">\r\n");
      out.write("        <header>\r\n");
      out.write("            <div id=\"logo\">\r\n");
      out.write("				<img width='350' height='90' src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/image/exhiplat.png\">\r\n");
      out.write("            </div><!--//logo-->\r\n");
      out.write("            <div id=\"top_menu\">\r\n");
      out.write("                <ul>\r\n");
      out.write("<!-- 로그인한 사용자에게 보이는 구성,\r\n");
      out.write("로그아웃한 사용자에게 보이는 구성대로 나눠주세요      -->       \r\n");
      out.write("				<!-- 로그인 정보가 없는 사용자  -->   \r\n");
      out.write("                ");
if (session.getAttribute("loginUser") == null) {
      out.write("\r\n");
      out.write("                    <li><a href=\"/exhibition/source/member/login.jsp\">login</a></li>\r\n");
      out.write("                    <li><a href=\"/exhibition/source/member/regist.jsp\">join</a></li>\r\n");
      out.write("                ");
} else { 
      out.write("\r\n");
      out.write("                <!-- 로그인 정보가 있는 사용자  -->\r\n");
      out.write("                	<li><a href=\"/exhibition/MemberServlet?command=logout\">logout</a></li>\r\n");
      out.write("                ");
} 
      out.write("\r\n");
      out.write("                    <li><a href=\"/exhibition/source/pay/cart.jsp\">cart</a></li>\r\n");
      out.write("                    <li><a href=\"/exhibition/MemberServlet?command=mypage\">my page</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div><!--//top_menu-->\r\n");
      out.write("            <nav id=\"main_menu\">\r\n");
      out.write("                <ul>\r\n");
      out.write("                    <li><a href=\"/exhibition/source/item/board.jsp\">exhibition</a>\r\n");
      out.write("                        <div id=\"menu_sub\">\r\n");
      out.write("                            <ul id = \"tema\">        	\r\n");
      out.write("<!-- 테마 리스트 출력되는 부분 -->\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li><a href=\"#\">promotion</a></li>\r\n");
      out.write("                    <li><a href=\"/exhibition/NoticeServlet?command=notice_list\">notice</a></li>\r\n");
      out.write("                    <li><a href=\"#\">review</a></li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                    <label for=\"search\"></label>\r\n");
      out.write("                    <input type=\"checkbox\" id=\"search\" >\r\n");
      out.write("                        <div id=\"search_bar\">\r\n");
      out.write("                            <form>\r\n");
      out.write("                                <input type=\"text\" name=\"search\">\r\n");
      out.write("                                <label for=\"search_btn\"></label>\r\n");
      out.write("                                <input type=\"submit\" value=\"검색\" id=\"search_btn\">\r\n");
      out.write("                            </form>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </nav><!--//main_menu-->\r\n");
      out.write("        </header><!--//header-->\r\n");
      out.write("    </div><!--//wrap-->\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write('\r');
      out.write('\n');
response.setCharacterEncoding("utf-8"); 
      out.write("\r\n");
      out.write("    <main>\r\n");
      out.write("        ");
try {
        	String rank = String.valueOf(session.getAttribute("rank"));
			if (rank.equals("0")) { 
      out.write("\r\n");
      out.write("        <div id=\"notice_write_wrap\">\r\n");
      out.write("            <div id=\"title\">\r\n");
      out.write("                공지사항 등록\r\n");
      out.write("            </div><!--//title-->\r\n");
      out.write("	        ");
} else {
	        	response.sendRedirect(request.getContextPath()+ "/source/notice/notice.jsp");
	        }
      out.write("\r\n");
      out.write("            <div id=\"notice_write\">\r\n");
      out.write("                <form method=\"post\" action=\"/exhibition/NoticeServlet\">\r\n");
      out.write("                <input type=\"hidden\" name=\"command\" value=\"notice_write\">\r\n");
      out.write("                    <table>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <th>제목</th>\r\n");
      out.write("                            <td><input type=\"text\" name=\"title\"></td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <th>사진</th>\r\n");
      out.write("                            <td><label for=\"input_img\" id=\"upload\">업로드</label><input type=\"file\" accept=\"image/*\" value=\"not_photo\" id=\"input_img\"></td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <th>내용</th>\r\n");
      out.write("                            <td><input type=\"text\" name=\"discript\"  size=\"50\" id=\"notice_info\"></td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    </table>\r\n");
      out.write("                    <input type=\"submit\" value=\"작성완료\">\r\n");
      out.write("                    <input type=\"reset\" value=\"다시작성\">\r\n");
      out.write("                </form>\r\n");
      out.write("            </div><!--//notice_write-->\r\n");
      out.write("        </div><!--//notice_write_wrap-->\r\n");
      out.write("    ");
} catch (Exception e) {
		response.sendRedirect(request.getContextPath()+ "/source/notice/notice.jsp");
	}
      out.write("\r\n");
      out.write("    </main>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/css/reset.css?ver=1\" rel=\"stlyesheet\">\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/css/footer.css?ver=1\" rel=\"stylesheet\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<footer>\r\n");
      out.write("	            <div id=\"footer_menu\">\r\n");
      out.write("	                <ul>\r\n");
      out.write("	                    <li>기업소개</li>\r\n");
      out.write("	                    <li>이용약관</li>\r\n");
      out.write("	                    <li>전자금융거래약관</li>\r\n");
      out.write("	                    <li>개인정보처리방침</li>\r\n");
      out.write("	                </ul>\r\n");
      out.write("	            </div><!--//footer_menu-->\r\n");
      out.write("	            <div class=\"footer_logo\">\r\n");
      out.write("	            <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/image/exhiplat.png\" width=\"250\" height=\"70\">\r\n");
      out.write("	            </div>\r\n");
      out.write("	            <div id=\"footer_info\">\r\n");
      out.write("	                ㈜ ㅁㅁ(대표자:김남지)<br>\r\n");
      out.write("	                주소 : <br>\r\n");
      out.write("	                사업자등록번호 : <br>\r\n");
      out.write("	                통신판매업신고 : <br>\r\n");
      out.write("	                E-mail : \r\n");
      out.write("	            </div>\r\n");
      out.write("	        </footer><!--//footer-->\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
