<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.common.PageInfo,java.util.ArrayList,com.kh.board.model.vo.Board" %>
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");   
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
	
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
	int boardLimit = pi.getBoardLimit();
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .outer{

        width:800px;
        background-color:rgba(253, 201, 201, 0.836);
        margin:auto;
        margin-top:10px;
        box-sizing: border-box;
    }
    .list-area{
        border:1px solid black;
        text-align: center;
    }
</style>
</head>
<body>
    <%@ include file="/views/common/menubar.jsp"%>

    <div class="outer">
        <br>
        <h2 align="center">일반 게시판</h2>

        <table align="center" class="list-area">
            <thead>
                <tr>
                    <th width="70">글번호</th>
                    <th width="70">카테고리</th>
                    <th width="300">제목</th>
                    <th width="100">작성자</th>
                    <th width="50">조회수</th>
                    <th width="100">작성일</th>
                </tr>
            </thead>
            <tbody>
            
            	<%if(list.isEmpty()) {%>
            		<tr>
            			<td>조회된 게시글 없음</td>
            		</tr>
            	<%}else{%>
            		<%for(Board b : list) {%>
                <tr onclick="location.href ='<%=contextPath%>/detail.bo?bno=<%=b.getBoardNo()%>'">
                    <td><%=b.getBoardNo() %></td>
                    <td><%=b.getCategoryNo() %></td>
                    <td><%=b.getBoardTitle() %></td>
                    <td><%=b.getBoardWriter() %></td>
                    <td><%=b.getCount() %></td>
                    <td><%=b.getCreateDate() %></td>
                </tr>
                	<%}%>
                <%}%>
            </tbody>
        </table>


        <br>
        <%if(loginUser!=null){%>
        <div align="center">
            <a href="<%=contextPath%>/enrollForm.bo" class="btn btn-dark">글쓰기</a>
            
        </div>
        <%}%>
        <br>
        <div class="paging-area" align="center">
        <%if(startPage!=1) {%>
        <button onclick="location.href='<%=contextPath%>/list.bo?cpage=<%=startPage-boardLimit%>'">이전</button>
        <%}%>    
            <%for(int i=startPage;i<=endPage;i++) {%>
            	<button onclick="location.href='<%=contextPath%>/list.bo?cpage=<%=i %>'"><%=i %></button>
            <%}%>
        <%if(endPage!=maxPage) {%>
        <button onclick="location.href='<%=contextPath%>/list.bo?cpage=<%=endPage+1%>'">다음</button>
		<%} %>

        </div>
        
    </div>
</body>
</html>