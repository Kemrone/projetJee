<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
      <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<center>
<h1>  Login </h1>  
</center>
<br>  
<a><a href="home">Retour à l'Accueil</a></a>
<center>
    <f:form action="redirect"  method="get">  
        <div class="container">   
            <label>Nom d'Utilisateur : </label>  
            <input type="text" placeholder="Entrez votre nom d'utilisateur" id="username" value="${username}" name="username" required>  
            <br>  <br> 
            <label>Mot de passe : </label>   
            <input type="password" placeholder="Entrez votre mot de passe"  id="password" value="${password}" name="password" required>  
            <br> <br> <br> 
            <button type="submit" value="Submit" >Login</button>   
            <button type="button" class="cancelbtn"> Cancel</button>    
        </div>   
    </f:form>    
    
    ${message} 
</center>
</body>
</html>
