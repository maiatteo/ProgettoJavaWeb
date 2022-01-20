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
	<c:if test="${amministratore}">
		<a href="/ProvaCom/AmmUtenti">AMMINISTRAZIONE UTENTI</a>
	</c:if>
	<form action="/ProvaCom/login" method="POST">
		<input type="text" name="termine" /> <input type="submit"
			value="cerca" />
	</form>
	<table>
		<tr>
			<th>ID</th>
			<th>TITOLO</th>
			<th>DISPONIBILITA</th>
			<th>DETTAGLI</th>
			<th>PRENOTA</th>
		</tr>
		<c:forEach items="${libri}" var="libro">
			<tr>
				<td>${libro.id}</td>
				<td>${libro.titolo}</td>
				<td>${libro.stato}</td>
				<td><a href="/ProvaCom/Dettagli?id=${libro.id}">dettagli</a></td>
				<c:if test="${libro.stato == 'disponibile'}">
					<td><input type="submit" value="PRENOTA"/></td>
				</c:if>
			</tr>
		</c:forEach>
	</table>

</body>
</html>