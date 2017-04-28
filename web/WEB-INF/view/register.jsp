<%--
  Created by IntelliJ IDEA.
  User: mario
  Date: 27.04.2017
  Time: 08:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Rejestracja</title>
</head>
<body>
<h1>Rejestracja</h1>
${error}

<form method="post">
    <table>
        <tr>
            <td>Imie</td>
            <td><input type="text" name="firstName" maxlenht="30"></td>
        </tr>
        <tr>
            <td>Nazwisko</td>
            <td><input type="text" name="lastName" maxlenht="30"></td>
        </tr>
        <tr>
            <td>Login</td>
            <td><input type="text" name="login" maxlenht="30"></td>
        </tr>
        <tr>
            <td>Hasło</td>
            <td><input type="password" name="password" maxlenht="30"></td>
        </tr>
        <tr>
            <td>Powtórz hasło</td>
            <td><input type="password" name="password2" maxlenht="30"></td>
        </tr>
        <tr><td><p>adres</p></td></tr>
        <tr>
            <td>Miasto</td>
            <td><input type="text" name="city" maxlenht="30"></td>
        </tr>
        <tr>
            <td>Ulica</td>
            <td><input type="text" name="street" maxlenht="30"></td>
        </tr>
        <tr>
            <td>Nr domu</td>
            <td><input type="text" name="house" maxlenht="30"></td>
        </tr>
        <tr>
            <td>Kod pocztowy</td>
            <td><input type="text" name="zip" maxlenht="10"></td>
        </tr>
    </table>
    <input type="submit" value="Rejestracja" />
</form>
</body>
</html>
