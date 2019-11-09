<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html;charset=windows-1251"
         pageEncoding="windows-1251"%>
<html>
<head>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark fixed-top bg-dark">
    <a class="navbar-brand" href="#">Java Mentor example</a>
    <button
            class="navbar-toggler"
            type="button"
            data-toggle="collapse"
            data-target="#navbarCollapse"
            aria-controls="navbarCollapse"
            aria-expanded="false"
            aria-label="Toggle navigation"
    >
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav mr-auto sidenav" id="navAccordion">
            <li class="nav-item active">
                <a class="nav-link" href="#">Admin <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">User</a>
            </li>

        </ul>

    </div>
</nav>
 <h2 align="center">Main page</h2><br>
    <div align="center" width="100">
        <form method="GET" action="/">
            <button><a href="/login" style="text-decoration: none; color: black;">Login</a></button>
            <button><a href="/register" style="text-decoration: none; color: black;">Registration</a></button>
        </form>
    </div>

<main class="content-wrapper">
    <div class="container-fluid">
        <h1>Main Content</h1>
    </div>
</main>

</body>
</html>

