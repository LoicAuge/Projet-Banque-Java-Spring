<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="topnav">
<div>
  <a href="/banque/home">Accueil</a>
  <a  href="createClient">Créer client</a>
  <a href="listingClient">Listing client</a>
  <a class="active" href="setVirementInter">Virement inter-client</a>
  <a href="<c:url value="/j_spring_security_logout"/>">Deconnexion</a>
  </div>
   <b>Connecté en tant que ${username}</b>
</div>
<h1>Virements inter-clients</h1>
<form method="post">

	<c:if test="${not empty clients1}">
	Client débiteur :
		<select name="clientDebit">
    		<c:forEach var="item" items="${clients1}">
        		<option value="${item.id}">${item.nom} ${item.prenom} </option>
    		</c:forEach>
		</select><p>
		Client créditeur :
		<select name="clientCredit">
    		<c:forEach var="item" items="${clients2}">
        		<option value="${item.id}">${item.nom} ${item.prenom}</option>
    		</c:forEach>
		</select><p>
	</c:if>
	<input type="submit" value="Valider le virement"/><p>
</form>
<style>
@import url(https://fonts.googleapis.com/css?family=Patua+One|Open+Sans);
form {
font-family: 'Patua One', cursive;
  font-size:16px;
  font-weight:400;
}
h1{
font-family: 'Patua One', cursive;
}
.topnav {
  background-color: #333;
  overflow: hidden;
}

/* Style the links inside the navigation bar */
.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-family: 'Patua One', cursive;
  font-size:16px;
  font-weight:400;
}

.topnav b {
  float: right;
  color: #f2f2f2;
  text-align: right;
  padding: 14px 16px;
  text-decoration: none;
  font-family: 'Patua One', cursive;
  font-size:16px;
  font-weight:400;
}

/* Change the color of links on hover */
.topnav a:hover {
  background-color: #ddd;
  color: black;
}

/* Add a color to the active/current link */
.topnav a.active {
  background-color: #224EC4;
  color: white;
}
</style>