<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mario
  Date: 03.05.2017
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Panel administarcyjny</title>
</head>
<body>
<h1>Obecny asortyment</h1>
${info}
<form method="get">
    <table border="1">
        <tr>
            <td>
                <form method="get" action="/sort">
                    <input type="hidden" value="producent" name="group">
                </form>
            </td>
            <td>
                <form method="get" action="/sort">
                    <input type="hidden" value="id" name="group">
                    <button type="submit" name="orderBy" value="desc">m</button>
                    <button type="submit" name="orderBy" value="asc">r</button>
                </form>

            </td>
            <td>
                <form method="get" action="/sort">
                    <input type="hidden" value="producent" name="group">
                    <button type="submit" name="orderBy" value="desc">m</button>
                    <button type="submit" name="orderBy" value="asc">r</button>
                </form>
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
            <td>
                <form method="get" action="/sort">
                    <input type="hidden" value="stock" name="group">
                    <button type="submit" name="orderBy" value="desc">m</button>
                    <button type="submit" name="orderBy" value="asc">r</button>
                </form>
            </td>
        </tr>
        <tr>
            <td>nr</td>
            <td>id</td>
            <td>producent</td>
            <td>model</td>
            <td>cena</td>
            <td>magazyn</td>
        </tr>

        <c:forEach var="item" items="${itemList}" varStatus="i">
            <tr>
                <td>${i.index +1}</td>
                <td>${item.id}</td>
                <td>${item.producent}</td>
                <td>${item.model}</td>
                <td>${item.price}</td>
                <td>${item.stock}</td>

                <c:url var="urlDelete" scope="page" value="/edit">
                    <c:param name="id" value="${item.id}"/>
                    <c:param name="action" value="delete"/>
                </c:url>
                <td>
                    <a href="${urlDelete}"><input type="button" value="usun" class="deleteButton"/></a>
                </td>
                <c:url var="urlEdit" scope="page" value="/edit">
                    <c:param name="id" value="${item.id}"/>
                    <c:param name="action" value="edit"/>
                </c:url>
                <td>
                    <a href="${urlEdit}"><input type="button" value="edytuj"/></a>
                </td>
                <td>

                        <c:if test="${item.stock < size}" >
                        <b>!!!</b>
                        </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
</form>


<form action="/edit" method="get">

    <button type="submit" name="action" value="add">dodaj produkt</button>
</form>
<a href="/logout"><input type="button" value="wyloguj"/></a>

</form>
<a href="/order_form"><input type="button" value="nowe zamowienie"/></a>

</body>
</html>
