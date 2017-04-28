<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mario
  Date: 27.04.2017
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
</head>
<body>
<c:choose>
    <c:when test="${orderItems !=null}">
<table>
    <tr>
        <td>nr</td>
        <td>Producent</td>
        <td>Model</td>
        <td>Cena</td>
        <td>Price</td>
    </tr>
    <c:set var="i" scope="page" value="0"/>
    <c:forEach var="item" items="${orderItems}">

            <td>${i+1}</td>
            <td>${item.producent}</td>
            <td>${item.model}</td>
            <td>${item.price}</td>
            <td>${item.quantity}</td>

                <%--<c:url var="url" scope="page" value="/cartEdit">--%>
                    <%--<c:param name="id" value="${item.id}"/>--%>
                <%--</c:url>--%>
            <td> <a href="${url}"> <input type="button" value="edytuj" /></a> </td>
            <td><input type="button" value="usun"> <c:remove var="item"/> </td>
        </tr>
    </c:forEach>
</table>
    </c:when>
    <c:otherwise>
        <c:out value="niemasz jeszcze nic w koszyku"/>
    </c:otherwise>
</c:choose>
${item.producent} </br> ${item.model}
<a href="/shop">
    <input type="button" value="wróc do zakupów" />
</a>



</body>
</html>
