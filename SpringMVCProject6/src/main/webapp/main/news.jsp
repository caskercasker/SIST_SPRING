<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
/* .row {
   margin: 0px auto;
   width:700px;
} */
h1 {
  text-align: center;
}
</style>
</head>
<body>
	<%= application.getRealPath("/main") %>
	<div class="container">
		<h1>네이버 뉴스 </h1>
		<div class="row">
			<div class="col-sm-7">
			<table class="table">
				<tr>
					<td class="text-center">
						<form method=post action="news.do">
							<input type=text name=fd size=20 class="input-sm">
							<button class="btn btn-sm btn-primary">검색</button>
						</form>
					</td>
				</tr>
			</table>
			<table class="table">
				<tr>
					<td>
						<c:forEach var="vo" items="${list}">
							<table class="table">
								<tr>
									<td><a href="${vo.link}" target="_blank">
										${vo.title}
										</a>
									</td>
								</tr>
								<tr>
									<td>
										${vo.description}
									</td>
								</tr>
								<tr>
									<td class="text-right">${vo.author}

									</td>
								</tr>
							</table>
						</c:forEach>
					</td>
				</tr>
			</table>
			</div>
			<div class="col-sm-5">
				<img src="news.png">
			</div>
		</div>
	</div>
</body>
</html>