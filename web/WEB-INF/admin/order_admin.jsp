<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mario
  Date: 04.05.2017
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<table border="1">
    <tr>
        <td>nr</td>
        <td>id</td>
        <td>producent</td>
        <td>model</td>
        <td>cena</td>
        <td>stan magazynowy</td>
        <td>zamowienie</td>
    </tr>

    <c:forEach var="item" items="${itemList}" varStatus="i">
        <form action="/pre_order">
            <tr>
                <td>${i.index +1}</td>
                <td>${item.id}</td>
                <td>${item.producent}</td>
                <td>${item.model}</td>
                <td>${item.price}</td>
                <td>${item.stock}</td>
                <td><input type="text" name="quantity"/><input type="hidden" name="id" value="${item.id}"/></td>
                <td>
                    <input type="submit" value="dodaja do zamowienia">
                </td>
            </tr>
        </form>
    </c:forEach>
</table>

<table>
    <tr>
        <td>nr</td>
        <td>producent</td>
        <td>model</td>
        <td>zamowienie</td>
        <td>id item</td>
    </tr>
    <c:forEach var="orderItem" items="${orderItemList}" varStatus="i">
        <tr>
            <td>${i.index + 1}</td>
            <td>${orderItem.producent}</td>
            <td>${orderItem.model}</td>
            <td>${orderItem.quantity}</td>
            <td>${orderItem.item_id}</td>
        </tr>
    </c:forEach>
</table>

<a href="/admin_order"><input type="button" value="załóż zamowienie"/></a>
</br>
<a href="/logout"><input type="button" value="wyloguj"/></a>

</body>
</html>

