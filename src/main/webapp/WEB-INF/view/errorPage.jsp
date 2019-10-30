<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html;charset=windows-1251"
         pageEncoding="windows-1251"%>
<html>
<head>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
 <h3 align="center">${requestScope.error}</h3><br>
    <div align="center" width="100">
        <form method="POST" action="/userHome">
            <button><a href="/" style="text-decoration: none; color: black;">Back to login</a></button>
        </form>
    </div>
</body>
</html>

