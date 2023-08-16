<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>全部圖片</title>
</head>
<body>
	<h1>全部圖片</h1>

	<table>
		<c:forEach var="onePhoto" items="${photoList}">
			<tr>
				<td>${onePhoto.id}</td>
				<td>${onePhoto.photoName}</td>
				<td><img width="200px" src="<c:url value="/download?id=${onePhoto.id}"/>"/> </td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>