<%--
  Created by IntelliJ IDEA.
  User: 003da
  Date: 21.12.2023
  Time: 9:39
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
        <th>Фамилия</th>
        <th>Имя</th>
        <th>Отчество</th>
        <th>Возраст</th>
        <th>Пол</th>
        <th></th>
    </tr>
    <c:forEach items="${customerService.listAll()}" var="customer">
        <tr>
            <td>${customer.getId()}</td>
            <td>${customer.getLastName()}</td>
            <td>${customer.getFirstName()}</td>
            <td>${customer.getMiddleName()}</td>
            <td>${customer.getAge()}</td>
            <td>${customer.getGender().toString()}</td>
            <td>
                <form action="/customers" method="post">
                    <input type="hidden" name="id" value="${customer.getId()}">
                    <input type="hidden" name="method" value="delete">
                    <p><input type="submit" value="Удалить"></p>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<hr>
<b>Добавить покупателя</b>
<form action="/customers" method="post">
    <p><label>Фамилия<input type="text" name="lastName"></label></p>
    <p><label>Имя<input type="text" name="firstName"></label></p>
    <p><label>Отчество<input type="text" name="middleName"></label></p>
    <p><label>Возраст<input type="number" name="age"></label></p>
    <p><label>Пол<input type="text" name="gender"></label></p>
    <input type="hidden" name="method" value="post">
    <p><input type="submit" value="Добавить"></p>
</form>

<b>Редактировать покупателя</b>
<form action="/customers" method="post">
    <p><label>ID<input type="text" name="id"></label></p>
    <p><label>Фамилия<input type="text" name="lastName"></label></p>
    <p><label>Имя<input type="text" name="firstName"></label></p>
    <p><label>Отчество<input type="text" name="middleName"></label></p>
    <p><label>Возраст<input type="number" name="age"></label></p>
    <p><label>Пол<input type="text" name="gender"></label></p>
    <input type="hidden" name="method" value="put">
    <p><input type="submit" value="Изменить"></p>
</form>
</body>
</html>
