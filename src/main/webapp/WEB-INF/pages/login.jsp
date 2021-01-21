<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 21.01.2021
  Time: 13:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login form</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet"  type="text/css"/>
    <link href="${contextPath}/css/style.css" rel="stylesheet"  type="text/css"/>
</head>
<body>
<div  id="container">
<form method="post" action="/login">
    <input name="j_username"/>
    <input name="j_password"/>
    <input type="submit"/>
</form>
</div>
</body>
</html>
