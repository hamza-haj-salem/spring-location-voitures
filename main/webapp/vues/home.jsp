<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
	<h1>Liste des voiture disponibles HAMZA</h1>
	<table border="1" class="table">
		<tr><th><b>id</b></th><th><b>marque</b></th><th><b>disponobilite</b></th></tr>
		<c:forEach items="${listeVoiture}" var="lv">
			<tr><td align="center">${lv.id}</td><td align="center">${lv.marque}</td><td align="center">${lv.disponobilite}</td></tr>
		</c:forEach>
	</table>
	
	<a href="addContrat">saisir contrat</a>
	<a href="contrats">liste des contrats</a>
	<a href="addClient">ajouter un client</a>
</center>
</body>
</html>