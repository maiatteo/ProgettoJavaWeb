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
	</form>
</body>
</html>