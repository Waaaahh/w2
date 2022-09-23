<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title</title>
</head>
<body>
<c:if test="${param.result == 'error' }" >
	<h1>로그인에러</h1>
</c:if>
	<form action="/Login" method="post">
		<input type="text" name="mid">
		<input type="text" name="mpw">
		<button type="submit">LOGIN</button>
	</form>
</body>
</html>