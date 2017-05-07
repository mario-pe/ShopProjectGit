<%--
  Created by IntelliJ IDEA.
  User: mario
  Date: 04.05.2017
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Panel Administratora</title>
</head>
<body>
<h1>Dodaj produkt</h1>
<form method="get" action="/add_item">
    <table>
        <tr>
            <td><label> Producent </label> </td>
            <td><input type="text" name="producent"/> </td>
        </tr>
        <tr>
            <td><label> Model </label> </td>
            <td><input type="text" name="model"/> </td>
        </tr>
        <tr>
            <td><label> Cena </label> </td>
            <td><input type="text" name="price"/> </td>
        </tr>
        <tr>
            <td><label> Ilość </label> </td>
            <td><input type="text" name="stock"/> </td>
        </tr>
        <tr>
            <td><label> magazyn </label> </td>
            <td><input type="text" name="stroehouse"/> </td>
        </tr>
    </table>
    <input type="submit" value="dodaj" />
</form>
</body>
</html>
