<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.member_2.model.vo.MemberUser,java.sql.Date" %>
    <%
    String contextPath = request.getContextPath();
    String alertMsg =(String)session.getAttribute("alertMsg");
	MemberUser loginUser = null;
	int loginN = -1;
	if(session.getAttribute("loginN")!=null) loginN = (int)session.getAttribute("loginN");
	if(session.getAttribute("loginUser")!=null) loginUser= (MemberUser)session.getAttribute("loginUser");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <link rel="stylesheet" href="/Semi/resources/css/main.css">


<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<script>
		var date="";
		<%if(session.getAttribute("banDate")!=null){%>
			date = '<%=session.getAttribute("banDate")%>';
		<%}%>
		if(<%=loginN%>==0) {
			window.alert("로그인 정보가 일치하지 않습니다");
			<%session.setAttribute("loginN", -1);%>
		}
		if(<%=loginN%>==1) {
			window.alert("정상적으로 로그아웃 되었습니다.");
			<%session.setAttribute("loginN", -1);%>
		}
		if(<%=loginN%>==2) {
			if(window.confirm("이미 탈퇴한 회원입니다. 탈퇴 취소 처리 하시겠습니까?")){
				$.ajax({
					url : "/Semi/ajaxReturnMember.lo",
					data : {userNo : <%=(session.getAttribute("userNo")!=null) ? (int)session.getAttribute("userNo") : "-1"%>},
					success : function(result){
						if(result>0) {
						window.alert("정상적으로 탈퇴 취소 처리 되었습니다. 재로그인 해주세요");
						window.location.reload(true);
						}
					},
					error : function(){
						
					}
				});				
			}
			<%if(session.getAttribute("userNo")!=null) request.getSession().removeAttribute("userNo");%>
			<%session.setAttribute("loginN", -1);%>
		}
		if(<%=loginN%>==3) {
			window.alert("회원님은"+date +"까지 정지 상태입니다.");
			<%session.setAttribute("loginN", -1);%>
		}
		if(<%=loginN%>==4) {
			if(window.confirm("회원님은 현재 휴면 상태입니다. 휴면해제 처리 하시겠습니까? ")){
				$.ajax({
					url : "/Semi/ajaxReturnMember.lo",
					data : {userNo : <%=(session.getAttribute("userNo")!=null) ? (int)session.getAttribute("userNo") : "-1"%>},
					success : function(result){
						if(result>0) {
						window.alert("정상적으로 해제 처리 되었습니다. 재로그인 해주세요");
						window.location.reload(true);
						}
					},
					error : function(){
						
					}
				});
			}
			<%if(session.getAttribute("userNo")!=null) request.getSession().removeAttribute("userNo");%>
			<%session.setAttribute("loginN", -1);%>
		}
		if(<%=loginN%>==5) {
			window.alert("회원님은 영구정지 상태입니다.");
			<%session.setAttribute("loginN", -1);%>
		}
		if(<%=loginN%>==10) {
			window.alert("회원가입이 성공적으로 완료되었습니다.");
			<%session.setAttribute("loginN", -1);%>
		}
		
		//밴 자동으로 풀림
		$(document).ready(function(){
			$.ajax({
				url : "/Semi/ajaxBanManage.lo"
			});
		})

	</script>
	 <!-- HEADER -->
  <header>
    <div class="inner">

    <a href="<%=contextPath %>/" class="logo"><img src="<%=contextPath %>/resources/img/DsSports.png" alt="DS SPORTS"></a>
    </div>

    <!-- top navi -->
    <%if(loginUser==null) {%>
    <div class="top-navi">
      <ul class="navi">
        <li><a href="/Semi/views/common/login.jsp">로그인</a></li>
        <li><a href="/Semi/views/semi/newMember.jsp">회원가입</a></li>
        <li><a href="#">마이페이지</a></li>
        <li><a href="#">고객센터</a></li>
      </ul>
    </div>
    <%} else {%>
        <div class="top-navi">
      <ul class="navi">
        <li><%=loginUser.getUserName() %> 님 환영합니다</li>
        <li><a href="/Semi/loginUser.lo?logout=1">로그아웃</a></li>
        <li><a href="#">마이페이지</a></li>
        <li><a href="#">고객센터</a></li>
      </ul>
    </div>
    <%}%>
    <!-- input -->
    <div class="search">
      <input type="text" placeholder="검색" style="font-size: 20px;">
      <div class="material-icons">search</div>
    </div>
    <!-- order -->
    <div class="order">
      <div id="order">
        <a href="#">
          <div class="material-symbols-outlined">
          shopping_cart
          </div>
        </a>
      </div>
    <div id="favor">
      <a href="#">
        <div  class="material-symbols-outlined">
          favorite
        </div>
      </a>
    </div>
  </div>
      </header>
      <!-- navigator -->
      <div class="navigator">
        <ul id="navi">
          <li><a href="<%=contextPath %>/views/semi/categoryPage.jsp">축구</a>
            <ul>
                <li><a href="<%=contextPath %>/views/semi/categoryPage.jsp">축구공</a></li>
                <li><a href="<%=contextPath %>/views/semi/categoryPage.jsp">축구화</a></li>
                <li><a href="<%=contextPath %>/views/semi/categoryPage.jsp">보호장비</a></li>
            </ul>
          </li>
          <li><a href="<%=contextPath %>/views/semi/categoryPage.jsp">볼링</a>
            <ul>
                <li><a href="<%=contextPath %>/views/semi/categoryPage.jsp">볼링공</a></li>
                <li><a href="<%=contextPath %>/views/semi/categoryPage.jsp">볼링화</a></li>
                <li><a href="<%=contextPath %>/views/semi/categoryPage.jsp">보호장비</a></li>
            </ul>
          </li>
          <li><a href="<%=contextPath %>/views/semi/categoryPage.jsp">헬스</a>
            <ul>
                <li><a href="<%=contextPath %>/views/semi/categoryPage.jsp">스트랩</a></li>
                <li><a href="<%=contextPath %>/views/semi/categoryPage.jsp">리프팅벨트</a></li>
                <li><a href="<%=contextPath %>/views/semi/categoryPage.jsp">보호대</a></li>
            </ul>
          </li>
          <li><a href="<%=contextPath %>/views/semi/categoryPage.jsp">자전거</a>
            <ul>
                <li><a href="<%=contextPath %>/views/semi/categoryPage.jsp">자전거</a></li>
                <li><a href="<%=contextPath %>/views/semi/categoryPage.jsp">LED전등</a></li>
                <li><a href="<%=contextPath %>/views/semi/categoryPage.jsp">보호장비</a></li>
            </ul>
          </li>
          <li><a href="#">할인판매</a>
          </li>
          <li><a href="#">동네헬스장공유</a>
          </li>
          
        </ul>
      </div>
</body>
</html>