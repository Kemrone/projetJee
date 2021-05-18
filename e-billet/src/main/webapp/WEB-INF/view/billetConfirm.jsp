<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirmation</title>
</head>
<body>

<body>
<center>
<h1>Etes vous sur de vouloir acheter ce billet?</h1>
</center>
<br>

<center>
<table border="1">
  <tr>
    <th colspan="2">Récapitulatif</th>
  </tr>
  <tr>
    <td>Critères</td>
    <td>${billet.bCritere }</td>
  </tr>
  <tr>
    <td>Evenement</td>
    <td>${billet.evenement.eName }</td>
  </tr>
  <tr>
    <td>Tarif</td>
    <td>${billet.bTarif } euros</td>
  </tr>
  <tr>
    <td>adresses</td>
    <td>
<c:forEach var="a" items="${event.acceuil}">
        ${a.lieu.lAddress}, &nbsp
    </c:forEach></td>
  </tr>
</table>
<br>
Votre solde : ${user.solde}
<br>
</center>
<br>
<center>
<f:form action="confirm">

<input type="submit" value="Acheter" id="btnAcheter" />
</f:form>
</center>
<br>
<br>

<center>
<c:if test="${message!=null }">
${message }
</c:if>
</center>


<br>

</body>
</html>
