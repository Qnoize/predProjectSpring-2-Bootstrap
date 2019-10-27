<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html;charset=windows-1251"
         pageEncoding="windows-1251"%>
<html>
<head>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<div align="center">
    <div align="center">
        <p><h2>User Home page</h2></p>
    </div>
    <br>
    <table width="50%" cellspacing="0" cellpadding="4" align="center">
        <tr>
            <td align="center" width="100">
                <h2>
                    hello user, your login is<br>
                </h2>
            </td>
            <td align="center" width="100">
                <h2>
                    ${requestScope.name}<br>
                </h2>
            </td>
        </tr>
        <tr>
            <td align="center" width="100">
                <h2>
                    and your role is<br>
                </h2>
            </td>
            <td align="center" width="100">
                <h2>
                    ${requestScope.role}<br>
                </h2>
            </td>
        </tr>
    </table>
    <br>
    <div align="center" width="100">
        <form method="POST" action="/userHome">
            <button><a href="/" style="text-decoration: none; color: black;">Back to login</a></button>
        </form>
    </div>
</div>
</body>
</html>
