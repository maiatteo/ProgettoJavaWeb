<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   	<table>
		<tr>
			<th>ID</th>
			<th>NOME</th>
			<th>COGNOME</th>
			<th>USERNAME</th>
		</tr>
		<c:forEach items="${utenti}" var="utente">
			<tr>
				<td>${utente.id}</td>
				<td>${utente.nome}</td>
				<td>${utente.cognome}</td>
				<td>${utente.username}</td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>