<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html;charset=windows-1251"
         pageEncoding="windows-1251"%>
<html>
<head>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<h3 align="center">${requestScope.error}</h3><br>
<form method="POST" action="/">
    <table width="50%" cellspacing="0" cellpadding="4" align="center">
        <tr>
            <td></td>
            <td>
                <div align="center">
                    <p><h2>Autorization user</h2></p>
                </div>
            </td>
        </tr>
        <tr>
            <td align="right" width="100">Login</td>
            <td><input class="input-field"  type="text" name="userName"></td>
        </tr>
        <tr>
            <td align="right">Password</td>
            <td><input class="input-field" type="password" name="userPassword"></td>
        </tr>
        <tr>
            <td></td>
            <td align="left" width="100">
                <input type="submit" value="Enter" name="Ok">
                <button><a href="/register" style="text-decoration: none; color: black;">Registration</a></button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
