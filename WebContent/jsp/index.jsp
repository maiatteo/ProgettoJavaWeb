
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Login</h1>
	<div id="formulario">
		<form action="/ProvaCom/login" method="GET">
			<div>
				<label>Username: </label><input type="text" name="username" />
			</div>
			<div>
				<label>Password: </label><input type="password" name="password" />
			</div>
			<br> <input type="submit" value="LOGIN" />
		</form>
	</div>
	<h4>
		non sei ancora registrato? <a href="/ProvaCom/registrazione">registrati</a>
	</h4>
	<table>
		<tr>
			<th>ID</th>
			<th>TITOLO</th>
		</tr>
		<c:forEach items="${libri}" var="libro">
			<tr>
				<td>${libro.id}</td>
				<td>${libro.titolo}</td>

			</tr>
		</c:forEach>
	</table>
</body>
<style>
#formulario {
	padding: 20px;
	width: 200px;
	heigth: 100px;
	margin: 0 auto;
	border: 2px solid black;
}

h1 {
	text-align: center;
}

h4 {
	text-align: center;
}

body {
	background: #FAEBD7;
}
</style>
</html>