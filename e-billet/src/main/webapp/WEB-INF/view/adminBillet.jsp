<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<style>
table{
  border: 1px solid black;
}
</style>

<title>Gestion Billets</title>
</head>

<center>
<h1>Page Billet</h1>
</center>

<body>

<style type="text/css">
.liens {
  position: -webkit-sticky;
  position: sticky;
  top: 0;
  background-color: orange;
  padding-top : 30px;
  padding-bottom : 30px;
  padding-right : 30px;
  padding-left : 30px;
  font-weight : bold;
  font-size : 150%;
  display : flex;
  flex-direction : row;
  justify-content : space-around;
}
.liens.a:link{ {
color : white;
}
</style>
<div class = "liens">
        <div><a href="admin">Admin</a></div>
        <div><a href="adminEvent">Evenements</a></div> 
        <div><a href="adminBillet">Billets</a></div>
       

        </div>
<br>
<br>
<br>

<center>

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



</tr>

</table>
<br>
<td><input type="submit" value="Save"/></td>
<br><br>

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
<table>
 <f:form  modelAttribute="billet" action="editBillet"  method="post">  

<table>
<tr>
<td>Id:</td>
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

<td><input type="submit" value="Edit"/></td>

 </f:form>  
 
 </table>
</c:if>
</center>

 
</body>



</html>
