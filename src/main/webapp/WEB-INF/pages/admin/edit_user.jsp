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
        <div class="col-sm-6 col-lg-7"><h1>Редактировать пользователя</h1></div>
        <div class="col-sm-6 col-lg-5">
            <h6 class="hi">Привет, ${userinfo.name}! | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h6>
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <form id="logoutForm" method="post" action="${contextPath}/logout">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
            </c:if>
        </div>
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
                <li><a href="/users">Профиль</a></li>
                <li><a href="#">Календарь мероприятий</a></li>
                <li class="nav-divider"></li>
                <li><a href="#">Вакансии</a></li>
            </ul>
        </div>
        <%--    Основной контейнер--%>
        <div class="col-sm-8">
            <form method="post" action="/admin/users/<c:out value='${user.id}'/>">
                <input type="hidden" name="_method" value="patch"/>

                ID: <c:out value="${user.id}" />
                </p>

                Edit user login:
                <input type="text" name="login" value="${user.login}" />
                <c:if test="${empty user.login}">Note: you must enter a name</c:if>
                </p>

                Edit user password:
                <input type="text" name="password" value="${user.password}" />
                <c:if test="${noPassword}">Note: you must enter a name</c:if>
                </p>

                Edit user role:

                <p><select size="1" name="role">
                    <c:forEach var="role" items="${roles}">
                    <option value="${role.name}">${role.name}</option>
                    </c:forEach>
                </select></p>

<%--                <input type="text" name="role" value="--%>
<%--                        <c:forEach var="role" items="${user.roles}">--%>
<%--                                ${role.name}--%>
<%--                        </c:forEach>--%>
<%--                    " />--%>
                <c:if test="${noRole}">Note: you must enter a role</c:if>
                </p>

                <input type="submit" value="Сохранить" />
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
