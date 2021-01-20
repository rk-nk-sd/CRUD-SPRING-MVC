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
        <div class="col-sm-9 col-lg-9"><a href="/admin/new-user" class="c">Добавить нового пользователя</a></div>
    </div>
    <div class="row castom">
        <%--        Меню--%>
        <div class="col-sm-4">
            <ul class="nav">
                <li class="nav-header">Главные ссылки</li>
                <li class="active"><a href="#">Главная</a></li>
                <li><a href="#">Обратная связь</a></li>
                <li><a href="#">Каталог</a></li>
                <li class="nav-header">Дополнительные</li>
                <li><a href="#">Наши филиалы</a></li>
                <li><a href="#">Календарь мероприятий</a></li>
                <li class="nav-divider"></li>
                <li><a href="#">Вакансии</a></li>
            </ul>
        </div>
        <%--    Основной контейнер--%>
        <div class="col-sm-8">Основной контейнер</div>
    </div>
    <div class="row">
        <div class="col-xs-12"><!--Подвал--></div>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

</body>
</html>
