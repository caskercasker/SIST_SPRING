<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="row">
		<h1 class="text-center">${title }</h1>
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
	<div class="row text-center">
		<a href="../movie/list.do?page=${curpage>1?curpage-1:curpage }" class="btn btn-sm btn-primary">이전</a>
		  ${curpage} page / ${totalpage } pages
		<a href="../movie/list.do?page=${curpage<totalpage?curpage+1:curpage }" class="btn btn-sm btn-primary">다음</a>
	</div>
</body>
</html>