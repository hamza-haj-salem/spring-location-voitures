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


 Voiture
	<select>
		<c:forEach items="${liste2}" var="lv">
			<option>${lv.id} ${lv.marque}</option>
		</c:forEach>
	</select>
 	<br>
	Client
	
	<select>
		<c:forEach items="${listeClient}" var="lv">
			<option>${lv.numPermis} ${lv.nom}</option>
		</c:forEach>
	</select>
	<br>
	
	Date Debut
	<input>
	<br>
	Date Fin
	<input>
	<br>
	<button>Enregistrer</button>
	


</center>
</body>
</html>