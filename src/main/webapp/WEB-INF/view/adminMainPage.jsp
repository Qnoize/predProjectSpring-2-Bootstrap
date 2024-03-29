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
            <h3>Admin menu</h3><br>
            <nav class="nav nav-tabs">
                <a class="nav-item nav-link active" id="nav-tab1" data-toggle="tab" href="#tab1" aria-controls="tab1" style="background: lightgrey"><h5>User table</h5></a>
                <a class="nav-item nav-link" id="nav-tab2" data-toggle="tab" href="#tab2" aria-controls="tab2" style="background: lightgrey"><h5>Add user</h5></a>
            </nav><br>
            <div class="tab-content" style="background: lightgrey">
                <div role="tabpanel" class="tab-pane fade show active" id="tab1" aria-labelledby="nav-tab1">
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Name</th>
                                    <th>Password</th>
                                    <th>Email</th>
                                    <th>Role</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${requestScope.list}" var="user" varStatus="vs">
                                    <tr>
                                        <td> ${user.id} </td>
                                        <td> ${user.userName} </td>
                                        <td> ${user.userPassword} </td>
                                        <td> ${user.userEmail} </td>
                                        <td> ${(user.role.toString().replaceAll("^\\[|\\]$", ""))}</td>
                                        <td>
                                            <button type="button" class="btn btn-secondary btn-sm" data-toggle="modal"
                                                    data-target="#modalEdit${user.id}">edit
                                            </button>

                                            <div class="modal fade" id="modalEdit${user.id}" role="dialog" aria-labelledby="modalEdit${user.id}" aria-hidden="true" >
                                                <div class="modal-dialog modal-dialog-centered" role="document">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <div class="row">
                                                                <div class="col text-center">
                                                                    <h3 class="modal-title" id="modalEdit${user.id}">Edit user ${user.userName}</h3>
                                                                    <button class="close" type="button" data-dismiss="modal"aria-label="Close">
                                                                        <span aria-hidden="true">&times;</span>
                                                                    </button>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <form method="post" action="/admin/edit">
                                                            <div class="modal-body">
                                                                <div class="row justify-content-center">
                                                                    <div class="col-md-4"></div>
                                                                    <div class="col-md-4 text-center justify-content-center">
                                                                        <div align="center">Id</div>
                                                                        <input class="form-control text-center" type="text" name="id"  value= ${user.id} readonly>
                                                                        <div align="center">Login</div>
                                                                        <input class="form-control text-center" type="text" name="userName"  value= ${user.userName}>
                                                                        <div align="center">Password</div>
                                                                        <input class="form-control text-center" type="password" name="userPassword" value=${requestScope.userPassword}>
                                                                        <div align="center">E-mail</div>
                                                                        <input class="form-control text-center" type="text" name="userEmail"  value=${user.userEmail}>
                                                                        <div align="center">Role</div>
                                                                        <input class="form-control text-center" type="text" name="userRole"  value=${user.role.toString().replaceAll("^\\[|\\]$", "")} readonly>
                                                                        <br>
                                                                    </div>
                                                                    <div class="col-md-4"></div>
                                                                </div>
                                                            </div>
                                                            <div class="modal-footer center-block text-center">
                                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                                <button type="submit" class="btn btn-primary">Confirm</button>
                                                            </div>
                                                        </form>
                                                    </div>
                                                </div>
                                            </div>
                                            <form method="POST" action="/admin/delete">
                                                <button type="submit" class="btn btn-secondary btn-sm">delete</button>
                                                <input type="hidden" name="id" value="${user.id}">
                                            </form>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div role="tabpanel" class="tab-pane fade" id="tab2" aria-labelledby="nav-tab2">
                    <div class="row justify-content-center">
                        <div class="row">
                            <div class="col">
                                <form method="POST" action="/admin" class="navbar-form navbar-right">
                                    <div class="form-group" align="center">
                                        <input class="form-control"  type="text" name="userName" id="inputLogin" placeholder="login">
                                        <input class="form-control"  type="password" name="userPassword" id="inputPassword" placeholder="password">
                                        <input class="form-control"  type="email" name="userEmail" id="inputEmail" placeholder="e-mail"><br>
                                        <div align="center" width="100">
                                            <input class="btn btn-primary" type="submit" value="Add" name="Ok">
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
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