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
<form action="/ProvaCom/prenotazione" method="GET">
		<div>
			<label>TITOLO: ${libro.titolo}</label> 
		</div>
		<div>
			<label>CASAEDITRICE: ${libro.casaeditrice}</label> 
		</div>
		<div>
			<label>AUTORI: ${libro.autori}</label> 
		</div>
		<div>
			<label>CATEGORIA: ${libro.categoria}</label> 
		</div>
		<div>
			<label>ISBN: ${libro.isbn}</label> 
		</div>
		<div>
			<label>NOTE: ${libro.note}</label> 
		</div>
		<div>
			<label>STATO: ${libro.stato}</label> 
		</div>
		<c:if test="${libro.stato == 'disponibile'}">
		<button type="submit">PRENOTA</button>
		</c:if>
	</form>
</body>
</html>