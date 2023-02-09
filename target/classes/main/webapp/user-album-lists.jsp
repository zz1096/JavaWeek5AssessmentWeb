<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Album Lists</title>
</head>
<body>
	<h1>Album Lists</h1>
	<form method="post" action="albumListNavServlet">
		<table>
			<c:forEach items="${requestScope.allAlbums}" var="currentList">
				<tr>
					<td><input type="radio" name="id" value="${currentList.id}"></td>
					<td><h2>${currentList.listName}</h2></td>
				</tr>
				<tr>
					<td colspan="3">User: ${currentList.user.name}</td>
				</tr>
				<c:forEach var="albumListVal" items="${currentList.albumList}">
					<tr>
						<td></td>
						<td colspan="3">${albumListVal.albumName} by ${albumListVal.artist} 
						/ Genre: ${albumListVal.genre} Number of Songs: ${albumListVal.numberOfSongs}
						</td>
					</tr>
				</c:forEach>
			</c:forEach>
		</table>
		<input type="submit" value="Edit" name="selectedValue">
		<input type="submit" value="Delete" name="selectedValue">
		<input type="submit" value="Add" name="selectedValue">
	</form>
	<a href="index.html">Add albums</a><br />
	<a href="viewAllAlbumListsServlet">View all Album Lists</a><br />
	<a href="addNewAlbumListServlet">Create an Album List</a>
</body>
</html>