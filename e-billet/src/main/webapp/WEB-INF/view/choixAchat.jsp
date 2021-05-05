<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservation ${event.eName}</title>
</head>
<body>

<center>
<h1>Choix de billet pour l'événement ${event.eName }</h1>
</center>
<br>

<center>
<div>
      <table border="1">
        <tr>
       	  <th>Num Billet</th>
          <th>Critères</th>
          <th>Stock Restant</th>
          <th>Tarif euros</th>
          <th>Acheter</th>
        </tr>
        <c:set var="total" value="${0}"/>
        <c:forEach  items="${event.billet}" var ="billet">
        <c:set var="total" value="${total + 1}" />
        <tr>
          <td>${total}</td>
          <td>${billet.bCritere}</td>
          <td>${billet.stock}</td>
          <td>${billet.bTarif}</td>
          <td><a href="goTo?ref=${billet.bId}">Acheter Billet</a></td>
        </tr>
        </c:forEach>
      </table>
    </div>
</center>

</body>
</html>