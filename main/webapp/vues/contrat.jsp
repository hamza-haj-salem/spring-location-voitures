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
<h1>Liste des contrat HAMZA</h1>
	<table border="1">
		<tr><td><b>id</b></td><td><b>client.numPermis</b></td><td><b>voiture.id</b></td><td><b>dateDebut</b></td><td><b>dateFin</b></td></tr>
		<c:forEach items="${listeContrat}" var="lv">
			<tr><td>${lv.id}</td><td>${lv.client.nom}</td><td>${lv.voiture.id}</td><td>${lv.dateDebut}</td><td>${lv.dateFin}</td></tr>
		</c:forEach>
	</table>

</center>
</body>
</html>