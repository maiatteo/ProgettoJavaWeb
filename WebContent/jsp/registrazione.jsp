<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Registrazione</h1>
	<div id="formulario">
	<form action="/ProvaCom/registrazione" method="POST">
	<div>
			<label>Nome: </label><br><input type="text" name="nome" />
		</div>
		
		<div>
			<label>Cognome: </label><input type="text" name="cognome" />
		</div>
		<div>
			<label>Email: </label><br><input type="text" name="email" />
		</div>
		<div>
			<label>Username: </label><input type="text" name="username" />
		</div>
		<div>
			<label>Password: </label><input type="text" name="password" />
		</div>
		<br>
		<input type="submit" value="REGISTRATI" />
	
	</form>
	</div>
</body>
<style>
#formulario{
padding:20px;
width:200px;
heigth:100px;
margin: 0 auto;
border:2px solid black;
}
h1{
text-align:center;
}
body{
background:#FAEBD7;
}

</style>
</html>