<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
            height: 800px;


        }
    #enroll-form table{
        border:1px solid black;


    }
    #enroll-form input, #enroll-form textarea{
        width:100%;
    }
    #enroll-form input[type="file"]{
    	width:50%;
    }
</style>
</head>
<body>
    <%@ include file="/views/common/menubar.jsp"%>
    <div class="outer">
        <br>
        <h2 align="center">사진 게시판 작성</h2>
        <br>
        <form action="<%=contextPath%>/insert.th" id="enroll-form" method="post" enctype="multipart/form-data">
            <input type="hidden" value="<%=loginUser.getUserNo()%>" name="userNo">
            <table align="center">
                <tr>
                    <th width="100">제목</th>
                    <td colspan="3"><input type="text" name="boardTitle" required></td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td colspan="3"><textarea cols="30" rows="10" style="resize:none" name="boardContent" required></textarea></td>
                </tr>
                <tr>
                    <th>대표이미지</th>
                    <td colspan="3" align="center">
                        <img alt="" width="250" height="170" id="titleImg">

                    </td>
                </tr>
                <tr>
                    <th>상세이미지</th>
                    <td><img id="contentImg1" width="150" height="120"></td>
                    <td><img id="contentImg2" width="150" height="120"></td>
                    <td><img id="contentImg3" width="150" height="120"></td>
                </tr>

            </table>

            <div id="file-area">
                <input type="file" id="files1" onchange="loadImg(this,1);" name="files1" required>
                <input type="file" id="files2" onchange="loadImg(this,2);" name="files2">
                <input type="file" id="files3" onchange="loadImg(this,3);" name="files3">
                <input type="file" id="files4" onchange="loadImg(this,4);" name="files4">

            </div>






    </div>

    <script>
        function loadImg(inputFile,num){
            //console.log(inputFile.files.length);
            //파일선택시 1 아닐시 0 파일 유무 확인 가능

            if(inputFile.files.length==1){
                //FileReader 객체 생성 (파일 관련 객체)
                var reader = new FileReader();

                reader.readAsDataURL(inputFile.files[0]);
                //파일 읽는 순간 url 부여
                reader.onload=function(e){
                    switch(num){
                        case 1 : $("#titleImg").attr("src",e.target.result); break;
                        case 2 : $("#contentImg1").attr("src",e.target.result); break;
                        case 3 : $("#contentImg2").attr("src",e.target.result); break;
                        case 4 : $("#contentImg3").attr("src",reader.result); break;
                    }
                }

            }else{
                switch(num){
                    case 1 : $("#titleImg").removeAttr("src"); break;
                    case 2 : $("#contentImg1").removeAttr("src"); break;
                    case 3 : $("#contentImg2").removeAttr("src"); break;
                    case 4 : $("#contentImg3").removeAttr("src"); break;
                }
            }
        }
    </script>
    <div align="center">
        <button type="submit"> 등록</button>

    </div>
</form>
</body>
</html>