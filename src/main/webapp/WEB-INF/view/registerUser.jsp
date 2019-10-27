<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html;charset=windows-1251"
         pageEncoding="windows-1251"%>
<html>
<head>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<form method="POST" action="/register">
    <table width="50%" cellspacing="0" cellpadding="4" align="center">
        <tr>
            <td></td>
            <td>
                <div align="center">
                    <p><h2>Register new User</h2></p>
                </div>
            </td>
        </tr>
        <tr>
            <td align="right" width="100">Login</td>
            <td><input type="text" name="userName"></td>
        </tr>
        <tr>
            <td align="right">Password</td>
            <td><input type="password" name="userPassword"></td>
        </tr>
        <tr>
            <td align="right">Email</td>
            <td><input type="text" name="userEmail"></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="Registration" name="Ok">
                <button><a href="/" style="text-decoration: none; color: black;">Back to login</a></button>
            </td>
        </tr>
        <tr>
            <td align="right" width="100">Users table</td>
            <td>
                <table table border="1" cellspacing="0" cellpadding="2" align="center">
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Email</th>
                    </tr>
                    <c:forEach items="${requestScope.list}" var="user">
                        <tr>
                            <td> ${user.id} </td>
                            <td> ${user.userName} </td>
                            <td> ${user.userEmail} </td>
                        </tr>
                    </c:forEach>
                </table>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
