<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="topnav">
  <a href="/banque">Accueil</a>
  <a class="active" href="createClient">Créer client</a>
  <a href="listingClient">Listing client</a>
  <a href="setVirementInter">Virement inter-client</a>
</div>
<h1> Créez un client. </h1>
<form method="post">
	Nom :&nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="nom" value="<c:out value="${cli.nom}"/>"/><p>
	Prenom :    &nbsp;&nbsp;&nbsp;   &nbsp;&nbsp;     <input type="text" name="prenom" value="<c:out value="${cli.prenom}"/>"/><p>
	Adresse :   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  <input type="text" name="adresse" value="<c:out value="${cli.adresse}"/>"/><p>
	Code postal : <input type="text" name="codepostal" value="<c:out value="${cli.codepostal}"/>"/><p>
	Ville :  &nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;  &nbsp;       <input type="text" name="ville" value="<c:out value="${cli.ville}"/>"/><p>
	<input type="submit" value="Ajouter"/><p>
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