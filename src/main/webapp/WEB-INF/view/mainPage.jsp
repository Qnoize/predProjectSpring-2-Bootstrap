<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html;charset=windows-1251"
         pageEncoding="windows-1251"%>
<html>
<head>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
 <h2 align="center">Main page</h2><br>
    <div align="center" width="100">
        <form method="GET" action="/">
            <button><a href="/login" style="text-decoration: none; color: black;">Login</a></button>
            <button><a href="/register" style="text-decoration: none; color: black;">Registration</a></button>
        </form>
    </div>
</body>
</html>

