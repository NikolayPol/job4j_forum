<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Форум</title>
</head>
<body>
<div class="container mt-3">
    <div class="row" >
        <div class="col-md-12 offset-md-5">
            <h4>Форум</h4>
        </div>

    </div>
    <div class="row">
        <div class="card" style="width: 100%">
            <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #e3f2fd;">
                <div class="container-fluid">
                    <div class="collapse navbar-collapse" id="navbarText">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <a class="nav-link" href="/">Главная</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/create">Добавить запись</a>
                            </li>
                        </ul>
                    </div>
                    <div>
                        Login as : ${user.username}
                    </div>
                </div>
            </nav>
        </div>


        <table class="table">
            <thead>
            <tr>
                <th scope="col">Тема</th>
                <th scope="col">Описание</th>
                <th scope="col">Дата создания</th>
                <th scope="col">Изменить</th>
                <th scope="col">Удалить</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="post" items="${posts}">
                <tr>
                    <td><c:out value="${post.name}"/></td>
                    <td>
                        <c:out value="${post.description}"/>
                    </td>
                    <td>
                        <c:out value="${post.created}"/>
                    </td>
                    <td>
                        <input type="button" value="Изменить"
                               onclick="window.location.href='update?id=${post.id}'"/>
                    </td>
                    <td>
                        <input type="button" value="Удалить"
                               onclick="window.location.href='delete?id=${post.id}'"/>
                    </td>
                </tr>

            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>