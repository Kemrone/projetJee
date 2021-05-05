<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Billet</title>
</head>
<body>
<h2>EditForm</h2>
${billet.bId }
 <f:form action="editBillet"  method="post">  

<table>
<tr>
<td>Id:</td>
<td> <input type="text" placeholder = "" id="bId" value="${bId}" name="bId" /></td>

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



</body>
</html>