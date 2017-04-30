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
<h1> Zamówieni</h1>
<p>no to </p> ${customer.firstName} <p> złóż zamówienie </p>
<h2> Produkty </h2>
<form action="/order" method="get">

    <select name="country">
        <c:forEach items="${countries}" var="country">
            <option value="${country.code} " ${param.country eq country.code ? 'selected' : ''}>${country.name}</option>
        </c:forEach>
    </select>


<c:forEach var="item" items="${orderItems}" varStatus="i">

    <td>${i.index + 1 }</td>
    <td>${item.producent}</td>
    <td>${item.model}</td>
    <td>${item.price}</td>
    <td>${item.quantity}</td>

</c:forEach>
<select name = payment>
<c:forEach var="payment" items="${payments}" varStatus="i">
    <option value="${payment.type}" ${param.payment ? 'selected' : ''}>${payment.type}</option>

    <%--<td>${i.index + 1 }</td>--%>
    <%--<td>${payment.type}</td>--%>

</c:forEach>
</select>

<c:forEach var="shipping" items="${shipping}" varStatus="i">

    <td>${i.index + 1 }</td>
    <td>${shipping.type}</td>
    <td>${shipping.price}</td>

</c:forEach>

<input type="submit" value="złóż zamowienie"/>
</form>



</body>
</html>
