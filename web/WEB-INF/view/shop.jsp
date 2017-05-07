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
    <link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>

<div id="header">
    <h1>Witaj w Sklepie ${customer.firstName} </h1>
</div>
<div id="navigation">
    <form action="/preOrder">
        <input type="submit" value=" złóż zamóweinie"/>
    </form>
    <form action="/cart">
        <input type="submit" value=" sprawdz zawartość wózka"/>
    </form>

</div>
<div id="option">
    <form action="/sort" method="get">
        <select>
            <option></option>
            <c:forEach var="item" items="${itemList}">
                <option>${item.producent}</option>
            </c:forEach>
        </select>
        <input type="submit" value="szukaj"/>
    </form>
</div>
<div id="content">
    <table>
        <tr>
            <td></td>
            <td>
                <%--temporary I use servlet to sort table, in future I use JS--%>
                <form method="get" action="/sort">
                    <input type="hidden" value="producent" name="group">
                    <button type="submit" name="orderBy" value="desc">m</button>
                    <button type="submit" name="orderBy" value="asc">r</button>
                </form>
                <%--<button type="button" id="btnProdDesc">m</button>--%>
                <%--<button type="button" id="btnProdasc">d</button>--%>
            </td>

            <td>
                <form method="get" action="/sort">
                    <input type="hidden" value="model" name="group">
                    <button type="submit" name="orderBy" value="desc">m</button>
                    <button type="submit" name="orderBy" value="asc">r</button>
                </form>
            </td>
            <td>
                <form method="get" action="/sort">
                    <input type="hidden" value="price" name="group">
                    <button type="submit" name="orderBy" value="desc">m</button>
                    <button type="submit" name="orderBy" value="asc">r</button>
                </form>
            </td>
        </tr>
        <tr>
            <th> link</th>
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
</div>
<div id="footer">
    <a href="/logout">wyloguj</a>
</div>

</body>
</html>
