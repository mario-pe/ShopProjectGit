<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mario
  Date: 27.04.2017
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodaj do koszyka</title>
</head>
<c:url>


${item.producent} </br> ${item.model}
<form action="get">
    <table>
        <tr>
            <td> podaj ilosc</td>
            <td> <input type="text" name="quantity"/> </td>

        </tr>
    </table>

    <input type="submit" value="dodaj do koszyka"/>
</form>


<c:url var="url" scope="page" value="/cart">
    <c:param name="id" value="${item.id}" />
    <c param name="quantity" value="quantity"/>
</c:url>

<form  action="${url}">
    <input type="submit" value="sprawdz zawartosc koszyka" />
</form>

</body>
</html>
