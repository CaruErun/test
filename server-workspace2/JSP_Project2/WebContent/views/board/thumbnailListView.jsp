<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList, com.kh.board.model.vo.Board" %>
<%
	ArrayList<Board> aList = (ArrayList<Board>)request.getAttribute("aList");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.outer{
    background-color: bisque;
    color: darkgoldenrod;
    width: 1000px;
    margin: auto;
    margin-top: 50px;
    height: 600px;
}
.list-area{
    width:900px;
    margin :auto;
    text-align: center;
}
.tumbnail{
    display:inline-block;
    width:200px;
    margin:10px;
    border:1px solid black;
}
.tumbnail:hover{
    cursor:pointer;
    opacity: 0.5;
}
</style>
</head>
<body>
    <%@ include file="/views/common/menubar.jsp"%>

    <div class="outer">
        <br>
        <h2 align="center">사진게시판</h2>
        <br>
        <%if(loginUser!=null){%>
        <div align="right">
        <a href="<%=contextPath%>/enrollForm.th" class="btn btn-dark">글작성</a>
        </div>
        <%}%>
        <div class="list-area">
        <%for(Board a : aList) {%>
            <div class="tumbnail" align="center" onclick="location.href='<%=contextPath%>/detail.th?bno=<%=a.getBoardNo()%>'">
                <img src="<%=contextPath%>/<%=a.getTitleImg()%>" alt="" width="200px" height="150px">
                <p>
                	제목 <%=a.getBoardTitle() %> <br>
                  	Board No. <%=a.getBoardNo() %><br>
                  	조회 수 : <%=a.getCount() %>
                </p>
            </div>
        <%}%>

            

        </div>

    </div>
</body>
</html>