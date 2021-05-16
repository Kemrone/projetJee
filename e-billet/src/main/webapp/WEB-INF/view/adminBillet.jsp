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
<td><f:select id ="evt" size = "2" path="evenement">
<c:forEach var="e" items="${events}">
        <option  value = "${e.eId}">${e.eName}</option>
    </c:forEach>
</f:select></td>

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
<td><select id="restriction" name ="restriction" value ="${restriction}" size = "2" >
<c:forEach var="r" items="${rests}">
        <option  value = "${r.restrictionId}">${r.nom}</option>
    </c:forEach>
</select> &nbsp &nbsp Value: <input type="text" id="value" value="${value}" name="value"> </td>


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

 <f:form  modelAttribute="billet" action="editBillet"  method="post">  

<table>
<tr>
<td>iD:</td>
<td> <input type="text" id="bId" value = ${check.bId }  name="bId" readonly /> </td>

</tr>

<tr>
<td>Ajouter Billets:</td>
<td><input type="text" id="bStockAdd" value="${Stock}" name="bStockAdd" /></td>

</tr>

<tr>
<td>Retirer Billets:</td>
<td><input type="text" id="bStockDec" value="${Stock}" name="bStockDec" /></td>

</tr>
</table>
<br>

<td><input type="submit" value="edit"/></td>

 </f:form>  
</c:if>

 
</body>



</html>