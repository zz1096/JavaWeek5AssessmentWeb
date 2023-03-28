<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Album</title>
<script type="text/javascript">
	function validate(){
		if(document.albumForm.albumName.value == ""){
			alert("Please input an Album Name");
			document.albumForm.albumName.focus();
			return false;
		}
		if(document.albumForm.artist.value == ""){
			alert("Please input an Artist Name");
			document.albumForm.artist.focus();
			return false;
		}
		if(document.albumForm.genre.value == ""){
			alert("Please input a Genre");
			document.albumForm.genre.focus();
			return false;
		}
	    if(document.albumForm.numSongs.value == ""){
			alert("Please input a number of songs");
			document.albumForm.genre.focus();
			return false;
		}
		return(true);
	}
</script>
</head>
<body>
	<h1>Edit Album</h1>
	<form name="albumForm" onsubmit="return validate();" action ="editAlbumServlet" method="post">
	Album Name: <input type="text" name="albumName" value="${edit.albumName}"><br />
	Artist: <input type="text" name="artist" value="${edit.artist}"><br />
	Genre: <input type="text" name="genre" value="${edit.genre}"><br />
	Number of Songs: <input type="text" name="numSongs" value="${edit.numberOfSongs}"><br />
	<input type="hidden" name="id" value="${edit.id}">
	<input type="submit" value="Save Edited Album"><br />
	</form><br />
</body>
</html>