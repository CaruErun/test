/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.78
 * Generated at: 2022-05-18 08:52:39 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/views/common/adminMenubar.jsp", Long.valueOf(1652593772000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
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

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
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
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	");
      out.write("\r\n");
      out.write("    \r\n");

	String contextPath = request.getContextPath();

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>index</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/Semi/views/admin-css/admin_style_header.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/Semi/views/admin-css/admin_style_content.css\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<h2>관리자 시작</h2>\r\n");
      out.write("    <!--header 시작-->\r\n");
      out.write("        <div id=\"header\">\r\n");
      out.write("            <img src=\"/Semi/views/image/DsSports.png\">\r\n");
      out.write("        </div>\r\n");
      out.write("    <!--header 끝-->\r\n");
      out.write("\r\n");
      out.write("    <!--왼쪽 메뉴 바 시작(content_1)-->\r\n");
      out.write("            <div id=\"content_1\">\r\n");
      out.write("                <div id=\"content_1_empty\"></div>\r\n");
      out.write("                <table>\r\n");
      out.write("                    <tr class=\"PM\">\r\n");
      out.write("                        <td class=\"left-menu\"><a href=\"#\">상품관리</a></td>\r\n");
      out.write("                        <td><img src=\"/Semi/views/image/down_triangle.png\" class=\"triangle\"></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr class=\"PM\">\r\n");
      out.write("                        <td colspan=\"2\" class=\"sub-menu\"><a href=\"/Semi/views/admin/a_1.jsp\">등록</a></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr class=\"PM\">\r\n");
      out.write("                        <td colspan=\"2\" class=\"sub-menu\"><a href=\"/Semi/views/admin/a_2.jsp\">수정</a></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr class=\"PM\">\r\n");
      out.write("                        <td colspan=\"2\" class=\"sub-menu\"><a href=\"/Semi/views/admin/a_3.jsp\">카테고리수정</a></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("                    <tr class=\"SM\"> \r\n");
      out.write("                        <td class=\"left-menu\"><a href=\"#\">쇼핑몰 관리</a></td>\r\n");
      out.write("                        <td><img src=\"/Semi/views/image/down_triangle.png\" class=\"triangle\"></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr class=\"SM\">\r\n");
      out.write("                        <td colspan=\"2\" class=\"sub-menu\"><a href=\"/Semi/views/admin/b_1.jsp\">주문내역 관리</a></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr class=\"SM\">\r\n");
      out.write("                        <td colspan=\"2\" class=\"sub-menu\"><a href=\"/Semi/views/admin/b_2.jsp\">공지사항 관리</a></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr class=\"SM\">\r\n");
      out.write("                        <td colspan=\"2\" class=\"sub-menu\"><a href=\"/Semi/views/admin/b_3.jsp\">리뷰 관리</a></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("                    <tr class=\"CM\">\r\n");
      out.write("                        <td class=\"left-menu\"><a href=\"/Semi/views/admin/c_1.jsp\">회원관리</a></td>\r\n");
      out.write("                        <td><img src=\"/Semi/views/image/down_triangle.png\" class=\"triangle\"></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr class=\"CM\">\r\n");
      out.write("                        <td colspan=\"2\" class=\"sub-menu\"><a href=\"/Semi/views/admin/c_1.jsp\">회원 관리</a></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr class=\"CM\">\r\n");
      out.write("                        <td colspan=\"2\" class=\"sub-menu\"><a href=\"/Semi/views/admin/c_2.jsp\">신고 내역</a></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("                    <tr class=\"Service\">\r\n");
      out.write("                        <td class=\"left-menu\"><a href=\"/Semi/views/admin/d_1.jsp\">고객센터</a></td>\r\n");
      out.write("                        <td><img src=\"/Semi/views/image/down_triangle.png\" class=\"triangle\"></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr class=\"Service\">\r\n");
      out.write("                        <td colspan=\"2\" class=\"sub-menu\"><a href=\"/Semi/views/admin/d_1.jsp\">FAQ 관리</a></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr class=\"Service\">\r\n");
      out.write("                        <td colspan=\"2\" class=\"sub-menu\"><a href=\"/Semi/views/admin/d_2.jsp\">1:1문의</a></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </table>\r\n");
      out.write("            </div>\r\n");
      out.write("        <!--왼쪽 메뉴 바(content_1) 끝-->\r\n");
      out.write("    <script>\r\n");
      out.write("        //menubar 변경으로 인한 왼쪽 메뉴바 변경\r\n");
      out.write("        window.onload=function(){\r\n");
      out.write("            if(window.location.href.search(\"a_1.jsp\")!=-1){\r\n");
      out.write("                var setClass = document.getElementsByClassName('PM');\r\n");
      out.write("                for(var i=1;i<setClass.length;i++){\r\n");
      out.write("                        setClass[i].childNodes[1].childNodes[0].style.display='block';\r\n");
      out.write("                    }\r\n");
      out.write("                setClass[0].childNodes[3].childNodes[0].setAttribute(\"src\",\"/Semi/views/image/triangle.png\");\r\n");
      out.write("                setClass[0].childNodes[1].childNodes[0].style.color=\"yellow\";\r\n");
      out.write("                setClass[1].childNodes[1].childNodes[0].style.color=\"yellow\";\r\n");
      out.write("            }\r\n");
      out.write("            if(window.location.href.search(\"a_2.jsp\")!=-1){\r\n");
      out.write("                var setClass = document.getElementsByClassName('PM');\r\n");
      out.write("                for(var i=1;i<setClass.length;i++){\r\n");
      out.write("                        setClass[i].childNodes[1].childNodes[0].style.display='block';\r\n");
      out.write("                    }\r\n");
      out.write("                setClass[0].childNodes[3].childNodes[0].setAttribute(\"src\",\"/Semi/views/image/triangle.png\");\r\n");
      out.write("                setClass[0].childNodes[1].childNodes[0].style.color=\"yellow\";\r\n");
      out.write("                setClass[2].childNodes[1].childNodes[0].style.color=\"yellow\";\r\n");
      out.write("            }\r\n");
      out.write("            if(window.location.href.search(\"a_3.jsp\")!=-1){\r\n");
      out.write("                var setClass = document.getElementsByClassName('PM');\r\n");
      out.write("                for(var i=1;i<setClass.length;i++){\r\n");
      out.write("                        setClass[i].childNodes[1].childNodes[0].style.display='block';\r\n");
      out.write("                    }\r\n");
      out.write("                setClass[0].childNodes[3].childNodes[0].setAttribute(\"src\",\"/Semi/views/image/triangle.png\");\r\n");
      out.write("                setClass[0].childNodes[1].childNodes[0].style.color=\"yellow\";\r\n");
      out.write("                setClass[3].childNodes[1].childNodes[0].style.color=\"yellow\";\r\n");
      out.write("            }\r\n");
      out.write("            if(window.location.href.search(\"b_1.jsp\")!=-1){\r\n");
      out.write("                var setClass = document.getElementsByClassName('SM');\r\n");
      out.write("                for(var i=1;i<setClass.length;i++){\r\n");
      out.write("                        setClass[i].childNodes[1].childNodes[0].style.display='block';\r\n");
      out.write("                    }\r\n");
      out.write("                setClass[0].childNodes[3].childNodes[0].setAttribute(\"src\",\"/Semi/views/image/triangle.png\");\r\n");
      out.write("                setClass[0].childNodes[1].childNodes[0].style.color=\"yellow\";\r\n");
      out.write("                setClass[1].childNodes[1].childNodes[0].style.color=\"yellow\";\r\n");
      out.write("            }\r\n");
      out.write("            if(window.location.href.search(\"b_2.jsp\")!=-1){\r\n");
      out.write("                var setClass = document.getElementsByClassName('SM');\r\n");
      out.write("                for(var i=1;i<setClass.length;i++){\r\n");
      out.write("                        setClass[i].childNodes[1].childNodes[0].style.display='block';\r\n");
      out.write("                    }\r\n");
      out.write("                setClass[0].childNodes[3].childNodes[0].setAttribute(\"src\",\"/Semi/views/image/triangle.png\");\r\n");
      out.write("                setClass[0].childNodes[1].childNodes[0].style.color=\"yellow\";\r\n");
      out.write("                setClass[2].childNodes[1].childNodes[0].style.color=\"yellow\";\r\n");
      out.write("            }\r\n");
      out.write("            if(window.location.href.search(\"b_3.jsp\")!=-1){\r\n");
      out.write("                var setClass = document.getElementsByClassName('SM');\r\n");
      out.write("                for(var i=1;i<setClass.length;i++){\r\n");
      out.write("                        setClass[i].childNodes[1].childNodes[0].style.display='block';\r\n");
      out.write("                    }\r\n");
      out.write("                setClass[0].childNodes[3].childNodes[0].setAttribute(\"src\",\"/Semi/views/image/triangle.png\");\r\n");
      out.write("                setClass[0].childNodes[1].childNodes[0].style.color=\"yellow\";\r\n");
      out.write("                setClass[3].childNodes[1].childNodes[0].style.color=\"yellow\";\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("            if(window.location.href.search(\"c_1.jsp\")!=-1){\r\n");
      out.write("                var setClass = document.getElementsByClassName('CM');\r\n");
      out.write("                for(var i=1;i<setClass.length;i++){\r\n");
      out.write("                        setClass[i].childNodes[1].childNodes[0].style.display='block';\r\n");
      out.write("                    }\r\n");
      out.write("                setClass[0].childNodes[3].childNodes[0].setAttribute(\"src\",\"/Semi/views/image/triangle.png\");\r\n");
      out.write("                setClass[0].childNodes[1].childNodes[0].style.color=\"yellow\";\r\n");
      out.write("                setClass[1].childNodes[1].childNodes[0].style.color=\"yellow\";\r\n");
      out.write("            }\r\n");
      out.write("            if(window.location.href.search(\"c_2.jsp\")!=-1){\r\n");
      out.write("                var setClass = document.getElementsByClassName('CM');\r\n");
      out.write("                for(var i=1;i<setClass.length;i++){\r\n");
      out.write("                        setClass[i].childNodes[1].childNodes[0].style.display='block';\r\n");
      out.write("                    }\r\n");
      out.write("                setClass[0].childNodes[3].childNodes[0].setAttribute(\"src\",\"/Semi/views/image/triangle.png\");\r\n");
      out.write("                setClass[0].childNodes[1].childNodes[0].style.color=\"yellow\";\r\n");
      out.write("                setClass[2].childNodes[1].childNodes[0].style.color=\"yellow\";\r\n");
      out.write("            }\r\n");
      out.write("            if(window.location.href.search(\"d_1.jsp\")!=-1){\r\n");
      out.write("                var setClass = document.getElementsByClassName('Service');\r\n");
      out.write("                for(var i=1;i<setClass.length;i++){\r\n");
      out.write("                        setClass[i].childNodes[1].childNodes[0].style.display='block';\r\n");
      out.write("                    }\r\n");
      out.write("                setClass[0].childNodes[3].childNodes[0].setAttribute(\"src\",\"/Semi/views/image/triangle.png\");\r\n");
      out.write("                setClass[0].childNodes[1].childNodes[0].style.color=\"yellow\";\r\n");
      out.write("                setClass[1].childNodes[1].childNodes[0].style.color=\"yellow\";\r\n");
      out.write("            }\r\n");
      out.write("            if(window.location.href.search(\"d_2.jsp\")!=-1){\r\n");
      out.write("                var setClass = document.getElementsByClassName('Service');\r\n");
      out.write("                for(var i=1;i<setClass.length;i++){\r\n");
      out.write("                        setClass[i].childNodes[1].childNodes[0].style.display='block';\r\n");
      out.write("                    }\r\n");
      out.write("                setClass[0].childNodes[3].childNodes[0].setAttribute(\"src\",\"/Semi/views/image/triangle.png\");\r\n");
      out.write("                setClass[0].childNodes[1].childNodes[0].style.color=\"yellow\";\r\n");
      out.write("                setClass[2].childNodes[1].childNodes[0].style.color=\"yellow\";\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("        }//변경 종료\r\n");
      out.write("\r\n");
      out.write("        //삼각형 변경 스크립트\r\n");
      out.write("        var triangles=document.getElementsByClassName(\"triangle\");\r\n");
      out.write("        function tri_click(idx){\r\n");
      out.write("            triangles[idx].onclick =function() {\r\n");
      out.write("\r\n");
      out.write("                if(this.getAttribute(\"src\").search(\"down\")!=-1){\r\n");
      out.write("                    var className =triangles[idx].parentNode.parentNode.getAttribute('class');\r\n");
      out.write("                    var setClass = document.getElementsByClassName(className);\r\n");
      out.write("                    for(var x=1;x<setClass.length;x++){\r\n");
      out.write("                        setClass[x].childNodes[1].childNodes[0].style.display='block';\r\n");
      out.write("                    }\r\n");
      out.write("                    this.setAttribute(\"src\",\"/Semi/views/image/triangle.png\");\r\n");
      out.write("                }else{\r\n");
      out.write("                    var className =triangles[idx].parentNode.parentNode.getAttribute('class');\r\n");
      out.write("                    var setClass = document.getElementsByClassName(className);\r\n");
      out.write("                    for(var x=1;x<setClass.length;x++){\r\n");
      out.write("                        setClass[x].childNodes[1].childNodes[0].style.display='none';\r\n");
      out.write("                    }\r\n");
      out.write("                    this.setAttribute(\"src\",\"/Semi/views/image/down_triangle.png\");\r\n");
      out.write("                }\r\n");
      out.write("            };\r\n");
      out.write("        }\r\n");
      out.write("        for(var i=0;i<triangles.length;i++){\r\n");
      out.write("            tri_click(i);\r\n");
      out.write("        }\r\n");
      out.write("		//JS에서는 기존 반복문 방식으로는 해당 방번호를 반환 받을 수 없음\r\n");
      out.write("        //클로저 기법 [idx]을 이용하여 해당 배열 값을 정상적으로 반환\r\n");
      out.write("\r\n");
      out.write("    </script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("	\r\n");
      out.write("</body>\r\n");
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
