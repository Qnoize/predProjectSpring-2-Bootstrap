<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html;charset=windows-1251"
         pageEncoding="windows-1251"%>
<html>
<head>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<h3 align="center">${requestScope.error}</h3><br>
<form method="POST" action="/admin/edit">
    <table width="50%" cellspacing="0" cellpadding="4" items="${requestScope.user}" align="center">
        <tr>
            <td></td>
            <td>
                <div align="center">
                    <p><h2>Edit user with Id - ${user.id}</h2></p>
                </div>
            </td>
        </tr>
        <tr>
            <td align="right" width="100">Login</td>
            <td><input type="text" name="userName" value= ${user.userName}></td>
        </tr>
        <tr>
            <td align="right">Password</td>
            <td><input type="password" name="userPassword" value=${requestScope.userPassword}></td>
        </tr>
        <tr>
            <td align="right">Email</td>
            <td><input type="text" name="userEmail" value=${user.userEmail}></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="Confirm" name="Ok">
                <input type="hidden" name="id" value="${user.id}">
                <button><a href="/admin" style="text-decoration: none; color: black;">Back to admin</a></button>
             </td>
        </tr>
    </table>
</form>
</body>
</html>
