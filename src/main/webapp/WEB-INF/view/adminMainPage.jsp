<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html;charset=windows-1251"
         pageEncoding="windows-1251"%>
<html>
<head>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<form method="POST" action="/admin">
    <table width="60%" cellspacing="0" cellpadding="4" align="center">
        <tr>
            <td></td>
            <td>
                <div align="center">
                    <p><h2>Administration page</h2></p>
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
                <input type="submit" value="Add new user" name="Ok">
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
                        <th>Password</th>
                        <th>Email</th>
                    </tr>
                    <c:forEach items="${requestScope.list}" var="user">
                        <tr>
                            <td> ${user.id} </td>
                            <td> ${user.userName} </td>
                            <td> ${user.userPassword} </td>
                            <td> ${user.userEmail} </td>
                            <td>
                                <form method="GET" action="/admin/edit">
                                    <input type="submit" value="edit" name="edit">
                                    <input type="hidden" name="id" value="${user.id}">
                                </form>
                                <form method="GET" action="/admin/delete">
                                    <input type="submit" value="delete" name="delete">
                                    <input type="hidden" name="id" value="${user.id}">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </td>
        </tr>
    </table>
</form>
</body>
</html>