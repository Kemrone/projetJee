<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Preview ${event.eName }</title>
</head>

<body>
<center>
<h1>${event.eName }</h1>
</center>
<br>

<center>
<table border="1">
  <tr>
    <th colspan="2">Description de l'événement</th>
  </tr>
  <tr>
    <td>Nom</td>
    <td>${event.eName }</td>
  </tr>
  <tr>
    <td>Type</td>
    <td>${event.type.tName }</td>
  </tr>
  <tr>
    <td>Lieu</td>
    <td>
<c:forEach var="a" items="${event.acceuil}">
        ${a.lieu.lName} &nbsp
    </c:forEach></td>
  </tr>
  <tr>
    <td>adresses</td>
    <td>
<c:forEach var="a" items="${event.acceuil}">
        ${a.lieu.lAddress} &nbsp
    </c:forEach></td>
  </tr>
  <tr>
    <td>Date</td>
    <td>
<c:forEach var="a" items="${event.acceuil}">
        ${a.date}
    </c:forEach></td>
  </tr>
</table>
</center>

<br>

<center>
<a href="home">Accueil  </a>&nbsp&nbsp
<c:if test="${user !=null }">
<a href="goToBillet?ref=${event.eId}"> Acheter un billlet</a>
</c:if>
</center>


</body>
</html>