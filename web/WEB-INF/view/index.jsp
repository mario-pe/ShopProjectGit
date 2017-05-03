<%--
  Created by IntelliJ IDEA.
  User: mario
  Date: 25.04.2017
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Sklep ze HEJ</title>
</head>
<body>
<h1>Wtaj w sklepiku</h1>

<table>
    <tr>
        <th>link</th>
        <th>Producent</th>
        <th>Model</th>
        <th>Cena</th>
    </tr>
    <c:forEach var="item" items="${itemList}">
        <tr>
            <td>
                <c:url var="url" scope="page" value= "/new_item_cart">
                    <c:param name="id" value="${item.id}"/>
                </c:url>
                <a href="${url}"> ${item.id} </a>
            </td>
            <td>${item.producent }</td>
            <td>${item.model } </td>
            <td>${item.price } </td>
        </tr>
    </c:forEach>
</table>

<c:url value="/shop" var="urlLogin" scope="page" />
<form action="${urlLogin}">
    <input type="submit" value="logowanie"/>
</form>
<a href="/logout">wyloguj</a>
<a href="/shop">shop</a>
</br>
<a href="/test">strona testowa</a>
<a href="/register">Rejestracja</a>
</br>
<a href="/admin">admin</a>
</body>
</html>
