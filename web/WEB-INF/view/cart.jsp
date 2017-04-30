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
                <td>Ilosc</td>
            </tr>
                <%--<c:set var="i" scope="page" value="0" />--%>

            <c:forEach var="item" items="${orderItems}" varStatus="i">

                <td>${i.index + 1 }</td>
                <td>${item.producent}</td>
                <td>${item.model}</td>
                <td>${item.price}</td>
                <td>${item.quantity}</td>


                <form action="/editCart" method="get">
                    <td>
                        <select name="newQuantity">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                            <option value="7">7</option>
                            <option value="8">8</option>
                            <option value="9">9</option>
                            <option value="10">10</option>
                        </select>

                        <input type="hidden" name="index" value="${i.index}">
                        <input type="hidden" name="action" value="edit">
                        <input type="submit" value="edytuj"/>
                    </td>
                </form>


                <%--<c:url var="url_edit" scope="page" value="/editCart">--%>
                <%--<c:param name="index" value="${i.index}"/>--%>
                <%--<c:param name="action" value="edit"/>--%>
                <%--<c:param name="quantity" value="${quantity}"/>--%>
                <%--</c:url>--%>
                <%--<td> <a href="${url_edit}"> <input type="button" value="edytuj" /></a> </td>--%>

                <c:url var="url_remove" scope="page" value="/editCart">
                    <c:param name="index" value="${i.index}"/>
                    <c:param name="action" value="remove"/>
                </c:url>

                <td><a href="${url_remove}"> <input type="button" value="usun"> </a></td>
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
    <input type="button" value="wróc do zakupów"/>
</a>
<a href="/shop">
    <input type="button" value="wróc do zakupów"/>
</a>

</body>
</html>
