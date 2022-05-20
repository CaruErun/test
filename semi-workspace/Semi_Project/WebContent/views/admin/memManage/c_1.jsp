<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList, com.kh.memManage.model.vo.Member, com.kh.common.PageInfo" %>
<%
	ArrayList<Member> mList = (ArrayList<Member>)request.getAttribute("mList");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

    <!--Latest compiled and minified CSS-->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

	<link rel="stylesheet" href="/Semi/views/admin-css/admin_a_1.css">
</head>
<body>
	<%@include file="/views/common/adminMenubar.jsp" %> 
	<div id="content_2">
		<!--왼쪽 여백--><div id="content_2_empty"></div>
		<div id="content_2_1">
			<h2>회원관리</h2>
		</div>
		<!--input 바 시작-->
		<div id="content_2_2">
			<form action="search_user.do" method="post">
				<div id="content_2_2_1">
					<div class="selecdiv col-sm-2">
					<select id="select" class="form-control">
						<option value="userId">회원ID</option>
						<option value="userName">회원명</option>
						<option value="userNickName">닉네임</option>
					</select>
					</div>
					<div class="col-sm-5">
						<input type="text" name="search_user" id="search_user" class="form-control"> 
					</div>   
					<div class="col-sm-3">
						<button type="submit" id="search_btn"><img src="/Semi/views/image/search.png" id="search_img">검색</button>
					</div>    
				</div>      
			</form>
		</div>
		<!--input 바 끝-->

		<!--회원 명 수 및 버튼 시작-->
		<div id="content_2_3">

			검색 회원 수 <span style="color:red"><%=pi.getListCount() %></span>명
		</div>
		<div id="content_2_4">
			<button type="button" class="btn btn-warning">회원보기</button>
			<button type="button" class="btn btn-warning">회원수정</button>
			<button type="button" class="btn btn-warning">회원삭제</button>
			<button type="button" class="btn btn-warning">쿠폰확인</button>
		</div>
		<!--회원 명 수 및 버튼 끝-->

		<!--게시글 테이블 작업 시작-->
		<div id="content_2_5">
			<table class="table table-sm">
				<thead class="thead-light">
				<tr>
					<th><input type="checkbox" name="cmCheck"></th>
					<th>번호</th>
					<th>아이디</th>
					<th>이름</th>
					<th>전화번호</th>
					<th>구매금액</th>
					<th>쿠폰</th>
					<th>회원상태</th>
				</tr>
				</thead>
				<tbody>
				<%for(Member m : mList) { %>
				<tr class="onModal">
					<td onclick="event.cancelBubble='true'"><input type="checkbox" name="cmCheck" ></td>
					<td><%=m.getUserNo() %></td>
					<td><%=m.getUserId()%></td>
					<td><%=m.getUserName() %></td>
					<td><%=m.getPhone() %></td>
					<td>100,000</td>
					<td>5장</td>
					<td><%=(m.getuStatus().equals("Y") ) ? "회원 상태" : "탈퇴 상태"%></td>
				</tr>
				<%} %>
				</tbody>
			</table>
		</div>
		<!--게시글 테이블 작업 끝-->
		
		<!--글 목록 시작-->
		<div id="content_2_6">
			<ul class="pagination">
				<%if(pi.getStartPage()!=1) {%>
				<li class="page-item"><a class="page-link" href="<%=contextPath%>/manage.mm?cpage=<%=pi.getStartPage()-pi.getPageLimit()%>">Previous</a></li>
				<%}%>
				<%for(int i=pi.getStartPage();i<=pi.getEndPage();i++) {%>
				<li class="page-item index-page"><a class="page-link" href="<%=contextPath%>/manage.mm?cpage=<%=i%>"><%=i%></a></li>
				<%}%>
				<%if(pi.getEndPage()!=pi.getMaxPage()) {%>
				<li class="page-item"><a class="page-link" href="<%=contextPath%>/manage.mm?cpage=<%=pi.getEndPage()+1%>">Next</a></li>
				<%} %>
			  </ul>
		</div>
		<!--글 목록 끝-->
		<div class="modal1" id="myModal1">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">회원상세정보</h4>
        <button type="button" class="close myModal1Close" >&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
       	<table class="table modal-table table-sm" id="modal-bodyy">	       

				
		</table>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger myModal1Close">Close</button>
      </div>

    </div>
  </div>
</div>
	</div>
	
<script>
window.onload=function(){
	var liArr = $(".index-page");
	for(var i=0;i<liArr.length;i++){
		liArr.eq(i).removeClass("active");
		if(liArr.eq(i).text()==<%=pi.getCurrentPage()%>){
			liArr.eq(i).addClass("active");
		}
	}
}
	$(".onModal").click(function(){
		document.getElementById("myModal1").style.display="block";
		var str = ""
		$.ajax({
			url : "ajaxModal.mm",
			data :{mno : this.childNodes[3].innerHTML},
			success : function(result){
				str +=	"<tr>"+
				"<th width='40%;'>회원번호</th>" +
				"<td width='60%;'>"+result.userNo+"</td>" +
			"</tr>" + 
			"<tr>"+
			"<th>아이디</th>" +
			"<td>"+result.userId+"</td>" +
			"</tr>" + 
			"<tr>"+
			"<th>이름</th>" +
			"<td>"+result.userName+"</td>" +
			"</tr>" + 
			"<tr>"+
			"<th>이메일</th>" +
			"<td>"+result.email+"</td>" +
			"</tr>" + 
			"<tr>"+
			"<th>전화번호</th>" +
			"<td>"+result.phone+"</td>" +
			"</tr>" + 
			"<tr>"+
			"<th>아이디 생성 날짜</th>" +
			"<td>"+result.userBirth+"</td>" +
			"</tr>";
			$("#modal-bodyy").html(str);
			},
			error : function(){
				console.log("실패");
			}
		})
	})
	var myModal = document.getElementsByClassName("myModal1Close");
	for(var i=0;i<myModal.length;i++){
		myModal[i].onclick=function(){
			document.getElementById("myModal1").style.display="none";
		}
	}

</script>
</body>
</html>