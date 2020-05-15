<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row {
   margin: 0px auto;
   width:900px;
}
h1 {
  text-align: center;
}
</style>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<%--
	JSP =====> MovieController
	find.do		@PostMapping("find.do")
				사용자 요청값을 받아서 DAO 연결

 --%>
<div class="container">
	<div class="row">
		<h1 class="text-center">검색결과</h1>
		<table class="table">
			<tr>
				<td>
					<a href="list.do" class="btn btn-sm btn-danger">목록</a>
				</td>
			</tr>
		</table>
		<c:forEach var="vo" items="${list }">
			<div class="col-md-4">
				<div class="thumbnail">
					<a href="detail.do?mno=${vo.mno}"> 
					<img src="${vo.poster}"
						alt="Lights" style="width: 100%">
						<div class="caption">
							<p>${vo.title }</p>
						</div>
					</a>
				</div>
			</div>
		</c:forEach>
	</div>
</div>
</body>
</html>