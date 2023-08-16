<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登入</title>
</head>
<body>
<h1>登入 11111Page</h1>
<form action="${pageContext.request.contextPath}/login" method="post">
 
  <div class="container">
    <label for="loginName"><b>Username</b></label>
    <input id="loginName" type="text" placeholder="Enter Username" name="loginName" required>

    <label for="loginPwd"><b>Password</b></label>
    <input id="loginPwd" type="password" placeholder="Enter Password" name="loginPwd" required>

    <button type="submit">Login</button> 
  </div>
</form>

<div>${errorMsg}</div>

</body>
</html>