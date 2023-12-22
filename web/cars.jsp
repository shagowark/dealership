<%@ page import="controllers.CarController" %><%--
  Created by IntelliJ IDEA.
  User: 003da
  Date: 21.12.2023
  Time: 8:34
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <title>dealership</title>
</head>
<body>
<a href="home.jsp">Основная страница</a>
<table border="1px solid black">
    <tr>
        <th>ID</th>
        <th>Тип</th>
        <th>Бренд</th>
        <th>Модель</th>
        <th></th>
    </tr>
    <c:forEach items="${carService.listAll()}" var="car">
    <tr>
        <td>${car.getId()}</td>
        <td>${car.getType().toString()}</td>
        <td>${car.getBrand()}</td>
        <td>${car.getModel()}</td>
        <td>
            <form action="/cars" method="post">
                <input type="hidden" name="id" value="${car.getId()}">
                <input type="hidden" name="method" value="delete">
                <p><input type="submit" value="Удалить"></p>
            </form>
        </td>
    </tr>
    </c:forEach>
</table>
<hr>
<b>Добавить машину</b>
<form action="/cars" method="post">
    <p><label>Тип машины<input type="text" name="type"></label></p>
    <p><label>Бренд машины<input type="text" name="brand"></label></p>
    <p><label>Модель машины<input type="text" name="model"></label></p>
    <input type="hidden" name="method" value="post">
    <p><input type="submit" value="Добавить"></p>
</form>

<b>Редактировать машину</b>
<form action="/cars" method="post">
    <p><label>ID машины<input type="text" name="id"></label></p>
    <p><label>Тип машины<input type="text" name="type"></label></p>
    <p><label>Бренд машины<input type="text" name="brand"></label></p>
    <p><label>Модель машины<input type="text" name="model"></label></p>
    <input type="hidden" name="method" value="put">
    <p><input type="submit" value="Изменить"></p>
</form>

</body>
</html>
