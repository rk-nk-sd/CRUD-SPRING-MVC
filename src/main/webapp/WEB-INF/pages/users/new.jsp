<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 08.01.2021
  Time: 2:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<!DOCTYPE html>
<head>
    <title>Title</title>
    <link href="../../css/style.css" rel="stylesheet" type="text/css"/>
</head>

<h1>Создать нового пользователя</h1>
<hr/>
<c:if test="${empty param.login}" var="noLogin" />
<c:if test="${empty param.password}" var="noPassword" />
<c:if test="${empty param.role}" var="noRole" />

<c:if
    test="${not (noLogin or noPassword)}">
    <c:set value="${param.login}" var="login" scope="request"/>
    <c:set value="${param.password}" var="password" scope="request"/>
    <c:set value="${param.password}" var="role" scope="request"/>
    <jsp:forward page="admin" />
</c:if>

<form method="post" action="/users">

    Enter your login:
    <input type="text" name="name" value="${user.login}" />
    <c:if test="${noLogin}">Note: you must enter a name</c:if>
    </p>

    Enter your password:
    <input type="text" name="surname" value="${user.password}" />
    <c:if test="${noPassword}">Note: you must enter a password</c:if>
    </p>

    <input type="submit" value="Создать пользователя" />
</form>
</body>
</html>