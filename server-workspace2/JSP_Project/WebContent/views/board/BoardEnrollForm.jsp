<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.board.model.vo.Category,java.util.*" %>
<%
	ArrayList<Category> list = (ArrayList<Category>)request.getAttribute("list");

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
#enroll-form>table{border:1px solid darkcyan}
#enroll-form input,textarea{
    width:100%;
    box-sizing: border-box;
}
</style>
</head>
<body>
    <%@ include file="/views/common/menubar.jsp"%>

    <div class="outer">
        <br>
        <h2 align="center">일반 게시글 작성</h2>
        <form action="<%=contextPath%>/insert.bo" method="post" id="enroll-form" enctype="multipart/form-data">
            <input type="hidden" name="userNo" value="<%=loginUser.getUserNo()%>">
            <table align="center">
                <tr>
                    <th>카테고리</th>
                    <td>
                        <select name="category">
                            <%for(Category c : list) {%>
                            	<option value="<%=c.getCategoryNo() %>"><%=c.getCategoryName() %></option>
                   
                            <%}%>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>제목</th>
                    <td><input type="text" name="title" required></td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td>
                        <textarea name="content" cols="30" rows="10" style="resize:none" required>

                        </textarea>
                    </td>
                </tr>
                <tr>
                    <th>첨부파일</th>
                    <td><input type="file" name="upfile" id=""></td>
                </tr>
            </table>
            <br>
            <div align="center">
                <button type="submit">작성하기</button>
                <button type="reset">취소</button>
            </div>


        </form>

    </div>
</body>
</html>