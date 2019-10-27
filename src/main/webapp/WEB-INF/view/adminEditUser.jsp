<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html;charset=windows-1251"
         pageEncoding="windows-1251"%>
<html>
<body>
<form method="POST" action="/admin/edit">
    <p><b>Edit user with Id - ${user.id} </b></p>
    <table width="100%" cellspacing="0" cellpadding="4" items="${requestScope.user}">
        <tr>
            <td align="right" width="100">Login</td>
            <td><input type="text" name="userName" value= ${user.userName}></td>
        </tr>
        <tr>
            <td align="right">Password</td>
            <td><input type="password" name="userPassword" value=${user.userPassword}></td>
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
