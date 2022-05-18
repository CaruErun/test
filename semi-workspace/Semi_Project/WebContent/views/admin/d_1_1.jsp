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

	<link rel="stylesheet" href="/Semi/views/admin-css/admin_a_2.css">
</head>
<body>
	<%@include file="/views/common/adminMenubar.jsp" %> 
	<div id="content_2">
		<!--왼쪽 여백--><div id="content_2_empty"></div>
		<div id="content_2_1">
			<h2>FAQ작성</h2>
		</div>
		<!--input 바 시작-->
		<div id="content_2_2">
				<div id="content_2_2_1">
					<div class="selecdiv col-sm-2">
					구분
					</div>
					<div class="col-sm-5">
						<select id="search_user" class="form-control">
							<option>배송관련</option>
							<option>택배관련</option>
						</select>
					</div>   
					<br><br><br><br>
					<div class="selecdiv col-sm-2">
					제목
					</div>
					<div class="col-sm-5">
						<input type="text" name="search_user" id="search_user" class="form-control">
					</div>    
				</div>      
		</div>
		<!--input 바 끝-->

		<!--회원 명 수 및 버튼 시작-->
		<div id="content_2_3">
			<div id="content_2_3_1">내용</div>
			<textarea></textarea>
			
		</div>
		<div id="content_2_4">
			<button type="button" class="btn btn-warning">FAQ 등록</button>
			<button type="button" class="btn btn-warning" onclick="history.back()">돌아가기</button>
		</div>
		<!--회원 명 수 및 버튼 끝-->
		<!--게시글 테이블 작업 끝-->
		
	</div>
	
</body>
</html>