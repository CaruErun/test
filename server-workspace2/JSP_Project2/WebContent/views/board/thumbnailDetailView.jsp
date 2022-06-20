<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.board.model.vo.Board" %>
<%
	ArrayList<Board> bList = (ArrayList<Board>)request.getAttribute("bList");

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
</style>
</head>
<body>
<%@include file="/views/common/menubar.jsp"%>
    <div class="outer">
        <br>
        <h2 align="center">사진 게시판 상세보기</h2>
        <br>

        <table id="detail-area" align="center" border="1">
            <tr>
                <th colspan="2">제목</th>
                <td colspan="2"><%=bList.get(0).getBoardTitle() %></td>
            </tr>
            <tr>
                <th>작성자</th>
                <td><%=bList.get(0).getBoardWriter() %></td>
                <th>작성일</th>
                <td><%=bList.get(0).getCreateDate() %></td>
            </tr>
            <tr>
                <th>내용</th>
                <td colspan="3"><%=bList.get(0).getBoardContent() %></td>
            
            </tr>
        </table>
        	<%for(Board b : bList) {%>
        		<div align="center">
        		<img src="<%=contextPath%>/<%=b.getTitleImg()%>" width="200px" height="150px">
        		</div>
        		
        	<%}%>

        <br>

        <div align="center">
            <a onclick = "history.back()">목록으로</a>
           <%if(loginUser!=null && (loginUser.getUserName().equals(bList.get(0).getBoardWriter()) || loginUser.getUserId().equals("admin"))){%>
           <!--로그인한 사용자가 게시글 작성자일 경우-->
            <a href="<%=contextPath%>/updateForm.th?bno=<%=bList.get(0).getBoardNo()%>">수정하기</a>
            <a href="<%=contextPath%>/delete.th?bno=<%=bList.get(0).getBoardNo()%>">삭제하기</a>
            <%}%>
       
        </div>




    </div>
</body>
</html>