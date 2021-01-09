<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="topnav">
  <a href="/banque">Accueil</a>
  <a  href="createClient">Créer client</a>
  <a href="listingClient">Listing client</a>
  <a class="active" href="setVirementInter">Virement inter-client</a>
</div>
<h1>Virements inter-clients : ${cliD.nom} ${cliD.prenom} à ${cliC.nom} ${cliC.prenom}</h1>
<form method="post">

	<c:if test="${not empty comptesD}">
	Compte débiteur (${cliD.nom} ${cliD.prenom}):
		<select name="compteDebit">
    		<c:forEach var="item" items="${comptesD}">
        		<option value="${item.numero}">${item.numero} - ${item.solde} &#8364;</option>
    		</c:forEach>
		</select><p>
	</c:if>
	<c:if test="${not empty comptesC}">
	Compte créditeur (${cliC.nom} ${cliC.prenom}):
		<select name="compteCredit">
    		<c:forEach var="item" items="${comptesC}">
        		<option value="${item.numero}">${item.numero} - ${item.solde} &#8364;</option>
    		</c:forEach>
		</select><p>
	</c:if>
	Montant : <input type="number" name="montant" value=""/><p>
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