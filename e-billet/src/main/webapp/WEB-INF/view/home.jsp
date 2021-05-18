<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript">
    function clearSearch() {
        window.location = "[[@{/home}]]";
    }
</script>
<title>Accueil</title>
</head>
<body>
<center>
<h1>Liste des Evenements</h1>
</center> 

	<br/>
	<c:if test="${user!=null}">
	Bienvenue &nbsp ${user.uLastname}  &nbsp   Solde : ${user.solde} &nbsp  &nbsp
	<a href="logout">Log_Out</a>
	</c:if>
	<c:if test="${user==null }">
   <a href="login">Log_In</a>
   </c:if>
   
    <br/><br/>
    
    
    
 <center>   
    <form th:action="@{/home}">
    Filter: <input type="text" name="keyword" id="keyword" size="50" th:value="${keyword}"  />
    &nbsp;
    <input type="submit" value="Search" />
    &nbsp;
    <input type="button" value="Clear" id="btnClear" onclick="clearSearch()" />
</form>

<br/><br/>
    <div>
      <table border="1">
        <tr>
          <th>Intitulé</th>
          <th>Type</th>
          <th>Participer</th>
        </tr>
        <c:forEach  items="${events}" var ="event">
        <tr>
          <td>${event.eName}</td>
          <td>${event.type.tName}</td>
          <td><a href="goToEvent?ref=${event.eId}">Voir événement</a></td>
        </tr>
        </c:forEach>
      </table>
    </div>
</center>
</body>
</html>