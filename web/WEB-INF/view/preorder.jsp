<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mario
  Date: 30.04.2017
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sklep że Hej</title>
</head>
<body>
${customer.firstName} ${info}
<c:choose>
    <c:when test="${orderItems != null}">
        <h2> Produkty </h2>
        <form action="/order" method="get">

            <c:forEach var="item" items="${orderItems}" varStatus="i">

                <td>${i.index + 1 }</td>
                <td>${item.producent}</td>
                <td>${item.model}</td>
                <td>${item.price}</td>
                <td>${item.quantity}</td>
                </br>
            </c:forEach>
            <select name=payment>
                <c:forEach var="payment" items="${payments}">
                    <option value="${payment.type}" ${param.payment ? 'selected' : ''}>${payment.type} </option>

                </c:forEach>
            </select>
            </br>

            <select name=shipping>
                <c:forEach var="shipping" items="${shipping}" varStatus="i=1">
                    <option value="${shipping.id}" ${param.shipping  ? 'selected' : ''}> ${i} ${shipping.type}
                        cena: ${shipping.price}</option>
                </c:forEach>
            </select>


            <input type="submit" value="złóż zamowienie"/>
        </form>
    </c:when>

</c:choose>
<form action="/shop">
    <input type="submit" value="wróc do zakupów"/>
</form>
<a href="/logout">wyloguj</a>
</body>
</html>
