<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Album</title>
</head>
<body>
	<h1>Edit Album</h1>
	<form action ="editAlbumServlet" method="post">
	Album Name: <input type="text" name="albumName" value="${edit.albumName}"><br />
	Artist: <input type="text" name="artist" value="${edit.artist}"><br />
	Genre: <input type="text" name="genre" value="${edit.genre}"><br />
	Number of Songs: <input type="text" name="numSongs" value="${edit.numberOfSongs}"><br />
	<input type="hidden" name="id" value="${edit.id}">
	<input type="submit" value="Save Edited Album"><br />
	</form><br />
</body>
</html>