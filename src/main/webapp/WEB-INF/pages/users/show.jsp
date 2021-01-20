<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 08.01.2021
  Time: 2:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<p>
<head>
    <title>Title</title>
    <link href="../../css/style.css" rel="stylesheet" type="text/css"/>
</head>
<p>
<h1>Текущий пользователь</h1>
<table>
    <tr>
        <td>Id</td>
        <td>${user.getId()}</td>
    </tr>
    <tr>
        <td>Имя</td>
        <td>${user.getLogin()}</td>
    </tr>
    <tr>
        <td>Пароль</td>
        <td>${user.getPassword()}</td>
    </tr>
    <tr>
        <td>Роль</td>
        <td>
            <c:forEach var="role" items="${user.roles}">
                ${role.name}
            </c:forEach>
        </td>
    </tr>
</table>
<hr/>
<a href="/users" class="c">Главная</a>

<a href="${user.id}/edit" class="c">Редактировать</a>
</p>
<form method="POST" actions="/users/${user.id}">
    <input type="hidden" name="_method" value="delete"/>
    <input type="submit" value="Delete"/>
</form>
</body>
</html>
