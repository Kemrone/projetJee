<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">


<title>Gestion Billets</title>
</head>
<body>

<h2>AddForm</h2>
<br>
<f:form modelAttribute="billet" method="post" action="saveBillet" >
<table>
<tr>
<td>Critères:</td>
<td><f:input path="bCritere"/></td>

</tr>
<tr>
<td>Evenement:</td>
<td><f:input path="evenement"/></td>

</tr>
<tr>
<td>Tarif:</td>
<td><f:input path="bTarif"/></td>

</tr>
<tr>
<td>Stock:</td>
<td><f:input  path="stock"/></td>

</tr>

<tr>
<td>Restriction:</td>
<td><f:select id="req" size = "2" path="${billet.requiert}">
<c:forEach var="r" items="${rest}">
        <option  value = "${r.restrictionId}">${r.nom}</option>
    </c:forEach>
</f:select></td>


<tr>

<td><input type="submit" value="save"/></td>

</tr>

</table>

</f:form>

<table>
<tr>
<th>Critères</th><th>Evenement</th>
<th>Tarif</th><th>Stock</th><th>Restriction</th>
</tr>
<c:forEach items="${billets}" var="b">
<tr>
<td>${b.bCritere}</td>
<td>${b.evenement.eName}</td>
<td>${b.bTarif}</td>
<td>${b.stock}</td>
<td>
<c:forEach items="${b.requiert}" var="restriction">
${restriction.restriction.nom} &nbsp : &nbsp ${restriction.value}
</c:forEach>
 </td>
<td><a href="deleteBillet?ref=${b.bId}">Delete</a></td>
<td><a href="checkEditBillet?ref=${b.bId}">Edit</a></td>
</tr>
</c:forEach>
</table>
<br><br>

<c:if test="${check!=null }">

<h2>EditForm</h2>

 <f:form action="editBillet"  method="post">  

<table>
<tr>
<td>iD:</td>
<td> <input type="text" placeHolder = "${check.bId }"id="bCritere"  name="id" /></td>

</tr>

<tr>
<td>Critères:</td>
<td> <input type="text" id="bCritere" value="${bCritere}" name="bCritere" /></td>

</tr>
<tr>
<td>Evenement:</td>
<td><input type="text" id="bEvent" value="${bEvent}" name="bEvent" /></td>

</tr>
<tr>
<td>Tarif:</td>
<td><input type="text" id="bTarif" value="${bTarif}" name="bTarif" /></td>

</tr>
<tr>
<td>Stock:</td>
<td><input type="text" id="bStock" value="${bStock}" name="bStock" /></td>

</tr>

<tr>
<td>Restriction:</td>
<td><input type="text" id="bRestriction" value="${bRestriction}" name="bRestriction" /></td>

</tr>
</table>


<br>

<td><input type="submit" value="edit"/></td>

 </f:form>  
</c:if>

 
</body>



</html>