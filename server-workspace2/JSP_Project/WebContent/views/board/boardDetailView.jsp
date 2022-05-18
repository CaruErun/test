<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.board.model.vo.*" %>
<%
	Board b = (Board)request.getAttribute("board");
	Attachment a = (Attachment)request.getAttribute("attachment");
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
        <h2 align="center">일반 게시판 상세보기</h2>
        <br>

        <table id="detail-area" align="center" border="1">
            <tr>
                <th>카테고리</th>
                <td><%=b.getCategoryNo() %></td>
                <th>제목</th>
                <td><%=b.getBoardTitle() %></td>
            </tr>
            <tr>
                <th>작성자</th>
                <td><%=b.getBoardWriter() %></td>
                <th>작성일</th>
                <td><%=b.getCreateDate() %></td>
            </tr>
            <tr>
                <th>내용</th>
                <td colspan="3"><%=b.getBoardContent() %></td>
            
            </tr>
            <tr>
                <th>첨부파일</th>
                <td colspan="3">
                	<%if(a==null){ %>
                		첨부파일이 없습니다.
                	<%} else{ %>
                		<a download="<%=a.getOriginName() %>" href="<%=contextPath%>/<%=a.getFilePath()+a.getChangeName()%>"><%=a.getOriginName() %></a>
                	<%} %>
                </td>
            </tr>
        </table>

        <br>

        <div align="center">
            <a onclick = "history.back()">목록으로</a>
           <%if(loginUser!=null && (loginUser.getUserName().equals(b.getBoardWriter()) || loginUser.getUserId().equals("admin"))){%>
           <!--로그인한 사용자가 게시글 작성자일 경우-->
            <a href="<%=contextPath%>/updateForm.bo?bno=<%=b.getBoardNo()%>">수정하기</a>
            <a href="<%=contextPath%>/delete.bo?bno=<%=b.getBoardNo()%>">삭제하기</a>
            <%}%>
       
        </div>

        <div id="reply-area">
            <table align="center" border="1">

                <thead>
                <%if(loginUser!=null){%>
                    <tr>
                        <th> 댓글 작성</th>
                        <td>
                            <textarea id="replyContent" cols="50" rows="3" style="resize:none;"></textarea>
                        </td>
                        <td><button onclick="insertReply();">댓글 등록</button></td>
                    </tr>
                <%}else{%>
                    <tr>
                        <th> 댓글 작성</th>
                        <td>
                            <textarea id="replyContent" cols="50" rows="3" style="resize:none;" readonly>로그인 후 이용 가능</textarea>
                        </td>
                        <td><button disabled>댓글 등록</button></td>
                    </tr>
                <%}%>
                </thead>
                <tbody>

                </tbody>
            </table>

            <script>
                $(function(){
                    selectReply();
                })
                function insertReply(){
                    $.ajax({
                        url:"replyInsert.bo",
                        data : {
                            content : $("#replyContent").val(),
                            bno : <%=b.getBoardNo()%>
                        },
                        type:"post",
                        success : function(result){
                            selectReply();
                            $("#replyContent").val("");
                        },
                        error : function(){
                            console.log("ajax 통신 실패");
                        }

                    })
                }

                function selectReply(){
                    $.ajax({
                        url:"replyList.bo",
                        data:{bno : <%=b.getBoardNo()%>},
                        success : function(result){
                            var row="";
                            for(var i in result){
                                row+= "<tr>"
                                    + "<td>"+result[i].replyWriter+"</td>"
                                    + "<td>"+result[i].replyContent+"</td>"
                                    + "<td>"+result[i].createDate+"</td>"
                                    + "</tr>";
                            }
                            $("#reply-area tbody").html(row);
                        },
                        error : function(){
                            console.log("실패");
                        }
                    })
                }

            </script>
        </div>




    </div>


</body>
<html>