<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Album List</title>
</head>
<body>
	<form action="editAlbumListDetailsServlet" method="post">
		<input type="hidden" name="id" value="${editAlbumList.id}">
		Album List Name: <input type="text" name="listName" value="${editAlbumList.listName}"><br />
		Username: <input type="text" name="name" value="${editAlbumList.user.name}"><br />
		Available Albums: <br />
		<select name="allAlbumsToAdd" multiple size="6">
			<c:forEach items="${requestScope.allAlbums}" var="currentAlbum">
				<option value="${currentAlbum.id}">${currentAlbum.albumName} by ${currentAlbum.artist}</option>]
			</c:forEach>
		</select>
		<br />
		<input type="submit" value="Edit Album List and Add Albums">
	</form>
	<a href="index.html">Add new albums</a>
</body>
</html>