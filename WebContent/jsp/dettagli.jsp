<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/World2022/" method="POST">
		<div>
			<label>ID: ${libro.id}</label> 
		</div>
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
	</form>
</body>
</html>