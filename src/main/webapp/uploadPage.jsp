<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>上傳圖片</title>
</head>
<body>
<h1>上傳圖片</h1>

<form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
圖片名稱: <input type="text" name="photoName">
<br>
選擇檔案: <input type="file" name="photoFile">
<br>

<input type="submit" value="送出">

</form>

<div>${msg}</div>

</body>
</html>