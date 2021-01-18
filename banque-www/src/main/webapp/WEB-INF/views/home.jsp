<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<div class="topnav">
  <a class="active" href="/banque">Accueil</a>
  <a href="admin/homeAdmin">Connexion Administrateur</a>
  <a href="user/homeUser">Connexion Utilisateur</a>
</div>
<h1>
	Bienvenue. 
</h1>
<style>
@import url(https://fonts.googleapis.com/css?family=Patua+One|Open+Sans);
p, h1, li {
	font-family: 'Patua One', cursive;
	/*border-collapse: collapse;*/
	width: 100%;
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
table {
  border-collapse: separate;
  width: 100%;
  background:#fff;
  border-radius:5px;
  margin:50px auto;
  border:1px solid grey;
  border-spacing:0px;
}

thead {
   border-radius:15px;
}

thead th {
  font-family: 'Patua One', cursive;
  font-size:16px;
  font-weight:400;
  color:#fff;
  text-align:left;
  padding:20px;
  background:grey;
  border-top:1px solid #858d99;
  
  /*&:first-child {
   @include border-top-left-radius(5px); 
  }

  &:last-child {
    @include border-top-right-radius(5px); 
  }*/
}

tbody tr td {
  font-family: 'Open Sans', sans-serif;
  font-weight:400;
  color:#5f6062;
  font-size:13px;
  padding:20px 20px 20px 20px;
  border-bottom:1px solid #e0e0e0;
  
}

tbody tr:nth-child(2n) {
  background:#f0f3f5;
}

tbody tr:last-child td {
  border-bottom:none;
  &:first-child {
    @include border-bottom-left-radius(5px);
  }
  &:last-child {
    @include border-bottom-right-radius(5px);
  }
}

tbody:hover > tr td {
  @include opacity(0.5);
  
  /* uncomment for blur effect */
  /* color:transparent;
  @include text-shadow(0px 0px 2px rgba(0,0,0,0.8));*/
}

tbody:hover > tr:hover td {
  @include text-shadow(none);
  color:#2d2d2d;
  @include opacity(1.0);
}
</style>
<P>  Bienvenue sur votre outil de gestion bancaire. </P>
<table>
        <thead><tr><th>Menu</th><th>Description</th></tr></thead>
		<tbody>
        <tr><td><a class="active" href="/banque">Accueil</a></td><td>Accueil.</td></tr>
        <tr><td><a href="infosBanque">Informations</a></td><td>Informations sur la banque</td></tr>
</tbody>
    </table>
</body>
</html>
