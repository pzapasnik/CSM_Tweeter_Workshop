<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <style>
        .error {
            color:red;
            font-weight: bold;
        }
    </style>
</head>
<body>
<p>
<form:form modelAttribute="user" method="post">

    Email : <form:input path="email"/>
    <form:errors path="email" cssClass="error"/>

    Passworld : <form:password path="password"/>
    <form:errors path="password" cssClass="error"/>
    <input type="submit" value="Login"
    <br>
</form:form>
</p>

<a href="/register">Register New User</a>
</body>
</html>