<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html;charset=windows-1251"
         pageEncoding="windows-1251"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="<c:url value="/res/css/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<form method="POST" action="/register" class="navbar-form navbar-right">
    <div align="center">
        <p><h2>Sign up</h2></p>
    </div>
    <div class="container">
        <div class="row">
            <div class="col"></div>
            <div class="col-sm-3">
                <div class="form-group" align="center">
                    <input class="form-control"  type="text" name="userName" id="inputLogin" placeholder="login">
                    <input class="form-control"  type="password" name="userPassword" id="inputPassword" placeholder="password">
                    <input class="form-control"  type="email" name="userEmail" id="inputEmail" placeholder="e-mail"><br>
                    <div align="center" width="100">
                        <input class="btn btn-primary" type="submit" value="Sign up" name="Ok">
                        <button class="btn btn-secondary"><a href="/" style="text-decoration: none; color: white;">Back to main page</a></button>
                    </div>
                </div>
            </div>
            <div class="col"></div>
        </div>
    </div>
</form>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>
</html>
