<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des Utilisateurs</title>
</head>
<body>
<f:form modelAttribute="utilisateur" method="post" action="saveUser">
<table>
<tr>
<td>Nom:</td>
<td><f:input path="uLastname"/></td>

</tr>
<tr>
<td>Prenom:</td>
<td><f:input path="uFirstname"/></td>

</tr>
<tr>
<td>Mail:</td>
<td><f:input path="uMail"/></td>

</tr>
<tr>
<td>Mot de Passe:</td>
<td><f:input path="password"/></td>

</tr>
<tr>

<td><input type="submit" value="Save"/></td>

</tr>
</table>
</f:form>
<table>
<tr>
<th>Nom</th><th>Prenom</th>
<th>Mot de Passe</th><th>Mail</th>
</tr>
<c:forEach items="${utilisateurs}" var="u">
<tr>
<td>${u.uLastname}</td>
<td>${u.uFirstname}</td>
<td>${u.password}</td>
<td>${u.uMail}</td>
<td><a href="deleteUser?ref=${u.uId}">Delete</a></td>
<td><a href="editUser?ref=${u.uId}">Edit</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>