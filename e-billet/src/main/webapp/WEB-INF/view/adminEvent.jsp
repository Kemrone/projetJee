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

<title>Gestion Evenements</title>
</head>

<center>
<h1>Page Events</h1>
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
a:link {
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

<td>Date:</td>
<td><input type="date" id="date" name="date"
       value=""
        max="2100-12-31"></td>

<tr>





</tr>

</table>
<br>
<td><input type="submit" value="Save"/></td>

</f:form>

<br>

<table>
<tr>
<th>Nom</th><th>Type</th>
<th>Lieu</th><th>Date</th>
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
 <td>
<c:forEach items="${e.acceuil}" var="d">
${d.date} &nbsp 
</c:forEach>
 </td>
<td><a href="deleteEvent?ref=${e.eId}">Delete</a></td>
<td><a href="checkEditEvent?ref=${e.eId}">Edit</a></td>
</tr>
</c:forEach>
</table>
<br>

<c:if test="${check1!=null }">

<h2>EditForm</h2>

<f:form  modelAttribute="evenement" action="editEvent"  method="post">  

<table>
<tr>
<td>Id:</td>
<td> <input type="text" id="eId" value = ${check1.eId }  name="eId" readonly /> </td>

</tr>

<tr>
<td>Nom</td>
<td><input type="text" id="eName" value="${eName}" name="eName" /></td>

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
</select></td> &nbsp
<td>Date:</td>
<td><input type="date" id="date1" name="date1"
       value=""
        max="2100-12-31"></td>
        
        </tr>


</table>
<br>

<td><input type="submit" value="Edit"/></td>

 </f:form>  
</c:if>
</center>


 
</body>
</html>