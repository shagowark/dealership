<%--
  Created by IntelliJ IDEA.
  User: 003da
  Date: 21.12.2023
  Time: 9:48
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
        <th>ID машины</th>
        <th>ID клиента</th>
    </tr>
    <c:forEach items="${tradeService.listAll()}" var="trade">
        <tr>
            <td>${trade.getId()}</td>
            <td>${trade.getCarId()}</td>
            <td>${trade.getCustomerId()}</td>
        </tr>
    </c:forEach>
</table>

<b>Совершить сделку (продать машину)</b>
<form action="/trades" method="post">
    <p><label>ID машины<input type="text" name="carId"></label></p>
    <p><label>Фамилия<input type="text" name="customerLastName"></label></p>
    <p><label>Имя<input type="text" name="customerFirstName"></label></p>
    <p><label>Отчество<input type="text" name="customerMiddleName"></label></p>
    <p><label>Возраст<input type="number" name="customerAge"></label></p>
    <p><label>Пол<input type="text" name="customerGender"></label></p>
    <input type="hidden" name="method" value="put">
    <p><input type="submit" value="Добавить"></p>
</form>

</body>
</html>
