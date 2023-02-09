<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create new Album List</title>
</head>
<body>
	<h1>Create an Album List</h1>
	<form action="createNewAlbumListServlet" method="post">
		Album List Name: <input type="text" name="listName"><br />
		Username: <input type="text" name="name"><br />
		Available Albums: <br />
		<select name="allAlbumsToAdd" multiple size="6">
			<c:forEach items="${requestScope.allAlbums}" var="currentAlbum">
				<option value="${currentAlbum.id}">${currentAlbum.albumName} by ${currentAlbum.artist}</option>]
			</c:forEach>
		</select>
		<br />
		<input type="submit" value="Create Album List and Add Albums">
	</form>
	<a href="index.html">Add new albums</a>
</body>
</html>