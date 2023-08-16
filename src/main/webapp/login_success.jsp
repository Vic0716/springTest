<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登入成功</title>
</head>
<body>
<h1>登入成功</h1>
<h3>歡迎 ${sessionScope.loginMember.memberName}</h3>


<h3><a href="${pageContext.request.contextPath}/">回首頁</a></h3>
</body>
</html>