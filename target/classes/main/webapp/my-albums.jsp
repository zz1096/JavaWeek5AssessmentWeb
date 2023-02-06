<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Albums</title>
</head>
<body>
	<h1>My Albums</h1>
	<form method="post" action="navigationServlet">
	<table>
	<tr>
		<th>
		<th>Album Name</th>
		<th>Artist</th>
		<th>Genre</th>
		<th>Number of Songs</th>
	</tr>
	<c:forEach items="${requestScope.allAlbums}" var="currentAlbum">
	<tr>
		<td><input type="radio" name="id" value="${currentAlbum.id}"></td>
		<td>${currentAlbum.albumName}</td>
		<td>${currentAlbum.artist}</td>
		<td>${currentAlbum.genre}</td>
		<td>${currentAlbum.numberOfSongs}</td>
	</tr>
	</c:forEach>
	</table>
	<input type="submit" value="Edit" name="selectedValue">
	<input type="submit" value="Delete" name="selectedValue">
	<input type="submit" value="Add" name="selectedValue">
	</form>
</body>
</html>