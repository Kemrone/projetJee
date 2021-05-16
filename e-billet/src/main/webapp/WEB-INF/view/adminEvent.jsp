<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion Evenements</title>
</head>
<body>

<h2>AddForm</h2>
<br>
<f:form method="post" action="saveEvent" >
<table>
<tr>
<td>Nom:</td>
<td><input type="text" id="eName" value="${eName}" name="eName"></td>

</tr>
<tr>
<td>Type:</td>
<td><select id="type" name = "type"value="${type}" size = "2"  >
<c:forEach var="t" items="${types}">
        <option  value = "${t.tId}">${t.tName}</option>
    </c:forEach>
</select></td>

<tr>
<td>Lieu:</td>
<td><select id="lieu" name="lieu" value="${lieu}" size = "2"  >
<c:forEach var="l" items="${lieux}">
        <option  value = "${l.lId}">${l.lName}</option>
    </c:forEach>
</select></td>


<tr>

<td><input type="submit" value="save"/></td>

</tr>

</table>

</f:form>

<table>
<tr>
<th>Nom</th><th>Type</th>
<th>Lieu</th><th>Stock</th><th>Restriction</th>
</tr>
<c:forEach items="${events}" var="e">
<tr>
<td>${e.eName}</td>
<td>${e.type.tName}</td>
<td>
<c:forEach items="${e.acceuil}" var="l">
${l.lieu.lName} &nbsp 
</c:forEach>
 </td>
<td><a href="deleteEvent?ref=${e.eId}">Delete</a></td>
<td><a href="checkEvent?ref=${b.eId}">Edit</a></td>
</tr>
</c:forEach>
</table>
<br><br>



<h2>EditForm</h2>

 
 
</body>
</html>