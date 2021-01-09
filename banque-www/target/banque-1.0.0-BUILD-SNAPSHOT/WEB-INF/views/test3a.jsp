<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test 3a</title>
</head>
<body>
	<h1>Bonjour depuis la jsp test3a !</h1>
</body>
<style>
table, p, h1 {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}
td, th{
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}
tr:nth-child(even){
	backgroud-color: #dddddd;
}
</style>
<P> la servlet a envoyé la valeur suivante : ${chaine} </P>
</html>