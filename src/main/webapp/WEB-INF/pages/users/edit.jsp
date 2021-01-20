<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 08.01.2021
  Time: 2:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="../../css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<h1>Обновить текущего пользователя</h1>

<form method="post" action="/users/<c:out value='${user.id}'/>">
    <input type="hidden" name="_method" value="patch"/>

    ID: <c:out value="${user.id}" />
    </p>

    Enter your login:
    <input type="text" name="login" value="${user.login}" />
    <c:if test="${empty user.login}">Note: you must enter a name</c:if>
    </p>

    Enter your password:
    <input type="text" name="password" value="${user.password}" />
    <c:if test="${noPassword}">Note: you must enter a name</c:if>
    </p>

    Enter your role:
    <input type="text" name="role" value="
        <c:forEach var="role" items="${user.roles}">
                ${role.name}
        </c:forEach>
    " />
    <c:if test="${noRole}">Note: you must enter a role</c:if>
    </p>

    <input type="submit" value="Сохранить" />
</form>

</body>
</html>
