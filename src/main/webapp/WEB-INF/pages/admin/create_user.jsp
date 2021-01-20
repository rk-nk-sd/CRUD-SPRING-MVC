<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 20.01.2021
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet"  type="text/css"/>
    <link href="${contextPath}/css/style.css" rel="stylesheet"  type="text/css"/>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-6 col-lg-7"><h1>Список пользователей</h1></div>
        <div class="col-sm-6 col-lg-5"><p>Информация о текущем пользователе</p></div>
    </div>
    <div class="row">
        <div class="col-sm-3 col-lg-3"><!-- <h1>Список пользователей</h1> --></div>
        <div class="col-sm-9 col-lg-9"><a href="/admin/users/new-user" class="c">Добавить нового пользователя</a></div>
    </div>
    <div class="row castom">
        <%--        Меню--%>
        <div class="col-sm-4">
            <ul class="nav">
                <li class="nav-header">Главные ссылки</li>
                <li class="active"><a href="/admin">Главная</a></li>
                <li><a href="/admin/users">Пользователи</a></li>
                <li><a href="/admin/roles">Роли и права</a></li>
                <li class="nav-header">Дополнительные</li>
                <li><a href="#">Наши филиалы</a></li>
                <li><a href="#">Календарь мероприятий</a></li>
                <li class="nav-divider"></li>
                <li><a href="#">Вакансии</a></li>
            </ul>
        </div>
        <%--    Основной контейнер--%>
        <div class="col-sm-8">

            <c:if test="${empty param.login}" var="noLogin" />
            <c:if test="${empty param.password}" var="noPassword" />

            <c:if
                    test="${not (noLogin or noPassword)}">
                <c:set value="${param.login}" var="login" scope="request"/>
                <c:set value="${param.password}" var="password" scope="request"/>
                <jsp:forward page="/admin/users" />
            </c:if>

            <form method="post" action="/admin/users">

                Enter new login:
                <input type="text" name="login" value="${user.login}" />
                <c:if test="${noLogin}">Note: you must enter a name</c:if>
                </p>

                Enter new password:
                <input type="text" name="password" value="${user.password}" />
                <c:if test="${noPassword}">Note: you must enter a password</c:if>
                </p>

                <input type="submit" value="Создать пользователя" />
            </form>

        </div>
    </div>
    <div class="row">
        <div class="col-xs-12"><!--Подвал--></div>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

</body>
</html>
