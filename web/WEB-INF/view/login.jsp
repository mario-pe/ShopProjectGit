<%--
  Created by IntelliJ IDEA.
  User: mario
  Date: 27.04.2017
  Time: 08:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Logowanie</title>
</head>
<body>
${error}
      	<form method =post action="j_security_check">
        <table>
            <tr>
                <td>login</td>
                <td> <input type="text" name="j_username" /></td>
            </tr>
            <tr>
                <td>hasło</td>
                <td> <input type="password" name="j_password"/> </td>
            </tr>

        </table>
        <input type="submit" value="Zaloguj" />
        </form>

    <p>niemasz konta zarejestruj sie </p>
    <a href="/register">Rejestracja</a>
    </br>
    <a href="/index">strona startowa</a>

    <a href="/logout">wyloguj</a>

</body>
</html>
