<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style>
    .login-area a{
        text-decoration: none;
        color:black;
        font-size: 12pt;
    }
    .nav-area{
        background-color: beige;
        height:50px;
    }
    .menu{
        display:table-cell;
        width:250px;
        height: 50px;
        vertical-align: middle;
        font-size: 15pt;
        font-weight: bold;
    }
    
    .menu:hover{
        background-color: rgba(100,100,100,50%);
        cursor:pointer;
    }

    .outer{
        width:900px;
        background-color: beige;
        margin:auto;
        margin-top: 50px;
    }
    
</style>

</head>
<body>
	<c:if test="${not empty alertMsg }">
		<script>
			alert("${alertMsg}");
		</script>
		<c:remove var="alertMsg"/>
	</c:if>
    <h1 align="center">Mybatis</h1>

    <div class="login-area" align="right">
    <c:choose>
    	<c:when test="${empty loginUser }">
        <form action="login.me">

            <table>
                <tr>
                    <td>ID</td>
                    <td><input type="text" name="userId" required></td>
                    <td rowspan="2"><button type="submit" style="height :  50px;">로그인</button></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="userPwd" required></td>
                    <td></td>
                </tr>
                <tr>
                    <td colspan="3" align="center">
                        <a href="enrollForm.me">회원가입</a> |
                        <a href="#">ID/PW 찾기</a>
                    </td>
                    <td></td>
                    <td></td>
                </tr>
            </table>
        </form>
        	</c:when>
		<c:otherwise>
        <!--로그인 후-->
        <div>
            <table>
                <tr>
                    <td colspan="2" align="center"><h3>${loginUser.userName}님 환영합니다</h3></td>
                    <td></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                    <a href="#">마이페이지</a> |
                    <a href="logout.me">로그아웃</a>
                    </td>
                    
                </tr>
            </table>
        </div>
        </c:otherwise>
		</c:choose>
    </div>

    <br>
    
    <div class="nav-area" align="center">
        <div class="menu">HOME</div>
        <div class="menu">공지사항</div>
        <div class="menu" onclick="location.href='list.bo?cpage=1'">게시판</div>
        <div class="menu">자유</div>
    </div>
</body>
</html>