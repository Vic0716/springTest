<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首頁</title>
</head>
<body>
<h1>首頁 OK 666</h1>

<ul>
 <li><a href="${contextRoot}/login.jsp">登入</a></li>
 <li><a href="${contextRoot}/logout">登出</a></li>
 <li><a href="${contextRoot}/uploadPage.jsp">圖片上傳</a></li>
 <li><a href="${contextRoot}/listPhoto">列出圖片</a></li>

</ul>


<c:if test="${sessionScope.loginMember != null}">
 <div>安安  ${sessionScope.loginMember.memberName}</div>
</c:if>

<c:if test="${sessionScope.loginMember == null}">
 <div>目前無使用者登入</div>
</c:if>


</body>
</html>