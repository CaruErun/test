<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

    <!--Latest compiled and minified CSS-->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

	<link rel="stylesheet" href="/Semi/views/admin-css/admin_a_3.css">
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
						<option value="userId">ID</option>
						<option value="selectService">구분</option>
					</select>
					</div>
					<div class="col-sm-5">
						<input type="text" name="search_user" id="search_user" class="form-control"> 
					</div>   
					<div class="col-sm-3">
						<button type="submit" id="search_btn"><img src="../image/search.png" id="search_img">검색</button>
					</div>    
				</div>      
			</form>
		</div>
		<!--input 바 끝-->

		<!--회원 명 수 및 버튼 시작-->
		<div id="content_2_3">

			검색 문의 수 <span style="color:red">30</span>개
		</div>
		<div id="content_2_4">
			<button type="button" class="btn btn-warning">답변등록</button>
			<button type="button" class="btn btn-warning">선택삭제</button>
		</div>
		<!--회원 명 수 및 버튼 끝-->

		<!--게시글 테이블 작업 시작-->
		<div id="content_2_5">
			<table class="table table-sm">
				<thead class="thead-light">
				<tr>
					<th width="5%"><input type="checkbox" name="cmCheck"></th>
					<th width="5%">번호</th>
					<th width="10%">아이디</th>
					<th width="20%">작성시간</th>
					<th width="10%">구분</th>
					<th>제목</th>
				</tr>
				</thead>
				<tbody>
				<tr onclick = "onModal();">
					<td onclick="event.cancelBubble=true"><input type="checkbox" name="cmCheck"></td>
					<td>1</td>
					<td>user12</td>
					<td>2020-01-01</td>
					<td>배송관련</td>
					<td>물건이 50일째 안와요</td>
				</tr>
				</tbody>
			</table>
		</div>
		<!--게시글 테이블 작업 끝-->
		
		<!--글 목록 시작-->
		<div id="content_2_6">
			<ul class="pagination">
				<li class="page-item"><a class="page-link" href="#">Previous</a></li>
				<li class="page-item active"><a class="page-link" href="#">1</a></li>
				<li class="page-item"><a class="page-link" href="#">2</a></li>
				<li class="page-item"><a class="page-link" href="#">3</a></li>
				<li class="page-item"><a class="page-link" href="#">Next</a></li>
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
       	<table class="table modal-table">
			<tr>
				<th width="50%;">ID : user12</th>
				<td rowspan="2" style="vertical-align:middle">답변 작성</td>
			</tr>
			<tr>
				<th>문의 제목 : 50일째 배송이 안와요</th>
			</tr>
			<tr>
				<td colspan="2" rowspan="2" id="textareaTd" height="300px">
					<textarea></textarea>
				</td>
			</tr>			       

				
		</table>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
      	<button type="button" class="btn btn-warning">답변 등록</button>
        <button type="button" class="btn btn-danger myModal1Close">Close</button>
      </div>

    </div>
  </div>
</div>
	</div>
	
<script>
	function onModal(){
		document.getElementById("myModal1").style.display="block";
		
	}
	var myModal = document.getElementsByClassName("myModal1Close");
	for(var i=0;i<myModal.length;i++){
		myModal[i].onclick=function(){
			document.getElementById("myModal1").style.display="none";
		}
	}
	/*window.onkeydown = function(){
		if(event.keyCode==27 && document.getElementById("myModal1").getAttribute("display","block")==true){
			document.getElementById("myModal1").style.display="none";
		}
	}*/

	window.onkeydown = function(){
		if(event.keyCode==27){
			document.getElementById("myModal1").style.display="none";
		}
	}
</script>
</body>
</html>