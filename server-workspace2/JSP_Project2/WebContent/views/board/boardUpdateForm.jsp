<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.kh.board.model.vo.*,java.util.*" %>
<%
	Board b = (Board)request.getAttribute("board");
	Attachment a =(Attachment)request.getAttribute("attachment");
	ArrayList<Category> clist = (ArrayList<Category>)request.getAttribute("category");
	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%@ include file="/views/common/menubar.jsp"%>

    <div class="outer">
        <br>
        <h2 align="center">일반 게시글 수정</h2>
        <form action="<%=contextPath%>/update.bo" method="post" id="enroll-form" enctype="multipart/form-data">
            <input type="hidden" name="bno" value="${board.boardNo}">
            <table align="center">
                <tr>
                    <th>카테고리</th>
                    <td>
                        <select name="category">
                            <%for(Category c : clist) {%>
                            	<%if(b.getCategoryNo().equals(c.getCategoryName())){ %>
                            	<option value="<%=c.getCategoryNo() %>" selected><%=c.getCategoryName() %></option>
                            	<%}else{%>
                            	<option value="<%=c.getCategoryNo() %>"><%=c.getCategoryName() %></option>
                            	<%}%>
                            <%}%>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>제목</th>
                    <td><input type="text" name="title" value="<%=b.getBoardTitle() %>" required></td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td>
                        <textarea name="content" cols="30" rows="10" style="resize:none" required> <%=b.getBoardContent() %> </textarea>
                    </td>
                </tr>
                <tr>
                    <th>첨부파일</th>
                    <td>
                    <%if(a!=null){ %>
                    <%=a.getOriginName()%>
       				<input type="hidden" name="originFileNo" value="<%=a.getFileNo() %>">
       				<input type="hidden" name="originFileName" value="<%=a.getChangeName() %>">
                    <%} %>
                    <label for="files" class="btn btn-dark">첨부파일선택</label>
                    <input type="file" name="reUpfile" id="files">
                    <div id="files-div"></div>
                    </td>
                </tr>
            </table>
            <br>
            <div align="center">
                <button type="submit">수정하기</button>
                <button type="button" onclick="history.back();">취소</button>
            </div>


        </form>

    </div>

</body>
</html>