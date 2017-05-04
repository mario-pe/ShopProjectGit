<%--
  Created by IntelliJ IDEA.
  User: mario
  Date: 03.05.2017
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Panel administratora - edycja</title>
</head>
<body>
<form action="/save">
    <table>
        <tr>
            <td> Numer produktu</td>
            <td>${item.id}</td>
            <td><input type="hidden" name="id" value="${item.id}" /></td>
        </tr>
        <tr>
            <td>Producent</td>
            <td><label >${item.producent}</label></td>
            <td><input type="text" name="prducent"/> </td>
        </tr>
        <tr>
            <td>Model</td>
            <td><label >${item.model}</label></td>
            <td><input type="text" name="model"/> </td>
        </tr>
        <tr>
            <td>Cena</td>
            <td><label >${item.price}</label></td>
            <td><input type="text" name="price"/> </td>
        </tr>
        <tr>
            <td>Magazyn</td>
            <td><label >${item.stock}</label></td>
            <td><input type="text" name="stock"/> </td>
        </tr>
    </table>
    <input type="submit" value="zmień"/>
</form>
<a href="/admin"><input type="button"  value="wróć do panelu" /></a>

</body>
</html>
