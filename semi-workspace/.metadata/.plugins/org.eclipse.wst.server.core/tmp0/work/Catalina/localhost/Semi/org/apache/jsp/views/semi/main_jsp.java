/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.78
 * Generated at: 2022-05-26 09:37:33 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.semi;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.kh.member_2.model.vo.MemberUser;
import java.sql.Date;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/views/common/menubar.jsp", Long.valueOf(1653555519332L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.kh.member_2.model.vo.MemberUser");
    _jspx_imports_classes.add("java.sql.Date");
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
      out.write("    ");

    
    
    
    
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0\" />\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0\" />\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/icon?family=Material+Icons\">\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"./resources/css/main.css\">\r\n");
      out.write("\r\n");
      out.write("<!-- jQuery library -->\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<!-- Popper JS -->\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<!-- Latest compiled JavaScript -->\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    ");

    String contextPath = request.getContextPath();
    String alertMsg =(String)session.getAttribute("alertMsg");
	MemberUser loginUser = null;
	int loginN = -1;
	if(session.getAttribute("loginN")!=null) loginN = (int)session.getAttribute("loginN");
	if(session.getAttribute("loginUser")!=null) loginUser= (MemberUser)session.getAttribute("loginUser");
    
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0\" />\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0\" />\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/icon?family=Material+Icons\">\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"/Semi/resources/css/main.css\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- Latest compiled and minified CSS -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css\">\r\n");
      out.write("\r\n");
      out.write("<!-- jQuery library -->\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<!-- Popper JS -->\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<!-- Latest compiled JavaScript -->\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<script>\r\n");
      out.write("		var date=\"\";\r\n");
      out.write("		");
if(session.getAttribute("banDate")!=null){
      out.write("\r\n");
      out.write("			date = '");
      out.print(session.getAttribute("banDate"));
      out.write("';\r\n");
      out.write("		");
}
      out.write("\r\n");
      out.write("		if(");
      out.print(loginN);
      out.write("==0) {\r\n");
      out.write("			window.alert(\"로그인 정보가 일치하지 않습니다\");\r\n");
      out.write("			");
session.setAttribute("loginN", -1);
      out.write("\r\n");
      out.write("		}\r\n");
      out.write("		if(");
      out.print(loginN);
      out.write("==1) {\r\n");
      out.write("			window.alert(\"정상적으로 로그아웃 되었습니다.\");\r\n");
      out.write("			");
session.setAttribute("loginN", -1);
      out.write("\r\n");
      out.write("		}\r\n");
      out.write("		if(");
      out.print(loginN);
      out.write("==2) {\r\n");
      out.write("			if(window.confirm(\"이미 탈퇴한 회원입니다. 탈퇴 취소 처리 하시겠습니까?\")){\r\n");
      out.write("				$.ajax({\r\n");
      out.write("					url : \"/Semi/ajaxReturnMember.lo\",\r\n");
      out.write("					data : {userNo : ");
      out.print((session.getAttribute("userNo")!=null) ? (int)session.getAttribute("userNo") : "-1");
      out.write("},\r\n");
      out.write("					success : function(result){\r\n");
      out.write("						if(result>0) {\r\n");
      out.write("						window.alert(\"정상적으로 탈퇴 취소 처리 되었습니다. 재로그인 해주세요\");\r\n");
      out.write("						window.location.reload(true);\r\n");
      out.write("						}\r\n");
      out.write("					},\r\n");
      out.write("					error : function(){\r\n");
      out.write("						\r\n");
      out.write("					}\r\n");
      out.write("				});				\r\n");
      out.write("			}\r\n");
      out.write("			");
if(session.getAttribute("userNo")!=null) request.getSession().removeAttribute("userNo");
      out.write("\r\n");
      out.write("			");
session.setAttribute("loginN", -1);
      out.write("\r\n");
      out.write("		}\r\n");
      out.write("		if(");
      out.print(loginN);
      out.write("==3) {\r\n");
      out.write("			window.alert(\"회원님은\"+date +\"까지 정지 상태입니다.\");\r\n");
      out.write("			");
session.setAttribute("loginN", -1);
      out.write("\r\n");
      out.write("		}\r\n");
      out.write("		if(");
      out.print(loginN);
      out.write("==4) {\r\n");
      out.write("			if(window.confirm(\"회원님은 현재 휴면 상태입니다. 휴면해제 처리 하시겠습니까? \")){\r\n");
      out.write("				$.ajax({\r\n");
      out.write("					url : \"/Semi/ajaxReturnMember.lo\",\r\n");
      out.write("					data : {userNo : ");
      out.print((session.getAttribute("userNo")!=null) ? (int)session.getAttribute("userNo") : "-1");
      out.write("},\r\n");
      out.write("					success : function(result){\r\n");
      out.write("						if(result>0) {\r\n");
      out.write("						window.alert(\"정상적으로 해제 처리 되었습니다. 재로그인 해주세요\");\r\n");
      out.write("						window.location.reload(true);\r\n");
      out.write("						}\r\n");
      out.write("					},\r\n");
      out.write("					error : function(){\r\n");
      out.write("						\r\n");
      out.write("					}\r\n");
      out.write("				});\r\n");
      out.write("			}\r\n");
      out.write("			");
if(session.getAttribute("userNo")!=null) request.getSession().removeAttribute("userNo");
      out.write("\r\n");
      out.write("			");
session.setAttribute("loginN", -1);
      out.write("\r\n");
      out.write("		}\r\n");
      out.write("		if(");
      out.print(loginN);
      out.write("==5) {\r\n");
      out.write("			window.alert(\"회원님은 영구정지 상태입니다.\");\r\n");
      out.write("			");
session.setAttribute("loginN", -1);
      out.write("\r\n");
      out.write("		}\r\n");
      out.write("		if(");
      out.print(loginN);
      out.write("==10) {\r\n");
      out.write("			window.alert(\"회원가입이 성공적으로 완료되었습니다.\");\r\n");
      out.write("			");
session.setAttribute("loginN", -1);
      out.write("\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		//밴 자동으로 풀림\r\n");
      out.write("		$(document).ready(function(){\r\n");
      out.write("			$.ajax({\r\n");
      out.write("				url : \"/Semi/ajaxBanManage.lo\"\r\n");
      out.write("			});\r\n");
      out.write("		})\r\n");
      out.write("\r\n");
      out.write("	</script>\r\n");
      out.write("	 <!-- HEADER -->\r\n");
      out.write("  <header>\r\n");
      out.write("    <div class=\"inner\">\r\n");
      out.write("\r\n");
      out.write("    <a href=\"");
      out.print(contextPath );
      out.write("/\" class=\"logo\"><img src=\"");
      out.print(contextPath );
      out.write("/resources/img/DsSports.png\" alt=\"DS SPORTS\"></a>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <!-- top navi -->\r\n");
      out.write("    ");
if(loginUser==null) {
      out.write("\r\n");
      out.write("    <div class=\"top-navi\">\r\n");
      out.write("      <ul class=\"navi\">\r\n");
      out.write("        <li><a href=\"/Semi/views/common/login.jsp\">로그인</a></li>\r\n");
      out.write("        <li><a href=\"/Semi/views/semi/newMember.jsp\">회원가입</a></li>\r\n");
      out.write("        <li><a href=\"#\">마이페이지</a></li>\r\n");
      out.write("        <li><a href=\"#\">고객센터</a></li>\r\n");
      out.write("      </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("    ");
} else {
      out.write("\r\n");
      out.write("        <div class=\"top-navi\">\r\n");
      out.write("      <ul class=\"navi\">\r\n");
      out.write("        <li>");
      out.print(loginUser.getUserName() );
      out.write(" 님 환영합니다</li>\r\n");
      out.write("        <li><a href=\"/Semi/loginUser.lo?logout=1\">로그아웃</a></li>\r\n");
      out.write("        <li><a href=\"#\">마이페이지</a></li>\r\n");
      out.write("        <li><a href=\"#\">고객센터</a></li>\r\n");
      out.write("      </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("    ");
}
      out.write("\r\n");
      out.write("    <!-- input -->\r\n");
      out.write("    <div class=\"search\">\r\n");
      out.write("      <input type=\"text\" placeholder=\"검색\" style=\"font-size: 20px;\">\r\n");
      out.write("      <div class=\"material-icons\">search</div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- order -->\r\n");
      out.write("    <div class=\"order\">\r\n");
      out.write("      <div id=\"order\">\r\n");
      out.write("        <a href=\"#\">\r\n");
      out.write("          <div class=\"material-symbols-outlined\">\r\n");
      out.write("          shopping_cart\r\n");
      out.write("          </div>\r\n");
      out.write("        </a>\r\n");
      out.write("      </div>\r\n");
      out.write("    <div id=\"favor\">\r\n");
      out.write("      <a href=\"#\">\r\n");
      out.write("        <div  class=\"material-symbols-outlined\">\r\n");
      out.write("          favorite\r\n");
      out.write("        </div>\r\n");
      out.write("      </a>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("      </header>\r\n");
      out.write("      <!-- navigator -->\r\n");
      out.write("      <div class=\"navigator\">\r\n");
      out.write("        <ul id=\"navi\">\r\n");
      out.write("          <li><a href=\"");
      out.print(contextPath );
      out.write("/views/semi/categoryPage.jsp\">축구</a>\r\n");
      out.write("            <ul>\r\n");
      out.write("                <li><a href=\"");
      out.print(contextPath );
      out.write("/views/semi/categoryPage.jsp\">축구공</a></li>\r\n");
      out.write("                <li><a href=\"");
      out.print(contextPath );
      out.write("/views/semi/categoryPage.jsp\">축구화</a></li>\r\n");
      out.write("                <li><a href=\"");
      out.print(contextPath );
      out.write("/views/semi/categoryPage.jsp\">보호장비</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("          </li>\r\n");
      out.write("          <li><a href=\"");
      out.print(contextPath );
      out.write("/views/semi/categoryPage.jsp\">볼링</a>\r\n");
      out.write("            <ul>\r\n");
      out.write("                <li><a href=\"");
      out.print(contextPath );
      out.write("/views/semi/categoryPage.jsp\">볼링공</a></li>\r\n");
      out.write("                <li><a href=\"");
      out.print(contextPath );
      out.write("/views/semi/categoryPage.jsp\">볼링화</a></li>\r\n");
      out.write("                <li><a href=\"");
      out.print(contextPath );
      out.write("/views/semi/categoryPage.jsp\">보호장비</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("          </li>\r\n");
      out.write("          <li><a href=\"");
      out.print(contextPath );
      out.write("/views/semi/categoryPage.jsp\">헬스</a>\r\n");
      out.write("            <ul>\r\n");
      out.write("                <li><a href=\"");
      out.print(contextPath );
      out.write("/views/semi/categoryPage.jsp\">스트랩</a></li>\r\n");
      out.write("                <li><a href=\"");
      out.print(contextPath );
      out.write("/views/semi/categoryPage.jsp\">리프팅벨트</a></li>\r\n");
      out.write("                <li><a href=\"");
      out.print(contextPath );
      out.write("/views/semi/categoryPage.jsp\">보호대</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("          </li>\r\n");
      out.write("          <li><a href=\"");
      out.print(contextPath );
      out.write("/views/semi/categoryPage.jsp\">자전거</a>\r\n");
      out.write("            <ul>\r\n");
      out.write("                <li><a href=\"");
      out.print(contextPath );
      out.write("/views/semi/categoryPage.jsp\">자전거</a></li>\r\n");
      out.write("                <li><a href=\"");
      out.print(contextPath );
      out.write("/views/semi/categoryPage.jsp\">LED전등</a></li>\r\n");
      out.write("                <li><a href=\"");
      out.print(contextPath );
      out.write("/views/semi/categoryPage.jsp\">보호장비</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("          </li>\r\n");
      out.write("          <li><a href=\"#\">할인판매</a>\r\n");
      out.write("          </li>\r\n");
      out.write("          <li><a href=\"#\">동네헬스장공유</a>\r\n");
      out.write("          </li>\r\n");
      out.write("          \r\n");
      out.write("        </ul>\r\n");
      out.write("      </div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("      <!-- 인기상품 + 공지 영역-->\r\n");
      out.write("      <div class=\"middle\">\r\n");
      out.write("        <!-- 인기상품 -->\r\n");
      out.write("        <div id=\"pop-pr\">\r\n");
      out.write("        <img src=\"https://i.ytimg.com/vi/lY3__IHES6A/maxresdefault.jpg\" alt=\"pop-pr\">\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- 공지사항 -->\r\n");
      out.write("        <div id=\"notice\">공지사항\r\n");
      out.write("            <div id=\"content\">\r\n");
      out.write("              <li><a href=\"./notice.html\">공지제목1</a></li>\r\n");
      out.write("              <li><a href=\"./notice.html\">공지제목2</a></li>\r\n");
      out.write("              <li><a href=\"./notice.html\">공지제목3</a></li>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("      <!-- 인기상품 + 공지 영역 여기까지-->\r\n");
      out.write("      <!-- 인기 헬스장-->\r\n");
      out.write("      <div class=\"pop-gym\">\r\n");
      out.write("        <div id=\"gym1\">\r\n");
      out.write("          <img src=\"https://www.hsuco.or.kr/sports/File/Download/79b8474ed11e47c9c7bc3b6b3e7af76d\" alt=\"gym1\">\r\n");
      out.write("          <textarea name=\"gym1-text\" id=\"gym1-text\" cols=\"30\" rows=\"10\"></textarea>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"gym2\">\r\n");
      out.write("          <img src=\"https://www.ddc.go.kr/site/ddc/images/contents/cnt_1833_img02.jpg\" alt=\"gym2\">\r\n");
      out.write("          <textarea name=\"gym1-text\" id=\"gym1-text\" cols=\"30\" rows=\"10\"></textarea>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"gym3\">\r\n");
      out.write("          <img src=\"https://www.yong-san.or.kr/sc/upload/photo/f98e7cb4d5d66ead5eba02fd5abe28d8.jpg\" alt=\"gym3\">\r\n");
      out.write("          <textarea name=\"gym1-text\" id=\"gym1-text\" cols=\"30\" rows=\"10\"></textarea>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("      <!-- 인기 헬스장 여기까지-->\r\n");
      out.write("      <div id=\"footer\">\r\n");
      out.write("        <div id=\"footer_1\">\r\n");
      out.write("            <a href=\"#\">이용약관</a> |\r\n");
      out.write("            <a href=\"#\">개인정보취급방침</a> |\r\n");
      out.write("            <a href=\"#\">인재채용</a> |\r\n");
      out.write("            <a href=\"#\">고객센터</a>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"footer_2\">\r\n");
      out.write("            <p id=\"p1\">\r\n");
      out.write("                강남지원 1관 : 서울특별시 강남구 테헤란로14길 6 남도빌딩 2F, 3F, 4F, 5F, 6F <br>\r\n");
      out.write("                강남지원 2관 : 서울특별시 강남구 테헤란로10길 9 그랑프리 빌딩 4F, 5F, 7F <br>\r\n");
      out.write("                강남지원 3관 : 서울특별시 강남구 테헤란로 130 호산빌딩 5F, 6F <br>\r\n");
      out.write("                종로지원 : 서울특별시 중구 남대문로 120 대일빌딩 2F, 3F <br>\r\n");
      out.write("                당산지원 : 서울특별시 영등포구 선유동2로 57 이레빌딩 (구관) 19F, 20F <br>\r\n");
      out.write("            </p>\r\n");
      out.write("            <p id=\"p2\">Copyright © 1998-2022 KH Information Educational Institute All Right Reserved</p>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
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