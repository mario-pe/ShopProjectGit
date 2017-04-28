<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mario
  Date: 27.04.2017
  Time: 09:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sklep</title>
</head>
<body>
<h1>Witaj w Sklepie </h1>
<table>
    <tr>
        <th> link </th>
        <th>Producent</th>
        <th>Model</th>
        <th>Cena</th>
    </tr>

    <c:forEach var="item" items="${itemList}">
    <tr>
        <td>
            <c:url var="url" scope="page" value="/new_item_cart">
                <c:param name="id" value="${item.id}"/>
            </c:url>
            <a href="${url}">${item.id}</a>
        </td>
        <td> ${item.producent}</td>
        <td>${item.model}</td>
        <td>${item.price}</td>
    </tr>
    </c:forEach>
</table>

</body>
</html>
