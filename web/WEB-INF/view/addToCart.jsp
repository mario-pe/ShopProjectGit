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


${item.producent} </br> ${item.model} </br> ${item.price}

<form action="/adding" method="get">
    <table>
        <tr>
            <td> podaj ilosc</td>
            <td>
                <select name="quantity">
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
            </td>


        </tr>
    </table>
    <input type="hidden" name="id" value="${item.id}">
    <input type="hidden" name="producent" value="${item.producent}">
    <input type="hidden" name="model" value="${item.model}">
    <input type="hidden" name="price" value="${item.price}">
    <input type="submit" value="dodaj do koszyka"/>
</form>



<form  action="/cart">
    <input type="submit" value="sprawdz zawartosc koszyka" />
</form>

</body>
</html>