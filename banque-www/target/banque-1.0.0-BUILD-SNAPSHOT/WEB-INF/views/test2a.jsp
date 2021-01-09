<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Test 2a</title>
    </head>

    <body>
        <h1>
            Bonjour depuis la jsp test2a !
        </h1>

        <P> la servlet a envoyé les valeurs suivantes : </P>
        <P> un : ${un} </P>

        <table>
            <tr> <th>clé </th> <th>Valeur</th> </tr>
            <tr> <td>un </td> <td>${un}</td> </tr>
            <tr> <td>deux </td> <td>${deux}</td> </tr>
            <tr> <td>trois </td> <td>${trois}</td> </tr>

        </table>
    </body>