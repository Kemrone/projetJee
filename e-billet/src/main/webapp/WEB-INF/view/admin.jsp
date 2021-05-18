<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<title>Admin</title>
    <meta http-equiv="Content-Type" content="text/html; charset =UTF-8" />
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/header.css" type="text/css" />
</head>
<center>
<h1>Page Admin</h1>
</center>
<br>
<br>
<br>
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


<c:set var="total" value="${0}"/>
<c:forEach var="a" items="${achats}">
    <c:set var="total" value="${total + a.quantite}" />
</c:forEach>
	Nombre de ventes total de billets vendus : ${total}  
	<br>
	Nombre total d'événements : ${nbEvents}
</body>
</html>