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
<header>
    <div class="ico"><a href="/"><img src="/res/img/logoMain.png" width="70" alt=""></a></div>
    <div class="logout"><a href="/logout"><img src="/res/img/logout.png" width="30" alt=""></a></div>
</header>
<div class="container-fluid">
    <div class="row">
        <div class="col-2 sidebar">
            <nav id="menuVertical">
                <ul>
                    <li><a href="/admin"><div class="menuVertical"></div><span>Admin</span></a></li>
                    <li class="active"><a href="/userHome"><div class="menuVertical"></div><span>User</span></a></li>
                </ul>
            </nav>
            <div class="menu"><div class="footer">Copirate &copy; 2019</div> </div>
        </div>
        <div class="col-10 sidebar" id="menuAll"><br>
            <div class="row">
                <div class="col-3"></div>
                <div class="col-5">
                    <h3 align="center">${requestScope.error}</h3><br>
                    <form method="POST" action="/admin/edit">
                        <div align="center">Id</div>
                        <input class="form-control text-center" type="text" name="userId" id="inputId" value= ${user.id} readonly>
                        <div align="center">Login</div>
                        <input class="form-control text-center" type="text" name="userName" id="inputLogin" value= ${user.userName}>
                        <div align="center">Password</div>
                        <input class="form-control text-center" type="password" name="userPassword" id="inputPassword" value=${requestScope.userPassword}>
                        <div align="center">E-mail</div>
                        <input class="form-control text-center" type="text" name="userEmail" id="inputEmail" value=${user.userEmail}>
                        <div align="center">Role</div>
                        <input class="form-control text-center" type="text" name="userRole" id="inputRole" value=${user.role.toString().replaceAll("^\\[|\\]$", "")}>

                        <br>
                        <div align="center" width="100">
                            <input class="btn btn-secondary" type="submit" value="Confirm" name="Ok">
                            <input type="hidden" name="id" value="${user.id}">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>
</html>
