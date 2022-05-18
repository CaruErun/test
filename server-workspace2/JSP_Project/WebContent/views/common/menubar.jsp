<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.member.model.vo.Member"%>

<%
	Member loginUser = (Member)session.getAttribute("loginUser");
	String contextPath = request.getContextPath();
	//loginUser null일 시 로그인 전
	//loginUser null 아닐 시 로그인 상태
	
	String alertMsg = (String)session.getAttribute("alertMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>

<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style>
    .nav-area{
        background-color: beige;
    }
    .menu{
        display:inline-block;
        height:50px;
        width:150px;
    }
    .menu a{
        text-decoration: none;
        color : black;
        font-weight: bold;
        font-size:20px;
        display:block;
        width:100%;
        height:100%;
        line-height: 50px;
    }
    .menu a:hover{
        background-color:lightgreen;
    }
    #login-form{
        float:left;
    }
    #user-info{
        float:right;
    }
</style>
</head>
<body>
	<script>
		var msg = "<%=alertMsg%>";
		if(msg!="null"){
			alert(msg);
			<%session.removeAttribute("alertMsg");%>
		}
	</script>
    <h1 align="center">본격 게시판</h1>
    <div class="login-area">
    <%if(loginUser==null) {%>
        <!--로그인 전에 보여지는 로그인 form-->
        <form action="<%=contextPath %>/login.me" method="post" id="login-form">
            <table>
                <tr>
                    <th>아이디</th>
                    <td><input type="text" name="userId" required></td>
                </tr>
                <tr>
                    <th>비밀번호</th>
                    <td><input type="password" name="userPwd" required></td>
                </tr>
                <tr>
                    <th>
                        <button type="submit">로그인</button>
                        <button type="button" onclick="enrollPage();">회원가입</button>
                    </th>
                </tr>
            </table>
        </form>

        <script>
            function enrollPage() {
                <%-- location.href="<%=contextPath%>/views/member/MemberEnrollForm.jsp" --%>
            	<%--url 디렉토리 구조가 노출되면 보안상 위험--%>
            	<%--정적페이지 이동도 servlet을 거쳐 url 매핑값만--%>
            	location.href = "<%=contextPath%>/enrollForm.me";
            } 

        </script>


        <%}else{%>
        <!-- 로그인 성공 후 보여질 화면 -->
        	<div id="user-info">
        		<b><%=loginUser.getUserName()%> 환 영 합 니 다</b> <br><br>
        		<a href="<%=contextPath %>/myPage.me">마이페이지</a>
        		<a href="<%=contextPath %>/logout.me">로그아웃</a>
        	
        	
        	</div>
        
        
        <%} %>	
    </div>

    <br>
    <br clear="both"> <!--float해제-->
    <div class="nav-area" align="center">

        <div class="menu"><a href="/JSP">HOME</a></div>
        <div class="menu"><a href="<%=contextPath%>/list.no">공지사항</a></div>
        <div class="menu"><a href="<%=contextPath%>/list.bo?cpage=1">일반게시판</a></div>
        <div class="menu"><a href="<%=contextPath%>/list.th">사진게시판</a></div>
    </div>
</body>
</html>